package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.data.Record;
import org.nazarov.shaheen.decathlon.utils.enums.RecordAttribute;
import org.nazarov.shaheen.decathlon.utils.enums.Unit;
import org.nazarov.shaheen.decathlon.utils.io.FileUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nazarov
 * @version 1.0
 */
public class DecathlonCsvDeserializer extends FileUtils implements DecathlonDeserializer {

    private final String separator;

    public DecathlonCsvDeserializer(){
        this(";");
    }

    public DecathlonCsvDeserializer(String separator){
        this.separator = separator;
    }

    /**
     * Deserialize to list of athletes
     * @param lines of file
     * @return byte of data
     */
    private List<Athlete> deserializeToAthletes(List<String> lines) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        Athlete athlete;
        for (String line : lines) {
            final String[] elements = line.split(";");
            //empty line
            if(elements.length == 1)
                continue;
            athlete = new Athlete();
            for (int i = 0; i < elements.length; i++) {
                //for name
                if (i == 0)
                    athlete.setName(elements[i].trim());
                    //for results
                else {
                    athlete.getRecords().add(parseRecord(i - 1, elements[i]));
                }
            }
            athletes.add(athlete);
        }
        return athletes;
    }

    /**
     * Parsing Record class
     * @param i index of field
     * @param value value of field
     * @return record
     */
    private Record parseRecord(int i, String value){
        if(RecordAttribute.values()[i].equals(RecordAttribute.A_1500M)){
            // Parse the last fields that holds minutes
            String[] time = value.split("\\.", 2);
            if (time.length != 2) {
                throw new DecathlonFormatException(
                        "expected format mm.ss.SS");
            }
            return new Record(RecordAttribute.values()[i],
                    (Double.parseDouble(time[1]) + Integer.parseInt(time[0]) * 60));
        }
        Double val = Double.parseDouble(value.trim());
        // precision problem
        if(RecordAttribute.values()[i].getUnit().equals(Unit.CENTIMETERES)){
            BigDecimal decimal = BigDecimal.valueOf(val).multiply(BigDecimal.valueOf(100))
                    .setScale(3, RoundingMode.HALF_UP);
            return new Record(RecordAttribute.values()[i],
                    Double.parseDouble(decimal.toString()));
        }
        return new Record(RecordAttribute.values()[i], val);
    }

    /**
     * Get List of athletes from path
     * @param path path of file
     * @return athletes is array of athletes
     */
    @Override
    public List<Athlete> getAthletes(String path) throws IOException {
        Path filepath = get(path);
        return deserializeToAthletes(Files.readAllLines(filepath));
    }
}

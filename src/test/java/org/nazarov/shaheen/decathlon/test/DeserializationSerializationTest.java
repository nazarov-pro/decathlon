package org.nazarov.shaheen.decathlon.test;

import org.junit.Assert;
import org.junit.Test;
import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.utils.*;
import org.nazarov.shaheen.decathlon.utils.io.FileUtils;

import java.io.IOException;
import java.util.List;
/**
 * @author nazarov
 * @version 1.0
 */
public class DeserializationSerializationTest {

    @Test
    public void deserialization() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        Assert.assertEquals(athletes.size(), 4);
    }

    @Test
    public void serialization() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        DecathlonSerializer serializer = new DecathlonXmlSerializer();
        FileUtils fileUtils = new FileUtils();
        DecathlonCalculator calculator = new StandardDecathlonCalculator();
        calculator.fillAllAndSort(athletes);
        fileUtils.writeFile(serializer,athletes,"user.xml");
        Assert.assertEquals(athletes.size(), 4);
    }
}

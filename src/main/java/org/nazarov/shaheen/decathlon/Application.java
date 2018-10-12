package org.nazarov.shaheen.decathlon;

import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.utils.*;
import org.nazarov.shaheen.decathlon.utils.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 * @author nazarov
 * @version 1.0
 */
public class Application {

    private static final FileUtils fileUtils = new FileUtils();
    private static final DecathlonDeserializer deserializer = new DecathlonCsvDeserializer();
    private static final DecathlonSerializer serializer = new DecathlonXmlSerializer();
    private static final DecathlonCalculator calculator = new StandardDecathlonCalculator();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Decathlon Calculator");
        String path;
        while(true) {
            System.out.print("Please type input (path of csv file) [press enter for default] :");
            path = scanner.nextLine();
            if (path.trim().isEmpty()) {
                path = Constants.Default.INPUT_CSV_PATH;
                break;
            }else if(Files.exists(fileUtils.get(path))){
                break;
            }
        }
        System.out.print("Please type output path of xml file [press enter for default] :");
        String outputPath = scanner.nextLine();

        if(outputPath.isEmpty()){
            outputPath = Constants.Default.OUTPUT_XML_PATH;
        }

        System.out.println("Processing...");
        try {
            List<Athlete> athletes = deserializer.getAthletes(path);
            calculator.fillAllAndSort(athletes);
            fileUtils.writeFile(serializer, athletes, outputPath);
            System.out.printf("Output file successfully generated in %s",
                    fileUtils.get(outputPath).toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

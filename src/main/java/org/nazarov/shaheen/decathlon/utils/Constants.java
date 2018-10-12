package org.nazarov.shaheen.decathlon.utils;

/**
 * @author nazarov
 * @version 1.0
 */
public interface Constants {
    String CLASSPATH = "classpath:";
    double[][] formulaTable = {
            {25.4347, 18, 1.81},
            {0.14354, 220, 1.4},
            {51.39, 1.5, 1.05},
            {0.8465, 75, 1.42},
            {1.53775, 82, 1.81},
            {5.74352, 28.5, 1.92},
            {12.91, 4, 1.1},
            {0.2797, 100, 1.35},
            {10.14, 7, 1.08},
            {0.03768, 480, 1.85},
    };


    interface Default {
        String INPUT_CSV_PATH = CLASSPATH + "results.csv";
        String OUTPUT_XML_PATH = "results.xml";
    }
}


package org.nazarov.shaheen.decathlon.test;

import org.junit.Test;
import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.utils.*;

import java.io.IOException;
import java.util.List;

/**
 * @author nazarov
 * @version 1.0
 */
public class SortingTest {

    @Test
    public void sortingTest() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer()
                .getAthletes(Constants.Default.INPUT_CSV_PATH);
        DecathlonCalculator calculator = new StandardDecathlonCalculator();
        calculator.fillAllAndSort(athletes);
        athletes.forEach(System.out::println);
    }
}

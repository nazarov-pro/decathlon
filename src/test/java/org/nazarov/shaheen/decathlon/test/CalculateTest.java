package org.nazarov.shaheen.decathlon.test;

import org.junit.Assert;
import org.junit.Test;
import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.data.Record;
import org.nazarov.shaheen.decathlon.utils.Constants;
import org.nazarov.shaheen.decathlon.utils.DecathlonCsvDeserializer;
import org.nazarov.shaheen.decathlon.utils.StandardDecathlonCalculator;

import java.io.IOException;
import java.util.List;
/**
 * @author nazarov
 * @version 1.0
 */
public class CalculateTest {

    @Test
    public void calculateScoreOfOneEvent() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        StandardDecathlonCalculator calculator = new StandardDecathlonCalculator();
        Record record = athletes.get(0).getRecords().get(0);
        int score = calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula());
        Assert.assertEquals(score, 536);
    }

    //resource https://www.usatf.org/statistics/calculators/combinedEventsScoring/
    @Test
    public void calculateScoreOfOneByOne() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        StandardDecathlonCalculator calculator = new StandardDecathlonCalculator();
        List<Record> records = athletes.get(0).getRecords();
        int i = 0;
        Record record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 536);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 382);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 439);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 389);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 400);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 685);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 302);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 264);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 382);
        record = records.get(i++);
        Assert.assertEquals(calculator.calculatePoints(record.getValue(), record.getAttribute().getFormula()), 421);
    }

    @Test
    public void calculateScoreOfAllEvents() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        StandardDecathlonCalculator calculator = new StandardDecathlonCalculator();
        int score = calculator.calculateAllPoints(athletes.get(0).getRecords());
        Assert.assertEquals(score, 4200);
    }

    @Test
    public void calculateScoreOfAllEventsOfAthletes() throws IOException {
        List<Athlete> athletes = new DecathlonCsvDeserializer().getAthletes(Constants.Default.INPUT_CSV_PATH);
        StandardDecathlonCalculator calculator = new StandardDecathlonCalculator();
        calculator.fillAllScores(athletes);
        for(Athlete athlete: athletes) {
            System.out.println(athlete.getName() + ": " + athlete.getScore());
        }
    }
}

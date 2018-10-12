package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.data.Record;

import java.util.List;

/**
 * @author nazarov
 * @version 1.0
 */
public class StandardDecathlonCalculator extends DecathlonSorter implements DecathlonCalculator{



    /**
     * Fill all athletes scores
     * @param athletes is array of athletes
     * @return athletes with scores
     */
    @Override
    public void fillAllScores(List<Athlete> athletes){
        for(int i = 0; i < athletes.size(); i++)
            athletes.get(i).setScore(calculateAllPoints(athletes.get(i).getRecords()));
    }

    /**
     * Fill all athletes scores
     * @param athletes is array of athletes
     * @return athletes sorted with scores and rankings
     */
    @Override
    public void fillAllAndSort(List<Athlete> athletes) {
        fillAllScores(athletes);
        sort(athletes);
    }

    /**
     * Calculates formula: Points = INT(A(|B — P|)^C)
     * @param score is parameter P
     * @param a is parameter A
     * @param b is parameter B
     * @param c is parameter C
     * @return points
     */
    public int calculatePoints(double score,double a, double b, double c){
        return (int) Math.floor(a * Math.pow(Math.abs(score - b), c));
    }

    /**
     * Converting data
     * @param score is parameter P
     * @param params is array of parameter A,B,C respectively
     * @return points
     */
    public int calculatePoints(double score,double[] params){
        if(params.length != 3){
            throw new DecathlonFormatException("Expecting 3 values in array");
        }
        return calculatePoints(score, params[0], params[1], params[2]);
    }

    /**
     * Calculates all events score
     * @param records is array of records of all events
     * @return points of all events
     */
    public int calculateAllPoints(List<Record> records){
       int score = 0;
       for(Record record : records)
           score += calculatePoints(record.getValue().doubleValue(), record.getAttribute().getFormula());
       return score;
   }


}

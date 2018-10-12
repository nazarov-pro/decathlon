package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;

import java.util.*;

/**
 * @author nazarov
 * @version 1.0
 */
public class DecathlonSorter {

    /**
     * Sorting by rank
     *
     * @param athletes is array of athletes
     * @return void
     */
    public void sort(List<Athlete> athletes) {
        Collections.sort(athletes);
        Map<Integer, Integer> scores = new HashMap<>();
        athletes.forEach(a -> {
            if (scores.get(a.getScore()) == null)
                scores.put(a.getScore(), 1);
            else
                scores.put(a.getScore(),
                        scores.get(a.getScore()) + 1);
        });

        int lockedRank = 1;
        Integer sharedPlace;
        String tmp;
        for (int i = 0; i < athletes.size(); i++) {
            sharedPlace = scores.get(athletes.get(i).getScore());
            if (sharedPlace == 1) {
                athletes.get(i).setRank(String.valueOf(i + 1));
                lockedRank = i + 1;
            } else {
                tmp = "";
                for (int j = 1; j <= sharedPlace; j++)
                    tmp += (lockedRank + j) + "_";
                athletes.get(i).setRank(tmp.substring(0, tmp.length() - 1));
            }
            if(i < athletes.size() - 1 && (!sharedPlace.equals(scores.get(athletes.get(i+1).getScore()))))
                lockedRank = i + 1;
        }
    }
}

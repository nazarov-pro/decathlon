package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;

import java.util.List;

/**
 * @author nazarov
 * @version 1.0
 */
public interface DecathlonCalculator {
    void fillAllScores(List<Athlete> athletes);
    void fillAllAndSort(List<Athlete> athletes);
}

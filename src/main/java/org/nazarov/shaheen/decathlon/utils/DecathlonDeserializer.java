package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;

import java.io.IOException;
import java.util.List;
/**
 * @author nazarov
 * @version 1.0
 */
public interface DecathlonDeserializer {
    List<Athlete> getAthletes(String path) throws IOException;
}

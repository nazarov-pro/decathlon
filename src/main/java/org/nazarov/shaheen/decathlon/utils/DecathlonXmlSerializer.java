package org.nazarov.shaheen.decathlon.utils;

import org.nazarov.shaheen.decathlon.data.Athlete;
import org.nazarov.shaheen.decathlon.data.AthleteWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * @author nazarov
 * @version 1.0
 */
public class DecathlonXmlSerializer implements DecathlonSerializer{

    /**
     * Serialize to XML format
     * @param athletes is array of athletes
     * @return byte of data
     */
    @Override
    public byte[] serialize(List<Athlete> athletes) {
        AthleteWrapper result = new AthleteWrapper();
        result.setAthletes(athletes);
        try {
            JAXBContext context = JAXBContext.newInstance(AthleteWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            /** output the XML in pretty format */
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            marshaller.marshal(result, outputStream);
            return outputStream.toByteArray();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}

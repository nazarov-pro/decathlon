package org.nazarov.shaheen.decathlon.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
/**
 * @author nazarov
 * @version 1.0
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class AthleteWrapper implements Serializable {
    public static final long serialVersionUID = 777879L;

    @XmlElement(name = "entries")
    private Collection<Athlete> athletes;

    public Collection<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(Collection<Athlete> athletes) {
        this.athletes = athletes;
    }
}

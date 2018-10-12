package org.nazarov.shaheen.decathlon.data;

import org.nazarov.shaheen.decathlon.utils.enums.RecordAttribute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 * @author nazarov
 * @version 1.0
 */
@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record implements Serializable {
    public static final long serialVersionUID = 777880L;
    @XmlElement(name = "attribute")
    private RecordAttribute attribute;
    @XmlElement(name = "value")
    private Double value;

    public Record(RecordAttribute attribute, Double value) {
        this.attribute = attribute;
        this.value = value;
    }

    public Record() {

    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public RecordAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(RecordAttribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Record{" +
                "attribute=" + attribute +
                ", value=" + value +
                '}';
    }
}

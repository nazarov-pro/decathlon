package org.nazarov.shaheen.decathlon.utils.enums;

import org.nazarov.shaheen.decathlon.utils.Constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
public enum RecordAttribute {
    A_100M("100 m", Unit.SECONDS),
    A_LONG_JUMP("Long jump", Unit.CENTIMETERES),
    A_SHOT_PUT("Shot put", Unit.METRES),
    A_HIGH_JUMP("High jump", Unit.CENTIMETERES),
    A_400M("400 m", Unit.SECONDS),
    A_110M_HURDLES("110 m hurdles", Unit.SECONDS),
    A_DISCUS_THROW("Discus throw", Unit.METRES),
    A_POLE_VAULT("Pole vault", Unit.CENTIMETERES),
    A_JAVELIN_THROW("Javelin throw", Unit.METRES),
    A_1500M("1500 m", Unit.MINUTES_SECONDS);

    @XmlElement(name = "event")
    private String name;
    @XmlElement(name = "unit")
    private Unit unit;

    RecordAttribute(String name, Unit unit){
        this.name = name;
        this.unit = unit;
    }

    public String getName(){
        return this.name;
    }

    public Unit getUnit(){
        return this.unit;
    }

    public double[] getFormula(){
        return Constants.formulaTable[ordinal()];
    }

    @Override
    public String toString() {
        return "RecordAttribute{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}

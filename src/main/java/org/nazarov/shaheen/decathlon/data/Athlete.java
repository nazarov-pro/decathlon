package org.nazarov.shaheen.decathlon.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
/**
 * @author nazarov
 * @version 1.0
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Athlete implements Serializable, Comparable<Athlete>, Comparator<Athlete> {
    public static final long serialVersionUID = 777878L;

    @XmlElement(name = "athlete_name")
    private String name;
    @XmlElement(name = "records")
    private List<Record> records = new ArrayList<>();
    @XmlElement(name = "score")
    private Integer score = 0;
    @XmlElement(name = "rank")
    private String rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compare(Athlete athlete, Athlete t1) {
        return athlete.compareTo(t1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return Objects.equals(score, athlete.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public int compareTo(Athlete athlete) {
        if(athlete.getScore() > getScore()){
            return 1;
        }else if(athlete.getScore() < getScore())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", records=" + records +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }
}

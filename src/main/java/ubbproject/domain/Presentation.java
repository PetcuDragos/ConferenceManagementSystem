package ubbproject.domain;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Presentation extends BaseEntity<Integer>{
    private String section;
    private Time time;
    private int chairId;

    public Presentation() {
    }

    public Presentation(String section, Time time, int chairId) {
        this.section = section;
        this.time = time;
        this.chairId = chairId;
    }

    public Presentation(int id, String section, Time time, int chairId) {
        this.section = section;
        this.time = time;
        this.chairId = chairId;
        this.setId(id);
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getChairId() {
        return chairId;
    }

    public void setChairId(int chairId) {
        this.chairId = chairId;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "id='" + this.getId() +
                ", section='" + section +
                ", time=" + time +
                ", chairId=" + chairId +
                '}';
    }
}

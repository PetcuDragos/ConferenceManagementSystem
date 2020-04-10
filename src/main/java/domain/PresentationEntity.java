package domain;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Presentation", schema = "dbo", catalog = "conference")
public class PresentationEntity {
    private int presentationId;
    private String section;
    private Time time;

    @Id
    @Column(name = "PresentationID", nullable = false)
    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    @Basic
    @Column(name = "Section", nullable = true, length = 50)
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Basic
    @Column(name = "Time", nullable = true)
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresentationEntity that = (PresentationEntity) o;

        if (presentationId != that.presentationId) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presentationId;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}

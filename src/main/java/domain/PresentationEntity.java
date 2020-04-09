package domain;

import javax.persistence.*;

@Entity
@Table(name = "Presentation", schema = "dbo", catalog = "conference")
public class PresentationEntity {
    private Integer presentationId;
    private String section;
    private Object time;

    @Id
    @Column(name = "PresentationID")
    public Integer getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Integer presentationId) {
        this.presentationId = presentationId;
    }

    @Basic
    @Column(name = "Section")
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Basic
    @Column(name = "Time")
    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresentationEntity that = (PresentationEntity) o;

        if (presentationId != null ? !presentationId.equals(that.presentationId) : that.presentationId != null)
            return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = presentationId != null ? presentationId.hashCode() : 0;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}

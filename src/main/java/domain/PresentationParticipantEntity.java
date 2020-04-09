package domain;

import javax.persistence.*;

@Entity
@Table(name = "PresentationParticipant", schema = "dbo", catalog = "conference")
@IdClass(PresentationParticipantEntityPK.class)
public class PresentationParticipantEntity {
    private int participantId;
    private int presentationId;
    private int prRoleId;

    @Id
    @Column(name = "ParticipantID", nullable = false)
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Id
    @Column(name = "PresentationID", nullable = false)
    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    @Id
    @Column(name = "PrRoleID", nullable = false)
    public int getPrRoleId() {
        return prRoleId;
    }

    public void setPrRoleId(int prRoleId) {
        this.prRoleId = prRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresentationParticipantEntity that = (PresentationParticipantEntity) o;

        if (participantId != that.participantId) return false;
        if (presentationId != that.presentationId) return false;
        if (prRoleId != that.prRoleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = participantId;
        result = 31 * result + presentationId;
        result = 31 * result + prRoleId;
        return result;
    }
}

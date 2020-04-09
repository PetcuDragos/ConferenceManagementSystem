package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PresentationParticipantEntityPK implements Serializable {
    private int participantId;
    private int presentationId;
    private int prRoleId;

    @Column(name = "ParticipantID", nullable = false)
    @Id
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Column(name = "PresentationID", nullable = false)
    @Id
    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    @Column(name = "PrRoleID", nullable = false)
    @Id
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

        PresentationParticipantEntityPK that = (PresentationParticipantEntityPK) o;

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

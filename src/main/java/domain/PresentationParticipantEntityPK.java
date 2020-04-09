package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PresentationParticipantEntityPK implements Serializable {
    private Integer participantId;
    private Integer presentationId;
    private Integer prRoleId;

    @Column(name = "ParticipantID")
    @Id
    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    @Column(name = "PresentationID")
    @Id
    public Integer getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Integer presentationId) {
        this.presentationId = presentationId;
    }

    @Column(name = "PrRoleID")
    @Id
    public Integer getPrRoleId() {
        return prRoleId;
    }

    public void setPrRoleId(Integer prRoleId) {
        this.prRoleId = prRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresentationParticipantEntityPK that = (PresentationParticipantEntityPK) o;

        if (participantId != null ? !participantId.equals(that.participantId) : that.participantId != null)
            return false;
        if (presentationId != null ? !presentationId.equals(that.presentationId) : that.presentationId != null)
            return false;
        if (prRoleId != null ? !prRoleId.equals(that.prRoleId) : that.prRoleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = participantId != null ? participantId.hashCode() : 0;
        result = 31 * result + (presentationId != null ? presentationId.hashCode() : 0);
        result = 31 * result + (prRoleId != null ? prRoleId.hashCode() : 0);
        return result;
    }
}

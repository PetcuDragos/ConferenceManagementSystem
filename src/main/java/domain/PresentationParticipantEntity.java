package domain;

import javax.persistence.*;

@Entity
@Table(name = "PresentationParticipant", schema = "dbo", catalog = "conference")
@IdClass(PresentationParticipantEntityPK.class)
public class PresentationParticipantEntity {
    private Integer participantId;
    private Integer presentationId;
    private Integer prRoleId;

    @Id
    @Column(name = "ParticipantID")
    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    @Id
    @Column(name = "PresentationID")
    public Integer getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Integer presentationId) {
        this.presentationId = presentationId;
    }

    @Id
    @Column(name = "PrRoleID")
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

        PresentationParticipantEntity that = (PresentationParticipantEntity) o;

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

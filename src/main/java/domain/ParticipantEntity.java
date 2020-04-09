package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participant", schema = "dbo", catalog = "conference")
public class ParticipantEntity {
    private int participantId;

    @Id
    @Column(name = "ParticipantID", nullable = false)
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantEntity that = (ParticipantEntity) o;

        if (participantId != that.participantId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return participantId;
    }
}

package domain;

import javax.persistence.Entity;

@Entity
public class PresentationParticipant extends BaseEntity<Integer> {
    private int participantID;
    private int presentationId;
    private int presentationRoleId;

    public PresentationParticipant() {
    }

    public PresentationParticipant(int participantID, int presentationId, int presentationRoleId) {
        this.participantID = participantID;
        this.presentationId = presentationId;
        this.presentationRoleId = presentationRoleId;
    }

    public PresentationParticipant(int id, int participantID, int presentationId, int presentationRoleId) {
        this.participantID = participantID;
        this.presentationId = presentationId;
        this.presentationRoleId = presentationRoleId;
        this.setId(id);
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    public int getPresentationRoleId() {
        return presentationRoleId;
    }

    public void setPresentationRoleId(int pcRoleId) {
        this.presentationRoleId = pcRoleId;
    }

    @Override
    public String toString() {
        return "PresentationParticipant{" +
                "id=" + this.getId() +
                "participantID=" + participantID +
                ", presentationId=" + presentationId +
                ", pcRoleId=" + presentationRoleId +
                '}';
    }
}

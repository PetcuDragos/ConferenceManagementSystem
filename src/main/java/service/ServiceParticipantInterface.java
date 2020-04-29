package service;

import domain.Participant;

import java.util.List;

public interface ServiceParticipantInterface {

    void addParticipant(Participant participant);

    void deleteParticipant(Integer id);

    void updateParticipant(Participant participant);

    List<Participant> getAllParticipants();
}

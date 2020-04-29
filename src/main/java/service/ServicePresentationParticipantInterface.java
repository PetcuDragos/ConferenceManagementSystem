package service;

import domain.PresentationParticipant;

import java.util.List;

public interface ServicePresentationParticipantInterface {

    void addPresentationParticipant(PresentationParticipant presentationParticipant);

    void deletePresentationParticipant(Integer id);

    void updatePresentationParticipant(PresentationParticipant presentationParticipant);

    List<PresentationParticipant> getAllPresentationParticipants();
}

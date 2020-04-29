package service;

import domain.Presentation;

import java.util.List;

public interface ServicePresentationInterface {

    void addPresentation(Presentation presentation);

    void deletePresentation(Integer id);

    void updatePresentation(Presentation presentation);

    List<Presentation> getAllPresentations();
}

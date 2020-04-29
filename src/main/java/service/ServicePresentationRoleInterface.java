package service;

import domain.PresentationRole;

import java.util.List;

public interface ServicePresentationRoleInterface {

    void addPresentationRole(PresentationRole presentationRole);

    void deletePresentationRole(Integer id);

    void updatePresentationRole(PresentationRole presentationRole);

    List<PresentationRole> getAllPresentationRoles();
}

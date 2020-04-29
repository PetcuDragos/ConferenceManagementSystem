package ubbproject.service;

import ubbproject.domain.PcRole;

import java.util.List;

public interface ServicePcRoleInterface {

    void addPcRole(PcRole pcRole);

    void deletePcRole(Integer id);

    void updatePcRole(PcRole pcRole);

    List<PcRole> getAllPcRoles();
}

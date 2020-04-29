package service;

import domain.PcMember;

import java.util.List;

public interface ServicePcMemberInterface {

    void addPcMember(PcMember pcMember);

    void deletePcMember(Integer id);

    void updatePcMember(PcMember pcMember);

    List<PcMember> getAllPcMembers();
}

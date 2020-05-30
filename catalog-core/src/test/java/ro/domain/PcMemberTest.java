package ro.domain;

import junit.framework.TestCase;

import java.util.Optional;

public class PcMemberTest extends TestCase {

    private PcMember pcMember;

    public void setUp() throws Exception {
        pcMember = new PcMember(1L, 6L);
    }

    public void testGetConference_id() {
        assertEquals(Optional.of(6L), java.util.Optional.ofNullable(pcMember.getConference_id()));
    }

    public void testSetConference_id() {
        pcMember.setConference_id(7L);
        assertEquals(Optional.of(7L), java.util.Optional.ofNullable(pcMember.getConference_id()));
    }

    public void testGetUser_id() {
        assertEquals(Optional.of(1L), java.util.Optional.ofNullable(pcMember.getUser_id()));
    }

    public void testSetUser_id() {
        pcMember.setUser_id(2L);
        assertEquals(Optional.of(2L), java.util.Optional.ofNullable(pcMember.getUser_id()));
    }
}

package ro.domain;

import junit.framework.TestCase;

public class ScMemberTest extends TestCase {

    private ScMember scMember;
    public void setUp() throws Exception {
       scMember = new ScMember(1L);
    }

    public void testGetUser_id() {
        assertEquals(java.util.Optional.of(1L),java.util.Optional.ofNullable(scMember.getUser_id()));
    }

    public void testSetUser_id() {
        scMember.setUser_id(2L);
        assertEquals(java.util.Optional.of(2L),java.util.Optional.ofNullable(scMember.getUser_id()));
    }
}
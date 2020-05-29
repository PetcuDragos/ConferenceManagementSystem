package ro.domain;

import junit.framework.TestCase;

public class CChairTest extends TestCase {

    private CChair cChair;
    public void setUp() throws Exception {
        cChair = new CChair((long)1,(long)2);
    }

    public void testGetUser_id() {
        assertEquals(java.util.Optional.of(1L),java.util.Optional.ofNullable(cChair.getUser_id()));
    }

    public void testGetConference_id() {
        assertEquals(java.util.Optional.of(2L),java.util.Optional.ofNullable(cChair.getConference_id()));
    }

    public void testSetUser_id() {
        cChair.setUser_id(3L);
        assertEquals(java.util.Optional.of(3L),java.util.Optional.ofNullable(cChair.getUser_id()));
    }

    public void testSetConference_id() {
        cChair.setConference_id(4L);
        assertEquals(java.util.Optional.of(4L),java.util.Optional.ofNullable(cChair.getConference_id()));
    }
}
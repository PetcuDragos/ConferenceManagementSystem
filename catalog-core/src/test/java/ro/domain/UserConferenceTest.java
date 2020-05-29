package ro.domain;

import junit.framework.TestCase;

public class UserConferenceTest extends TestCase {

    private UserConference userConference;
    public void setUp() throws Exception {
       userConference = new UserConference(1L,2L);
    }

    public void testGetConference_id() {
        assertEquals(java.util.Optional.of(1L),java.util.Optional.ofNullable(userConference.getConference_id()));

    }

    public void testGetUser_id() {
        assertEquals(java.util.Optional.of(2L),java.util.Optional.ofNullable(userConference.getUser_id()));

    }

    public void testSetConference_id() {
        userConference.setConference_id(3L);
        assertEquals(java.util.Optional.of(3L),java.util.Optional.ofNullable(userConference.getConference_id()));

    }

    public void testSetUser_id() {
        userConference.setUser_id(4L);
        assertEquals(java.util.Optional.of(4L),java.util.Optional.ofNullable(userConference.getUser_id()));

    }
}
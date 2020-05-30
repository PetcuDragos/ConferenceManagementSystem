package ro.domain;

import junit.framework.TestCase;

import java.util.Optional;

public class SectionTest extends TestCase {

    private Section section;

    public void setUp() throws Exception {
        section = new Section(1L, 11L, "name");
    }

    public void testGetUser_id() {
        assertEquals(Optional.of(1L), java.util.Optional.ofNullable(section.getUser_id()));
    }

    public void testGetConference_id() {
        assertEquals(Optional.of(11L), java.util.Optional.ofNullable(section.getConference_id()));
    }

    public void testTestGetName() {
    }

    public void testSetUser_id() {
        section.setUser_id(2L);
        assertEquals(Optional.of(2L), java.util.Optional.ofNullable(section.getUser_id()));
    }

    public void testSetConference_id() {
        assertEquals("name", section.getName());
    }

    public void testTestSetName() {
        section.setName("name2");
        assertEquals("name2", section.getName());
    }
}

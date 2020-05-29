package ro.domain;

import junit.framework.TestCase;

public class AuthorTest extends TestCase {

    private Author author;
    public void setUp() throws Exception {
        this.author=new Author(1L, 2L);
    }

    public void testGetConference_id() {
        assertEquals(java.util.Optional.of(2L), java.util.Optional.ofNullable(this.author.getConference_id()));
    }

    public void testSetConference_id() {
        this.author.setConference_id(3L);
        assertEquals(java.util.Optional.of(3L), java.util.Optional.ofNullable(this.author.getConference_id()));
    }

    public void testGetUser_id() {
        assertEquals(java.util.Optional.of(1L), java.util.Optional.ofNullable(this.author.getUser_id()));
    }

    public void testSetUser_id() {
        this.author.setUser_id(3L);
        assertEquals(java.util.Optional.of(3L), java.util.Optional.ofNullable(this.author.getUser_id()));
    }
}
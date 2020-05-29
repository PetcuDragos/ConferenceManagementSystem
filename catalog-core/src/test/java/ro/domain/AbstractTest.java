package ro.domain;

import junit.framework.TestCase;

public class AbstractTest extends TestCase {

    private Abstract anAbstract;

    public void setUp() throws Exception {
        anAbstract = new Abstract("keywords", "topics", "name", "additionalAuthors", "content", 1l, 1l);
    }

    public void testSetConference_id() {
        this.anAbstract.setConference_id(1L);
        assertEquals("setConference_id", java.util.Optional.of(1L), java.util.Optional.ofNullable(this.anAbstract.getConference_id()));
    }

    public void testGetKeywords() {
        assertEquals("keywords", this.anAbstract.getKeywords());
    }

    public void testSetKeywords() {
        this.anAbstract.setKeywords("key");
        assertEquals("key", this.anAbstract.getKeywords());
    }

    public void testGetTopics() {
        assertEquals("topics", this.anAbstract.getTopics());
    }

    public void testSetTopics() {
        this.anAbstract.setTopics("top");
        assertEquals("top", this.anAbstract.getTopics());
    }

    public void testTestGetName() {
        assertEquals("name", this.anAbstract.getName());
    }

    public void testTestSetName() {
        this.anAbstract.setName("nume");
        assertEquals("nume", this.anAbstract.getName());
    }

    public void testGetAdditionalAuthors() {
        assertEquals("additionalAuthors", this.anAbstract.getAdditionalAuthors());
    }

    public void testSetAdditionalAuthors() {
        this.anAbstract.setAdditionalAuthors("auth");
        assertEquals("auth", this.anAbstract.getAdditionalAuthors());
    }

    public void testGetContent() {
        assertEquals("content", this.anAbstract.getContent());
    }

    public void testSetContent() {
        this.anAbstract.setContent("c");
        assertEquals("c", this.anAbstract.getContent());
    }

    public void testGetAuthor_id() {
        assertEquals(java.util.Optional.of(1L), java.util.Optional.ofNullable(this.anAbstract.getAuthor_id()));
    }

}
package ro.domain;

import junit.framework.TestCase;

public class PaperTest extends TestCase {

    private Paper paper;
    public void setUp() throws Exception {
        paper = new Paper(1L,"doc",2L,3L,1);
    }

    public void testGetAbstract_id() {
        assertEquals(java.util.Optional.of(1L),java.util.Optional.ofNullable(paper.getAbstract_id()));
    }

    public void testGetDocument() {
        assertEquals("doc",paper.getDocument());
    }

    public void testGetConference_id() {
        assertEquals(java.util.Optional.of(2L),java.util.Optional.ofNullable(paper.getConference_id()));
    }

    public void testGetAuthor_id() {
        assertEquals(java.util.Optional.of(3L),java.util.Optional.ofNullable(paper.getAuthor_id()));
    }

    public void testGetReEvaluated() {
        assertEquals(java.util.Optional.of(1),java.util.Optional.of(paper.getReEvaluated()));
    }

    public void testSetAbstract_id() {
        paper.setAbstract_id(4L);
        assertEquals(java.util.Optional.of(4L),java.util.Optional.ofNullable(paper.getAbstract_id()));
    }

    public void testSetDocument() {
        paper.setDocument("doc2");
        assertEquals("doc2",paper.getDocument());
    }

    public void testSetConference_id() {
        paper.setConference_id(5L);
        assertEquals(java.util.Optional.of(5L),java.util.Optional.ofNullable(paper.getConference_id()));
    }

    public void testSetAuthor_id() {
        paper.setAuthor_id(6L);
        assertEquals(java.util.Optional.of(6L),java.util.Optional.ofNullable(paper.getAuthor_id()));

    }

    public void testSetReEvaluated() {
        paper.setReEvaluated(2);
        assertEquals(java.util.Optional.of(2),java.util.Optional.of(paper.getReEvaluated()));
    }
}
package ro.domain;

import junit.framework.TestCase;

import java.sql.Date;
import java.util.Optional;

public class ConferenceTest extends TestCase {

    private Conference conference;

    public void setUp() throws Exception {
        conference = new Conference("name",
                new Date(1000), new Date(2000), new Date(3000), new Date(4000), new Date(5000), new Date(6000), new Date(7000), new Date(8000),
                1L, 11L);
    }

    public void testTestGetName() {
        assertEquals("name", conference.getName());
    }

    public void testGetAbstractDeadline() {
        assertEquals(new Date(1000), conference.getAbstractDeadline());
    }

    public void testGetPaperDeadline() {
        assertEquals(new Date(2000), conference.getPaperDeadline());
    }

    public void testGetBidDeadline() {
        assertEquals(new Date(3000), conference.getBidDeadline());
    }

    public void testGetReviewDeadline() {
        assertEquals(new Date(4000), conference.getReviewDeadline());
    }

    public void testGetStartingDate() {
        assertEquals(new Date(5000), conference.getStartingDate());
    }

    public void testGetEndingDate() {
        assertEquals(new Date(6000), conference.getEndingDate());
    }

    public void testGetReEvalDate() {
        assertEquals(new Date(7000), conference.getReEvalDate());
    }

    public void testGetSubmissionDate() {
        assertEquals(new Date(8000), conference.getSubmissionDate());
    }

    public void testGetChair_id() {
        assertEquals(Optional.of(1L), Optional.ofNullable(conference.getChair_id()));
    }

    public void testGetCo_chair_id() {
        assertEquals(Optional.of(11L), Optional.ofNullable(conference.getCo_chair_id()));
    }

    public void testTestSetName() {
        conference.setName("name2");
        assertEquals("name2", conference.getName());
    }

    public void testSetAbstractDeadline() {
        conference.setAbstractDeadline(new Date(10000));
        assertEquals(new Date(10000), conference.getAbstractDeadline());
    }

    public void testSetPaperDeadline() {
        conference.setPaperDeadline(new Date(20000));
        assertEquals(new Date(20000), conference.getPaperDeadline());
    }

    public void testSetBidDeadline() {
        conference.setBidDeadline(new Date(30000));
        assertEquals(new Date(30000), conference.getBidDeadline());
    }

    public void testSetReviewDeadline() {
        conference.setReviewDeadline(new Date(40000));
        assertEquals(new Date(40000), conference.getReviewDeadline());
    }

    public void testSetStartingDate() {
        conference.setStartingDate(new Date(50000));
        assertEquals(new Date(50000), conference.getStartingDate());
    }

    public void testSetEndingDate() {
        conference.setEndingDate(new Date(60000));
        assertEquals(new Date(60000), conference.getEndingDate());
    }

    public void testSetReEvalDate() {
        conference.setReEvalDate(new Date(70000));
        assertEquals(new Date(70000), conference.getReEvalDate());
    }

    public void testSetSubmissionDate() {
        conference.setSubmissionDate(new Date(80000));
        assertEquals(new Date(80000), conference.getSubmissionDate());
    }

    public void testSetChair_id() {
        conference.setChair_id(2L);
        assertEquals(Optional.of(2L), Optional.ofNullable(conference.getChair_id()));
    }

    public void testSetCo_chair_id() {
        conference.setCo_chair_id(22L);
        assertEquals(Optional.of(22L), Optional.ofNullable(conference.getCo_chair_id()));
    }
}

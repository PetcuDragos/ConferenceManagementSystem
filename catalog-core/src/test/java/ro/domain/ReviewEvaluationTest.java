package ro.domain;

import junit.framework.TestCase;

import java.sql.Date;
import java.util.Optional;

public class ReviewEvaluationTest extends TestCase {

    private ReviewEvaluation reviewEvaluation;

    public void setUp() throws Exception {
        reviewEvaluation = new ReviewEvaluation(1L, 11L, 0,
                new Date(1000), "content");
    }

    public void testGetPc_id() {
        assertEquals(Optional.of(1L), java.util.Optional.ofNullable(reviewEvaluation.getPc_id()));
    }

    public void testGetPaper_id() {
        assertEquals(Optional.of(11L), java.util.Optional.ofNullable(reviewEvaluation.getPaper_id()));
    }

    public void testGetResult() {
        assertEquals(Optional.of(0), java.util.Optional.ofNullable(reviewEvaluation.getResult()));
    }

    public void testGetDate() {
        assertEquals(new Date(1000), reviewEvaluation.getDate());
    }

    public void testGetContent() {
        assertEquals("content", reviewEvaluation.getContent());
    }

    public void testSetPc_id() {
        reviewEvaluation.setPc_id(2L);
        assertEquals(Optional.of(2L), java.util.Optional.ofNullable(reviewEvaluation.getPc_id()));
    }

    public void testSetPaper_id() {
        reviewEvaluation.setPaper_id(22L);
        assertEquals(Optional.of(22L), java.util.Optional.ofNullable(reviewEvaluation.getPaper_id()));
    }

    public void testSetResult() {
        reviewEvaluation.setResult(1);
        assertEquals(Optional.of(1), java.util.Optional.ofNullable(reviewEvaluation.getResult()));
    }

    public void testSetDate() {
        reviewEvaluation.setDate(new Date(2000));
        assertEquals(new Date(2000), reviewEvaluation.getDate());
    }

    public void testSetContent() {
        reviewEvaluation.setContent("content2");
        assertEquals("content2", reviewEvaluation.getContent());
    }
}

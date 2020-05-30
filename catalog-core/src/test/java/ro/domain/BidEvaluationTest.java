package ro.domain;

import junit.framework.TestCase;

import java.sql.Date;
import java.util.Optional;

public class BidEvaluationTest extends TestCase {

    private BidEvaluation bidEvaluation;

    public void setUp() throws Exception {
        bidEvaluation = new BidEvaluation(1L, 2L, 1, new Date(1000));
    }

    public void testGetPc_id() {
        assertEquals(java.util.Optional.of(1L), Optional.ofNullable(bidEvaluation.getPc_id()));
    }

    public void testGetAbstract_id() {
        assertEquals(java.util.Optional.of(2L), Optional.ofNullable(bidEvaluation.getAbstract_id()));
    }

    public void testGetResult() {
        assertEquals(java.util.Optional.of(1), Optional.ofNullable(bidEvaluation.getResult()));
    }

    public void testGetDate() {
        assertEquals(new Date(1000), bidEvaluation.getDate());
    }

    public void testSetPc_id() {
        bidEvaluation.setPc_id(10L);
        assertEquals(java.util.Optional.of(10L), Optional.ofNullable(bidEvaluation.getPc_id()));
    }

    public void testSetAbstract_id() {
        bidEvaluation.setAbstract_id(20L);
        assertEquals(java.util.Optional.of(20L), Optional.ofNullable(bidEvaluation.getAbstract_id()));
    }

    public void testSetResult() {
        bidEvaluation.setResult(2);
        assertEquals(java.util.Optional.of(2), Optional.ofNullable(bidEvaluation.getResult()));
    }

    public void testSetDate() {
        bidEvaluation.setDate(new Date(2000));
        assertEquals(new Date(2000), bidEvaluation.getDate());
    }
}

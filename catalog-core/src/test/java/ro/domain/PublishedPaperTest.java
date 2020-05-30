package ro.domain;

import junit.framework.TestCase;

public class PublishedPaperTest extends TestCase {

    private PublishedPaper publishedPaper;
    public void setUp() throws Exception {
        publishedPaper = new PublishedPaper(1L,2L);
    }

    public void testGetPaper_id() {
        assertEquals(java.util.Optional.of(1L),java.util.Optional.ofNullable(publishedPaper.getPaper_id()));
    }

    public void testSetPaper_id() {
        publishedPaper.setPaper_id(3L);
        assertEquals(java.util.Optional.of(3L),java.util.Optional.ofNullable(publishedPaper.getPaper_id()));
    }

    public void testGetSection_id() {
        assertEquals(java.util.Optional.of(2L),java.util.Optional.ofNullable(publishedPaper.getSection_id()));
    }

    public void testSetSection_id() {
        publishedPaper.setSection_id(4L);
        assertEquals(java.util.Optional.of(4L),java.util.Optional.ofNullable(publishedPaper.getSection_id()));
    }
}
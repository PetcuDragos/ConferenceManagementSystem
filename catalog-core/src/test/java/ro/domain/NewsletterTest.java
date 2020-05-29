package ro.domain;

import junit.framework.TestCase;

public class NewsletterTest extends TestCase {

    private Newsletter newsletter;

    public void setUp() throws Exception {
        newsletter = new Newsletter("name", "email", false);
    }

    public void testTestGetName() {
        assertEquals("name", newsletter.getName());
    }

    public void testTestSetName() {
        newsletter.setName("name2");
        assertEquals("name2", newsletter.getName());
    }

    public void testGetEmail() {
        assertEquals("email", newsletter.getEmail());
    }

    public void testSetEmail() {
        newsletter.setEmail("email2");
        assertEquals("email2", newsletter.getEmail());
    }

    public void testGetDailyNewsletter() {
        assertEquals(Boolean.valueOf(false), Boolean.valueOf(newsletter.getDailyNewsletter()));
    }

    public void testSetDailyNewsletter() {
        newsletter.setDailyNewsletter(true);
        assertEquals(Boolean.valueOf(true), Boolean.valueOf(newsletter.getDailyNewsletter()));
    }
}

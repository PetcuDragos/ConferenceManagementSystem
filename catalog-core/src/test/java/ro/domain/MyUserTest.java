package ro.domain;

import junit.framework.TestCase;

public class MyUserTest extends TestCase {

    private MyUser myUser;
    public void setUp() throws Exception {
        myUser = new MyUser("name","pass","email@yahoo.com","Full Name","affil","web.com");
    }

    public void testGetFullName() {
        assertEquals("Full Name",myUser.getFullName());
    }

    public void testSetFullName() {
        myUser.setFullName("Full Name2");
        assertEquals("Full Name2",myUser.getFullName());
    }

    public void testGetAffiliation() {
        assertEquals("affil",myUser.getAffiliation());
    }

    public void testSetAffiliation() {
        myUser.setAffiliation("affil2");
        assertEquals("affil2",myUser.getAffiliation());
    }

    public void testGetEmail() {
        assertEquals("email@yahoo.com",myUser.getEmail());
    }

    public void testSetEmail() {
        myUser.setEmail("email2@gmail.com");
        assertEquals("email2@gmail.com",myUser.getEmail());
    }

    public void testGetUsername() {
        assertEquals("name",myUser.getUsername());
    }

    public void testSetUsername() {
        myUser.setUsername("name2");
        assertEquals("name2",myUser.getUsername());
    }

    public void testGetPassword() {
        assertEquals("pass",myUser.getPassword());
    }

    public void testSetPassword() {
        myUser.setPassword("pass2");
        assertEquals("pass2",myUser.getPassword());
    }


    public void testGetWeb_page() {
        assertEquals("web.com",myUser.getWeb_page());
    }

    public void testSetWeb_page() {
        myUser.setWeb_page("web2.com");
        assertEquals("web2.com",myUser.getWeb_page());
    }
}
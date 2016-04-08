

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KioskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KioskTest
{
    /**
     * Default constructor for test class RegisterTest
     */
    public KioskTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    /**
     * Tests that none of the methods return null
     */
    public void testRegister()
    {
        Kiosk kiosk1 = new Kiosk();
        Publisher publishe1 = new Publisher("gyldendal");
        Book book1 = new Book("MC", "John", publishe1);
        assertNotNull(kiosk1.findLitteratureByAuthor("Bob"));
        assertNotNull(kiosk1.findLitteratureByAuthor("John"));
        assertNotNull(kiosk1.findLitteratureByName("Harry Potter"));
        assertNotNull(kiosk1.findLitteratureByName("MC"));
        assertNotNull(kiosk1.findLitteratureByPublisherName(null));
        assertNotNull(kiosk1.findLitteratureByPublisherName(publishe1));
    }
}


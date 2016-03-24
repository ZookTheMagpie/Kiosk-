

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RegisterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RegisterTest
{
    /**
     * Default constructor for test class RegisterTest
     */
    public RegisterTest()
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
        Register register1 = new Register();
        Publisher publishe1 = new Publisher("gyldendal");
        Book book1 = new Book("MC", "John", publishe1);
        register1.addLitterature(publishe1, book1);
        assertNotNull(register1.findLitteratureByAuthor("Bob"));
        assertNotNull(register1.findLitteratureByAuthor("John"));
        assertNotNull(register1.findLitteratureByName("Harry Potter"));
        assertNotNull(register1.findLitteratureByName("MC"));
        assertNotNull(register1.findBookByPublisher(null));
        assertNotNull(register1.findBookByPublisher(publishe1));
    }
}


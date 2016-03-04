

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PublisherTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PublisherTest
{
    /**
     * Default constructor for test class PublisherTest
     */
    public PublisherTest()
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
     * Tests if it finds correct publisher.
     */
    public void testGetName()
    {
        Publisher publishe1 = new Publisher("Golden");
        assertSame("Golden", publishe1.getName());
    }
}


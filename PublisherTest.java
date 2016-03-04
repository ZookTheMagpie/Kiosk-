

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
    /**
     * Asserts that the entered name is correct
     */
    @Test
    
    public void testPublisher()
    {
        Publisher publishe1 = new Publisher("John");
        assertEquals("John", publishe1.getName());
    }
    
    /**
     * Asserts that null is returned if publisher is null
     */
    @Test
    public void publisherNullTest()
    {
        Publisher publishe2 = new Publisher(null);
        assertNull(publishe2.getName());
    }
}



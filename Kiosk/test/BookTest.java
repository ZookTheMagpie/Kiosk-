

import org.junit.Assert.*;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
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
     * Tests that creating a book works as intended
     */
    @Test
    public void testCreateBook()
    {
        Publisher publishe1 = new Publisher("John");
        Book book1 = new Book("Javabook", "John Java", publishe1, 1);
        assertEquals("John Java", book1.getAuthor());
        assertEquals(publishe1, book1.getPublisher());
        assertEquals("Javabook", book1.getTitle());
    }
    
    /**
     * Asserts that if null is entered, it returns null.
     */
    
    @Test
    public void testNullBook()
    {
        Book book1 = new Book(null, null, null, 0);
        assertNull(book1.getAuthor());
        assertNull(book1.getPublisher());
        assertNull(book1.getTitle());
    }
}





import static org.junit.Assert.*;
import org.junit.After;
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
    private Publisher publishe1;
    private Publisher publishe2;
    private Book book1;


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
        publishe1 = new Publisher("Golden");
        publishe2 = new Publisher("Voyager");
        book1 = new Book("Norge", "Frans", publishe1);
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
    public void testAddBook()
    {
        Book book2 = new Book("Lord of the Rings", "Tolkien", publishe2);
    }

    @Test
    public void testGetAuthor()
    {
        assertSame("Frans", book1.getAuthor());
    }

    @Test
    public void testGetPublisher()
    {
        assertSame(publishe1, book1.getPublisher());
    }

    @Test
    public void testGetTitle()
    {
        assertSame("Norge", book1.getTitle());
    }
}











import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
<<<<<<< HEAD
 * @author  André
 * @version 04.03.2016
 */
public class BookTest
{
    private Publisher publishe1;
    private Publisher publishe2;
    private Book book1;


=======
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f
    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
    {
    }

    /**
     * Sets up the test fixture.
<<<<<<< HEAD
     * Makes the necessary instances for the tests.
=======
     *
>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
<<<<<<< HEAD
        publishe1 = new Publisher("Golden");
        publishe2 = new Publisher("Voyager");
        book1 = new Book("Norge", "Frans", publishe1);
=======
>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f
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
<<<<<<< HEAD


    @Test
    /**
     * Test if a book can be added.
     */
    public void testAddBook()
    {
        Book book2 = new Book("Lord of the Rings", "Tolkien", publishe2);
    }

    @Test
    /**
     * Checks if it can get the author name of book1.
     */
    public void testGetAuthor()
    {
        assertSame("Frans", book1.getAuthor());
    }

    @Test
    /**
     * Tests if it finds the correct publisher.
     */
    public void testGetPublisher()
    {
        assertSame(publishe1, book1.getPublisher());
    }

    @Test
    /**
     * Tests if the title is correct on book1.
     */
    public void testGetTitle()
    {
        assertSame("Norge", book1.getTitle());
=======
    /**
     * Tests that creating a book works as intended
     */
    @Test
    public void testCreateBook()
    {
        Publisher publishe1 = new Publisher("John");
        Book book1 = new Book("Javabook", "John Java", publishe1);
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
        Book book1 = new Book(null, null, null);
        assertNull(book1.getAuthor());
        assertNull(book1.getPublisher());
        assertNull(book1.getTitle());
>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f
    }
}


<<<<<<< HEAD






=======
>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f

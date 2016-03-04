

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommandTest
{
    /**
     * Default constructor for test class CommandTest
     */
    public CommandTest()
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
<<<<<<< HEAD
}
=======
    
    
    /**
     * Tests results when command has 3 words
     */
    @Test
    public void testCommand()
    {
        Command command1 = new Command("f", "g", "a");
       
        assertEquals(true, command1.hasSecondWord());
        assertEquals(true, command1.hasThirdWord());
        assertEquals(false, command1.isUnknown());
    }

    /**
     * Tests result when command has no words at all
     */
    @Test
    public void testNullCommand()
    {
        Command command1 = new Command(null, null, null);
        assertEquals(false, command1.hasSecondWord());
        assertEquals(false, command1.hasThirdWord());
        assertEquals(true, command1.isUnknown());
    }
}


>>>>>>> 537c7d3f4cd6b943fbf2e0f4bc56393d8edb073f

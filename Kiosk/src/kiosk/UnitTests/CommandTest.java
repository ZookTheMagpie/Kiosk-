

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandTest.
 *
 * @author Øystein Barstad
 * @version 22.04.2016
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
    
    /**
     * Simulates a situation where all the commandwords are understood
     */
    @Test
    public void testAllCommandWordsEntered()
    {
        Command command1 = new Command("firstword", "secondword", "thirdword");
        assertEquals("firstword", command1.getCommandWord());
        assertEquals("secondword", command1.getSecondWord());
        assertEquals("thirdword", command1.getThirdWord());
        assertEquals(true, command1.hasSecondWord());
        assertEquals(true, command1.hasThirdWord());
        assertEquals(false, command1.isUnknown());
    }
    
    /**
     * Simulates a situation where none of the commandwords are understood
     */
    @Test
    public void testNoCommandWordsEntered()
    {
        Command command1 = new Command(null, null, null);
        assertNull(command1.getCommandWord());
        assertNull(command1.getSecondWord());
        assertNull(command1.getThirdWord());
        assertEquals(false, command1.hasSecondWord());
        assertEquals(false, command1.hasThirdWord());
        assertEquals(true, command1.isUnknown());
    }
    
    /**
     * Simulates a situation where 1 command is not understood
     */
    @Test
    public void testSomeCommandWordsEntered()
    {
        Command command1 = new Command("firstword", "secondword", null);
        assertEquals("firstword", command1.getCommandWord());
        assertEquals("secondword", command1.getSecondWord());
        assertNull(command1.getThirdWord());
        assertEquals(true, command1.hasSecondWord());
        assertEquals(false, command1.hasThirdWord());
        assertEquals(false, command1.isUnknown());
    }
}




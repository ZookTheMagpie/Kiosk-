

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandWordsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommandWordsTest
{
    /**
     * Default constructor for test class CommandWordsTest
     */
    public CommandWordsTest()
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
     * Tests wheter a command is true or not true
     */
    @Test
    public void testCommandWords()
    {
        CommandWords commandW2 = new CommandWords();
        
        assertEquals(false, commandW2.isCommand("notquit"));
        assertEquals(true, commandW2.isCommand("quit"));
        assertNotNull(commandW2.getValidCommands());
    }
}


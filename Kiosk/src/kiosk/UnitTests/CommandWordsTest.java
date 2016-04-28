

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandWordsTest.
 *
 * @author Øystein Barstad
 * @version 22.04.2016
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
     * Asserts that only walid commands are verified
     */
    @Test
    public void testValidCommands()
    {
        CommandWords commandW1 = new CommandWords();
        assertEquals(true, commandW1.isCommand("add"));
    }
    
    /**
     * Asserts that commands that are not valid aren't verified
     */
    @Test
    public void testNotValidCommand()
    {
        CommandWords commandW1 = new CommandWords();
        assertEquals(false, commandW1.isCommand("Habbahabba"));
    }
}



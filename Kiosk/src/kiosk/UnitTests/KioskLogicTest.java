

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KioskLogicTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KioskLogicTest
{
    /**
     * Default constructor for test class KioskLogicTest
     */
    public KioskLogicTest()
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
     * Tests that adding literature works properly
     */
    @Test
    public void addLitteratureTest()
    {
        KioskLogic kioskLog1 = new KioskLogic();
        Publisher publishe1 = new Publisher("test");
        kioskLog1.addLiteratureToRegister("newspaper", "test", publishe1, 12, "news");
        assertNotSame("There is no literature.", kioskLog1.getAllLiterature());
    }

    @Test
    public void testNoLitteratureAdded()
    {
        KioskLogic kioskLog1 = new KioskLogic();
        assertSame("There is no literature.", kioskLog1.getAllLiterature());
    }
}





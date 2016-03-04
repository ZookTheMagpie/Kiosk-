 



/**
 * This class contains the information that defines a publisher.
 *
 * @author Hallvard
 */
public class Publisher 
{
    private String name;
    
    /**
     * A publisher is created by giving it a name.
     * 
     * @param String name
     */
    public Publisher(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns the name of the publisher.
     */
    public String getName()
    {
        return name;
    }
}

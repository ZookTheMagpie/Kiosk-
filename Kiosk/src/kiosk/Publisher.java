

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
     * @param name the name of the publisher.
     */
    public Publisher(String name)
    {
        this.name = name;
    }
    
    /**
     * Returns the name of the publisher.
     * 
     * @return the name of the publisher.
     */
    public String getName()
    {
        return name;
    }
}

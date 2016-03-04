/**
 * This class contains the information that defines a publisher.
 *
 * @author Hallvard & Alexander
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
     * @return The publisher name
     */
    public String getName()
    {
        return name;
    }
}


/**
 * This class contains the information that defines a newspaper.
 *
 * @author HaIIvard
 */
public class Newspaper extends Litterature
{
    
    public Newspaper(String title, String author, Publisher publisher)
    {
        super(title, author, publisher);
    }

    /**
     * Puts together a string that holds the information about the newspaper.
     * 
     * @return The information about the newspaper
     */
    @Override
    public String getInfo()
    {
        String returnString = "The Newspaper " + super.superInfo();
        return returnString;
    }
    
}

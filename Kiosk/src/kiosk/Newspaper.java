
/**
 * This class contains the information that defines a newspaper.
 *
 * @author HaIIvard & Alexander Eilert Berg 
 * @version 0.3
 */
public class Newspaper extends Litterature
{
    
    public Newspaper(String title, Publisher publisher)
    {
        super(title, publisher);
    }

   /**
     * returns the type newspaper, to be used in sentences like, "The newspaper title by author".
     * 
     * @return The string "The newspaper".
     */
    @Override
    public String getType()
    {
        return "The newspaper";
    }

    /**
     *  Newspaper has currently no author and therfore returns an empty string.
     * @return Returns an empty string.
     */
    @Override
    public String getAuthor()
    {
        String string = "";
        return string;
    }
    
}

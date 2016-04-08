
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
     * returns the type newspaper, to be used in sentences like, "The newspaper title by author".
     * 
     * @return The string "The newspaper".
     */
    @Override
    public String getType()
    {
        return "The newspaper";
    }
    
}

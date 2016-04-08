
/**
 * This class contains the information that defines a magazine. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Magazine extends Litterature
{

    public Magazine(String title, String author, Publisher publisher)
    {
        super(title, author, publisher);
    }

   /**
     * returns the type Magazine, to be used in sentences like, "The Magazine title by author".
     * 
     * @return The string "The magazine".
     */
    @Override
    public String getType()
    {
        return "The magazine";
    }
    
}

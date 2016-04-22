
/**
 * This class contains the information that defines a magazine. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Magazine extends Litterature
{

    public Magazine(String title,Publisher publisher)
    {
        super(title, publisher);
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
        
    /**
     *  Magazine has currently no author and therfore returns an empty string.
     * @return Returns an empty string.
     */
    @Override
    public String getAuthor()
    {
        String string = "";
        return string;
    }
}


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
     * Puts together a string that holds the information about the magazine.
     * 
     * @return The information about the magazine
     */
    @Override
    public String getInfo()
    {
        String returnString = "The Magazine " + super.superInfo();
        return returnString;
    }
    
}

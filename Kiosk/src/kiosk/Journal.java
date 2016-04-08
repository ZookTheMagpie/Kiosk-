/**
 * This class contains the information that defines a journal. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Journal extends Litterature
{
       public Journal(String title, String author, Publisher publisher)
    {
        super(title, author, publisher);
    }

    /**
     * Puts together a string that holds the information about the journal.
     * 
     * @return The information about the journal
     */
    @Override
    public String getInfo()
    {
        String returnString = "The Journal " + super.superInfo();
        return returnString;
    }
}

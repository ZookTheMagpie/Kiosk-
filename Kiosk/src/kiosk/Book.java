;

/**
 * This class contains the information that defines a book.
 *
 * @author HaIIvard
 */
public class Book extends Litterature
{

    /**
     *
     * @param title the title of the book.
     * @param author the author of the book
     * @param publisher the publisher of the book
     */
    public Book(String title, String author, Publisher publisher)
    {
        super(title, author, publisher);
    }

    
    /**
     * Puts together a string that holds the information about the book.
     * 
     * @return The information about the book
     */
    @Override
    public String getInfo()
    {
        String returnString = "The Book " + super.superInfo();
        return returnString;
    }

}

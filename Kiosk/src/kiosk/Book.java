;

/**
 * This class contains the information that defines a book.
 *
 * @author HaIIvard
 */
public class Book extends Litterature
{

    private String author;

    /**
     *
     * @param title the title of the book.
     * @param author the author of the book
     * @param publisher the publisher of the book
     */
    public Book(String title, String author, Publisher publisher)
    {
        super(title, publisher);
        this.author = author;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor()
    {
        return author;
    }
    /**
     * Puts together a string that holds the information about the book.
     * 
     * @return The information about the book
     */
    @Override
    public String getInfo()
    {
        String returnString = super.superInfo();
        returnString = "The Book " + returnString + "/nwritten by " + author;
        return returnString;
    }

}

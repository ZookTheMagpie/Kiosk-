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
     * returns the type book, to be used in sentences like, "The book title by author".
     * 
     * @return The string "The book".
     */
    @Override
    public String getType()
    {
        return "The book";
    }

}

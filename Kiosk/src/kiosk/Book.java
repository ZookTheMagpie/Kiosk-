/**
 * This class contains the information that defines a book.
 *
 * @author HaIIvard & Alexander Eilert Berg
 * @version 0.3
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
     * returns the type book, to be used in sentences like, "The book title by author".
     * 
     * @return The string "The book".
     */
    @Override
    public String getType()
    {
        return "The book";
    }
    
    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    @Override
    public String getAuthor()
    {
        return "\n written by " + author;
    }

}

/**
 * This class contains the information that defines a book.
 *
 * @author HaIIvard & Alexander Eilert Berg
 * @version 0.4
 */
public class Book extends SingleReleases
{
    /**
     * Creates an object that acts as a book.
     * 
     * @param title     // The title of the book.
     * @param author    // The author of the book
     * @param publisher // The publisher of the book
     * @param edition   // The edition of the book
     */
    public Book(String title, String author, Publisher publisher, int edition)
    {
        super(title, author, publisher, edition);
    }

    /**
     * Returns the type book, to be used in sentences like, "The book title by author".
     * @return The string "The book".
     */
    @Override
    public String getType()
    {
        return "The book";
    }
}

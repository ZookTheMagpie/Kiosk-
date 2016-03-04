
import java.util.HashMap;

/**
 * Creates a register that keeps track of the given literature.
 *
 * @author Hallvard & Alexander
 */
public class Register
{

    // Contains the books, stored by publisher
    private HashMap<Publisher, Book> bookList;
    // Contains the publishers by name
    private HashMap<String, Publisher> publishers;

    /**
     * Creates the register.
     */
    public Register()
    {
        bookList = new HashMap<>();
        publishers = new HashMap<>();
    }

    /**
     * Adds a book to the register, by publisher and book name.
     *
     * @param Publisher publisher.
     * @param Book book.
     */
    public void addBook(Publisher publisher, Book book)
    {
        bookList.put(publisher, book);
    }

    /**
     * Adds an publisher to the publisher list.
     *
     * @param publisherName
     */
    public void addPublisher(String publisherName)
    {
        publishers.put(publisherName, new Publisher(publisherName));
    }

    /**
     * Searches all the stored books by name. 
     * Returns either; 
     *      The book title and the author (If the books exists) or 
     *      There is no book with that name (If the books doesn't exists)
     *
     * @param bookName
     * @return returnString
     *
     */
    public String findBookByName(String bookName)
    {
        String returnString = null;
        for (Book book : bookList.values())
        {
            if (book.getTitle().equals(bookName))
            {
                returnString = book.getTitle() + " by: " + book.getAuthor();
            }
        }
        if (returnString == null)
        {
            returnString = "There is no book with that name.";
        }
        return returnString;
    }

    /**
     * Searches all the stored books by author. 
     * Returns either;
     *      The book title and the author (If the books exists) or 
     *      There is no book with that author (If the books doesn't exists)
     *
     * @param bookAuthor
     * @return returnString
     */
    public String findBookByAuthor(String bookAuthor)
    {
        String returnString = null;
        for (Book book : bookList.values())
        {
            if (book.getAuthor().equals(bookAuthor))
            {
                returnString = book.getTitle() + " by: " + book.getAuthor();
            }
        }
        if (returnString == null)
        {
            returnString = "There is no book with that author.";
        }
        return returnString;
    }

    /**
     * Returns all the books the publisher has published. 
     * Returns either; 
     *  This publisher has published: 
     *  This publisher has not published any books
     *
     * @param publisher
     * @return returnString
     */
    public String findBookByPublisher(Publisher publisher)
    {
        String returnString;

        Book desiredBook = null;
        if (bookList.containsKey(publisher))
        {
            desiredBook = bookList.get(publisher);
            returnString = "This publisher has published: ";

            returnString = returnString + desiredBook.getTitle()
                    + " by: " + desiredBook.getAuthor() + "\n";
        } else
        {
            returnString = "This publisher has not published any books.";
        }
        return returnString;
    }

    /**
     * Returns the publisher name
     * 
     * @param publisherName
     * @return returnPublisher
     */
    public Publisher getPublisher(String publisherName)
    {
        Publisher returnPublisher = null;
        if (publishers.containsKey(publisherName))
        {
            returnPublisher = publishers.get(publisherName);
        }
        return returnPublisher;
    }

    /**
     *  Returns a list of all stored books, with title, author and publisher.
     *  Returns a string with "There is no books" if no books are stored. 
     * @return returnString
     */
    public String getAllBooks()
    {
        String returnString = "";
        for (Book book : bookList.values())
        {
            returnString = returnString + book.getTitle()
                    + " by: " + book.getAuthor() + " published by: "
                    + book.getPublisher().getName() + "\n";
        }
        if (returnString.equals(""))
        {
            returnString = "There are no books.";
        }
        return returnString;
    }
}

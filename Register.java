
import java.util.HashMap;

/**
 * This class creates a register that keeps track of the litterature
 * it is given.
 *
 * @author Hallvard
 */
public class Register 
{
    private HashMap<Publisher, Book> bookList;
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
     * Adds a book to the register.
     * 
     * @param publisher the publisher of the book
     * @param book the book to add in the register.
     */
    public void addBook(Publisher publisher, Book book)
    {
        bookList.put(publisher, book);
    } 
    
    /**
     * Creates a new publisher.
     * 
     * @param publisherName The name of the new publisher.
     */
    public void addPublisher(String publisherName)
    {
        publishers.put(publisherName, new Publisher(publisherName));
    }
    
    /**
     * Allows for searches for books by their titles.
     * Returns the title and author of the book.
     * 
     * @param bookName the name of the book to search for.
     * @return The title and author of the book in a string.
     */
    public String findBookByName(String bookName)
    {
        String returnString = null;
        for(Book book : bookList.values())
        {
            if(book.getTitle().equals(bookName))
            {
                returnString = book.getTitle() + " by: " + book.getAuthor();
            }
        }
        if(returnString == null)
        {
            returnString = "There is no book with that name.";
        }
        return returnString;
    }
    
    /**
     * Allows for searches for books by an author.
     * Returns the title and author of the book.
     * 
     * @param bookAuthor the author of the book to search for.
     * @return The title and author of the books the author has written.
     */
    public String findBookByAuthor(String bookAuthor)
    {
        String returnString = null;
        for(Book book : bookList.values())
        {
            if(book.getAuthor().equals(bookAuthor))
            {
                returnString = book.getTitle() + " by: " + book.getAuthor();
            }
        }
        if(returnString == null)
        {
            returnString = "There is no book with that author.";
        }
        return returnString;        
    }
    
    /**
     * Allows for searches by publisher.
     * Returns the title and author of the books published by specified publisher.
     * 
     * @param publisher The publisher to search by.
     * @return The title and author of the book.
     */
    public String findBookByPublisher(Publisher publisher)
    {
        String returnString;
        
        Book desiredBook = null;
        if(bookList.containsKey(publisher))
        {
            desiredBook = bookList.get(publisher);
            returnString = "This pubisher has published: ";
            
            returnString = returnString + desiredBook.getTitle()
            + " by: " + desiredBook.getAuthor() + "\n";
        } 
        else
        {
            returnString = "This publisher has not published any books.";
        }
        return returnString;
    }
    
    /**
     * Returns the publisher with the given name, null if there is no with that name.
     * 
     * @param publisherName Name of the publisher.
     * @return The publisher with the given name, null if ther is no with that name
     */
    public Publisher getPublisher(String publisherName)
    {
        Publisher returnPublisher = null;               
        if(publishers.containsKey(publisherName))
        {
            returnPublisher = publishers.get(publisherName);
        }
        return returnPublisher;
    }
    
    /**
     * Returns the information about all the books in the register.
     * 
     * @return The title, author and publisher of all the books in the register.
     */
    public String getAllBooks()
    {
        String returnString = "";
        for(Book book : bookList.values())
        {
            returnString = returnString + book.getTitle() 
            + " by: " + book.getAuthor() + " published by: " 
            + book.getPublisher().getName() + "\n";
        }
        if(returnString.equals(""))
        {
            returnString = "There are no books.";
        }
        return returnString;
    }
}

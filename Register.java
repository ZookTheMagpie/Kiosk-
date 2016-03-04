package kioskprosjekt;


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
     * @param Publisher publisher.
     * @param Book book.
     */
    public void addBook(Publisher publisher, Book book)
    {
        bookList.put(publisher, book);
    } 
    
    public void addPublisher(String publisherName)
    {
        publishers.put(publisherName, new Publisher(publisherName));
    }
    
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
    
    public String findBookByPublisher(Publisher publisher)
    {
        String returnString;
        
        Book desiredBook = null;
        if(bookList.containsKey(publisher))
        {
            desiredBook = bookList.get(publisher);
            returnString = "This pubisher has published: ";
            
            returnString = returnString + desiredBook.getTitle()
            + "by: " + desiredBook.getAuthor() + "\n";
        } 
        else
        {
            returnString = "This publisher has not published any books.";
        }
        return returnString;
    }
    
    public Publisher getPublisher(String publisherName)
    {
        Publisher returnPublisher = null;               
        if(publishers.containsKey(publisherName))
        {
            returnPublisher = publishers.get(publisherName);
        }
        return returnPublisher;
    }
    
    public String getAllBooks()
    {
        String returnString = null;
        for(Book book : bookList.values())
        {
            returnString = returnString + book.getTitle() 
            + " by: " + book.getAuthor() + " published by: " 
            + book.getPublisher().getName() + "\n";
        }
        if(returnString == null)
        {
            returnString = "There are no books.";
        }
        return returnString;
    }
}

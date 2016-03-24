
/**
 * This class contains the common information about all the different
 * types of litterature.
 *
 * @author HaIIvard
 */
public abstract class Litterature
{

    private String title;
    private String author;
    private Publisher publisher;
    
    public Litterature(String title, String author, Publisher publisher)
    {
        this.publisher = publisher;
        this.author = author;
        this.title = title;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book.
     */
    public String getTitle()
    {
        return title;
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
     * Returns the publisher of the book.
     *
     * @return The publisher of the book.
     */
    public Publisher getPublisher()
    {
        return publisher;
    }
    
    /**
     * Returns the information about the book in a string.
     * 
     * @return The information about the litterature. 
     */
    public abstract String getInfo();
    
    /**
     * Starts building an information string about the litterature, must be finished elsewhere.
     * 
     * @return The information about the litterature avaliable in this super class. 
     */
    public String superInfo()
    {
        String returnString = title + "\n written by " + author +
                "\n published by " + publisher.getName();
        return returnString;
    }
    
}

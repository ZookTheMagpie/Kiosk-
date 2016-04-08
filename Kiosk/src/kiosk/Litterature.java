
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
     * Returns the type of the litterature as a string. To be used in sentences.
     * 
     * @return The type of the litterature.
     */
    public abstract String getType();
    
    /**
     * Builds the information about the litterature into a string that it returns.
     * 
     * @return The information about the litterature.
     */
    public String getInfo()
    {
        String returnString =getType() + "" + title + "\n written by " + author +
                "\n published by " + publisher.getName();
        return returnString;
    }
    
}

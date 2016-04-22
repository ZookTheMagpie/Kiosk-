
/**
 * This class contains the common information about all the different
 * types of literature.
 *
 * @author HaIIvard & Alexander Eilert Berg
 * @version 0.5
 */
public abstract class Litterature
{

    private String title;
    private Publisher publisher;
    
    public Litterature(String title, Publisher publisher)
    {
        this.publisher = publisher;
        this.title = title;
    }

    /**
     * Returns the title of the publication.
     * @return the title of the publication.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the publisher of the publication.
     * @return The publisher of the publication.
     */
    public Publisher getPublisher()
    {
        return publisher;
    }

    /**
     * Returns the type of the literature as a string. To be used in sentences.
     * @return The type of the literature.
     */
    public abstract String getType();
    
    /**
     * Returns the details for the publications.
     * @return Returns the details for the publications.
     */
    public abstract String getDetails();
    
    /**
     * Builds the information about the literature into a string that it returns.
     * @return The information about the literature.
     */
    public String getInfo()
    {
        String returnString = getType() + 
                "\n published by " + publisher.getName() + 
                getDetails();
        
        return returnString;
    }
    
}


/**
 * This class contains the information that defines a newspaper.
 *
 * @author HaIIvard & Alexander Eilert Berg 
 * @version 0.4
 */
public class Newspaper extends periodicReleases
{
    /**
     * Creates an object that acts as an newspaper.
     * 
     * @param title         // The title/name of the paper
     * @param publisher     // The publisher of the paper
     * @param issuesInYear  // The number of releases in one year 
     * @param genre         // The genre of the newspaper, defining its area of focus(sports travel, photography, family leaves, etc.)
     */
    public Newspaper(String title, Publisher publisher, int issuesInYear, String genre)
    {
        super(title, publisher, issuesInYear, genre);
    }

    /**
     * Returns the type newspaper, to be used in sentences like, "The newspaper.....". 
     * @return The string "The newspaper".
     */
    @Override
    public String getType()
    {
        return "The newspaper";
    }
}


/**
 * This class contains the information that defines a magazine. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.3
 */
public class Magazine extends periodicReleases
{
     /**
     * Creates an object that acts as an magazine.
     * 
     * @param title         // The title/name of the paper
     * @param publisher     // The publisher of the paper
     * @param issuesInYear  // The number of releases in one year 
     * @param genre         // The genre of the newspaper, defining its area of focus(sports travel, photography, family leaves, etc.)
     */
    public Magazine(String title,Publisher publisher, int issuesInYear, String genre)
    {
        super(title, publisher, issuesInYear, genre);
    }

    /**
     * Returns the type Magazine, to be used in sentences like, "The Magazine.....".
     * @return The string "The magazine".
     */
    @Override
    public String getType()
    {
        return "The magazine";
    }
}

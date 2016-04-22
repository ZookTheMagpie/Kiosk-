
/**
 * This class contains the information that defines a journal.
 *
 * @author Alexander Eilert Berg
 * @version 0.2
 */
public class Journal extends periodicReleases
{
    /**
     * Creates an object that acts as an journal.
     * 
     * @param title         // The title/name of the paper
     * @param publisher     // The publisher of the paper
     * @param issuesInYear  // The number of releases in one year 
     * @param genre         // The genre of the newspaper, defining its area of focus(sports travel, photography, family leaves, etc.)
     */
    public Journal(String title, Publisher publisher,  int issuesInYear, String genre)
    {
        super(title, publisher, issuesInYear, genre);
    }

    /**
     * Returns the type journal, to be used in sentences like, "The journal
     * title by author".
     *
     * @return The string "The journal".
     */
    @Override
    public String getType()
    {
        return "The journal";
    }
}


/**
 * This class contains the common information for all types of literature that is released periodically.  
 * 
 * @author Alexander Eilert Berg
 * @version 0.2
 */
public abstract class periodicReleases extends Literature
{
    private int issuesInYear;
    private String genre;
    
     /**
     * Holds the information for literature that is released periodically.
     * @param title         // The title/name of the paper
     * @param publisher     // The publisher of the paper
     * @param issuesInYear  // The number of releases in one year 
     * @param genre         // The genre of the newspaper, defining its area of focus(sports travel, photography, family leaves, etc.)
     */
    public periodicReleases(String title, Publisher publisher, int issuesInYear, String genre)
    {
        super(title, publisher);
        this.issuesInYear = issuesInYear;
        this.genre = genre;
    }
    
    /**
     * Returns the number of issues that is released in a year.
     * @return Returns the number of issues that is released in a year.
     */
    public int getIssuesInYear()
    {
        return this.issuesInYear;
    }

    /**
     * Returns the genre of the paper.
     * @return Returns the genre of the paper.
     */
    public String getGenre()
    {
        return this.genre;
    }
    
    /**
     * Returns details about the paper.
     * @return Returns details about the paper.
     */
    @Override
    public String getDetails()
    {
        String details = "\n Genre: " + getGenre() +
                         "\n Issues in a year: " + getIssuesInYear(); 
        return details;
    }
}

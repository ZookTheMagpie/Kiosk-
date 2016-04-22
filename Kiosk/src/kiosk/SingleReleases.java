
/**
 *This class contains the common information for all types of literature that is
 * a stand alone release (In other words, non-periodically.).
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public abstract class SingleReleases extends Literature
{

    private String author;
    private int edition;

    /**
     * Holds the information for literature that is stand alone release.
     *
     * @param title     // The title/name of the paper
     * @param publisher // The publisher of the paper
     * @param author    // The author of the book
     * @param edition   // The edition of the book
     */
    public SingleReleases(String title, String author, Publisher publisher, int edition)
    {
        super(title, publisher);
        this.author = author;
        this.edition = edition;
    }

    /**
     * Returns the author of the publication as a string. To be used in
     * sentences.
     * @return The author of the publication.
     */
    @Override
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * Returns the edition number.
     * @return Returns the edition number.
     */
    public int getEdition()
    {
        return this.edition;
    }

    /**
     * Returns details about the paper.
     * @return Returns details about the paper.
     */
    @Override
    public String getDetails()
    {
        String details = "\n Written by: " + getAuthor() + 
                         "\n Edition: " + getEdition();
        return details;
    }
}

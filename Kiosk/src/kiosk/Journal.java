
/**
 * This class contains the information that defines a journal.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Journal extends Litterature
{

    private String author;

    public Journal(String title, String author, Publisher publisher)
    {
        super(title, publisher);
        this.author = author;
    }

    /**
     * returns the type journal, to be used in sentences like, "The journal
     * title by author".
     *
     * @return The string "The journal".
     */
    @Override
    public String getType()
    {
        return "The journal";
    }

    /**
     * Returns the author of the journal.
     *
     * @return The author of the journal.
     */
    @Override
    public String getAuthor()
    {
        return "\n written by " + author;
    }

}

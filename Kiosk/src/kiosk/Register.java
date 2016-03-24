
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class creates a register that keeps track of the litterature it is
 * given.
 *
 * @author Hallvard
 */
public class Register
{

    private HashMap<Publisher, Litterature> LitteratureList;
    private HashMap<String, Publisher> publishers;

    /**
     * Creates the register.
     */
    public Register()
    {
        LitteratureList = new HashMap<>();
        publishers = new HashMap<>();
    }

    /**
     * Adds a litterature to the register.
     *
     * @param publisher the publisher of the litterature
     * @param litterature the litterature to add in the register.
     */
    public void addLitterature(Publisher publisher, Litterature litterature)
    {
        LitteratureList.put(publisher, litterature);
    }

    /**
     * Creates a new publisher.
     *
     * @param publisherName The name of the new publisher.
     */
    public void addPublisher(String publisherName)
    {
        publishers.put(publisherName, new Publisher(publisherName));
    }

    /**
     * Allows for searches for litterature by its titles. Returns the title and
     * author of the litterature.
     *
     * @param litteratureName the name of the litterature to search for.
     * @return The title and author of the litterature in a string.
     */
    public String findLitteratureByName(String litteratureName)
    {
        String returnString = null;
        for (Litterature litterature : LitteratureList.values())
        {
            if (litterature.getTitle().equals(litteratureName))
            {
                returnString = litterature.getInfo();
            }
        }
        if (returnString == null)
        {
            returnString = "There is not any litterature with that name.";
        }
        return returnString;
    }

    /**
     * Returns the iterator of the LitteratureList
     * 
     * @return The iterator of the LitteratureList
     */
    public Iterator getLitteratureListIterator()
    {
        Iterator<Litterature> it= LitteratureList.values().iterator();
        return it;
    }

    /**
     * Allows for searches by publisher. Returns the title and author of the
     * books published by specified publisher.
     *
     * @param publisher The publisher to search by.
     * @return The title and author of the litterature.
     */
    public String findBookByPublisher(Publisher publisher)
    {
        String returnString;

        Book desiredBook = null;
        if (LitteratureList.containsKey(publisher))
        {
            desiredBook = LitteratureList.get(publisher);
            returnString = "This pubisher has published: ";

            returnString = returnString + desiredBook.getTitle()
                    + " by: " + desiredBook.getAuthor() + "\n";
        } else
        {
            returnString = "This publisher has not published any books.";
        }
        return returnString;
    }

    /**
     * Returns the publisher with the given name, null if there is no with that
     * name.
     *
     * @param publisherName Name of the publisher.
     * @return The publisher with the given name, null if ther is no with that
     * name
     */
    public Publisher getPublisher(String publisherName)
    {
        Publisher returnPublisher = null;
        if (publishers.containsKey(publisherName))
        {
            returnPublisher = publishers.get(publisherName);
        }
        return returnPublisher;
    }

    /**
     * Returns the information about all the books in the register.
     *
     * @return The title, author and publisher of all the books in the register.
     */
    public String getAllBooks()
    {
        String returnString = "";
        for (Book book : LitteratureList.values())
        {
            returnString = returnString + book.getTitle()
                    + " by: " + book.getAuthor() + " published by: "
                    + book.getPublisher().getName() + "\n";
        }
        if (returnString.equals(""))
        {
            returnString = "There are no books.";
        }
        return returnString;
    }
}

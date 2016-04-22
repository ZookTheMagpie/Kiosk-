
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This class creates a register that keeps track of the literature it is
 * given.
 *
 * @author Hallvard & Alexander Eilert Berg
 * @version 0.2
 */
public class Register
{

    private HashSet<Literature> literatureList;
    private HashMap<String, Publisher> publishers;

    /**
     * Creates the register.
     */
    public Register()
    {
        literatureList = new HashSet<>();
        publishers = new HashMap<>();
    }
    
    /**
     * returns the list of literature
     * @return the list of literature
     */
    public HashSet<Literature> getLiteratureList()
    {
        return literatureList;
    }

    /**
     * Adds a literature to the register.
     *
     * @param literature the literature to add in the register.
     */
    public void addLiterature(Literature literature)
    {
        literatureList.add(literature);
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
     * Returns the iterator of the literatureList
     * 
     * @return The iterator of the literatureList
     */
    public Iterator getLiteratureListIterator()
    {
        Iterator<Literature> it= literatureList.iterator();
        return it;
    }
    
    /**
     * Returns the publisher with the given name, null if there is no one with that
     * name.
     *
     * @param publisherName Name of the publisher.
     * @return The publisher with the given name, null if there is no one with that
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
}


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This class creates a register that keeps track of the litterature it is
 * given.
 *
 * @author Hallvard
 */
public class Register
{

    private HashSet<Litterature> LitteratureList;
    private HashMap<String, Publisher> publishers;

    /**
     * Creates the register.
     */
    public Register()
    {
        LitteratureList = new HashSet<>();
        publishers = new HashMap<>();
    }

    /**
     * Adds a litterature to the register.
     *
     * @param litterature the litterature to add in the register.
     */
    public void addLitterature(Litterature litterature)
    {
        LitteratureList.add(litterature);
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
     * Returns the iterator of the LitteratureList
     * 
     * @return The iterator of the LitteratureList
     */
    public Iterator getLitteratureListIterator()
    {
        Iterator<Litterature> it= LitteratureList.iterator();
        return it;
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
}

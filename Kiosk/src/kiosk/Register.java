
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * This class creates a register that keeps track of the literature it is given.
 *
 * @author Hallvard & Alexander Eilert Berg
 * @version 0.2
 */
public class Register implements Observable
{

    private HashSet<Literature> literatureList;
    private HashMap<String, Publisher> publishers;
    private HashSet<Observer> observers;

    /**
     * Creates the register.
     */
    public Register()
    {
        literatureList = new HashSet<>();
        publishers = new HashMap<>();
        observers = new HashSet<>();
    }

    /**
     * returns the list of literature
     *
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
        updateObservers();
    }

    /**
     * Removes literature from the list of literature
     *
     * @param literature literature to be removed
     * @throws InputMismatchException if the literature to be removed is not in
     * the list of literature.
     * @throws IllegalArgumentException if the literature to be removed is null
     */
    public void removeLiterature(Literature literature)
    {
        if (literature != null)
        {
            if (literatureList.contains(literature))
            {
                literatureList.remove(literature);
                updateObservers();
            } else
            {
                throw new IllegalArgumentException("Literature is not literature, remove action ended.");
            }
        } else
        {
            throw new InputMismatchException("input is not in the list, remove action ended");
        }
    }

    /**
     * Creates a new publisher.
     *
     * @param publisherName The name of the new publisher.
     */
    public void addPublisher(String publisherName)
    {
        publishers.put(publisherName, new Publisher(publisherName));
        updateObservers();

    }

    /**
     * Returns the iterator of the literatureList
     *
     * @return The iterator of the literatureList
     */
    public Iterator getLiteratureListIterator()
    {
        Iterator<Literature> it = literatureList.iterator();
        return it;
    }

    /**
     * Returns the publisher with the given name, null if there is no one with
     * that name.
     *
     * @param publisherName Name of the publisher.
     * @return The publisher with the given name, null if there is no one with
     * that name
     */
    public Publisher getPublisher(String publisherName)
    {
        Publisher returnPublisher = null;
        if (publishers.containsKey(publisherName))
        {
            returnPublisher = publishers.get(publisherName);
            return returnPublisher;
        } else
        {
            throw new IllegalArgumentException(publisherName + " is not in the list of publishers");
        }
        
                    
    }


/**
 * Adds an observer to the list of observers.
 *
 * @param name of the observer
 * @throws IllegalArgumentException if the observer to add is null.
 */
@Override
        public void addObserver(Observer obs)
    {
        if (obs != null)
        {
            if (!observers.contains(obs))
            {
                observers.add(obs);
            } else
            {
                throw new InputMismatchException("Observer is already in the list.");
            }
        } else
        {

            throw new IllegalArgumentException("Input is not Observer object");
        }
    }

    /**
     * Removes an observer to the list of observers.
     *
     * @param name of the observer
     * @throws InputMismatchException if the observer to be removed is not in
     * the list of observers.
     * @throws IllegalArgumentException if observer to be removed is null
     */
    @Override
        public void removeObserver(Observer obs)
    {
        if (obs != null)
        {
            if (observers.contains(obs))
            {
                observers.remove(obs);
            }
            throw new InputMismatchException("Observer is not in the list, remove action ended.");
        }

        throw new IllegalArgumentException("Input is not Observer object");
    }

    /**
     * updates the observers list.
     */
    @Override
        public void updateObservers()
    {
        for (Observer obs : observers)
        {
            obs.update();
        }
    }
}

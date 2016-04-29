

/**
 * This interface represents an object that is observable by an observer. 
 * It is used to update objects that is observing it without having any specific
 * knowledge about them.
 * @author HaIIvard
 */
public interface Observable
{
    /**
     * Adds an observer to the list of observers.
     * @param obs observer
     */
    public void addObserver(Observer obs);
    
    /**
     * Removes an observer from the list of observers.
     * 
     * @param obs observer
     */
    public void removeObserver(Observer obs);
    
    /**
     * Triggers the observers in the list of observers to uppdate.
     */
    public void updateObservers();
}

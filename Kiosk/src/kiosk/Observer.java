

/**
 * This interface represents an observer, it is used by the observable object the observer is observing
 * to update the observer when the observable changes.
 * @author Hallvard
 */
public interface Observer
{
    /**
     * Updates the list of objects to match the new list of the observable object.
     */
    public void update();
}

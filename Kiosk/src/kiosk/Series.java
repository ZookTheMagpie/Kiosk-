import java.util.HashMap;


/**
 * This contains and holds the information for series.
 * A series is made up of books, and it must be in numerical sequence. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.3
 */
public class Series extends Literature
{
    private HashMap<Integer, Book> serie;

    /**
     * Holds the information about a series.
     * 
     * @param title  // The tittle of the series.
     * @param number // The number placement of the series object.
     * @param book // The book that is the series.
     */
    public Series(String title, Publisher publisher, int number, Book book)
    {
        super(title,publisher);
        serie = new HashMap<>();  
    }
    
    /**
     * Add an object with its placement to the series.
     * @param number // The number placement of the series object.
     * @param book // The object that is the series.
     */
    public void addToSeries(int number, Book book)
    {
        serie.put(number, book);
    }
    
    /**
     * Removes the object at a numbered placement.
     * @param number 
     */
    public void removeObjectFromSeries(int number)
    {
        serie.remove(number);
    }
    
    /**
     * Returns the object at placed at the number. 
     * @param number
     * @return Returns the object at placed at the number. 
     */
    public Object getBook(int number) 
    {
       return serie.get(number);
    }
    
    /**
     * Returns the number of objects in the series.
     * @return Returns the number of objects in the series.
     */
    public int getNumberOfObjectsInSeries()
    {
        return serie.size();
    }

    @Override
    public String getType()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDetails()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthor()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

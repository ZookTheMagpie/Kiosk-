import java.util.HashMap;


/**
 * This contains and holds the information for series.
 * A series can be made up of anything, but it must be in numerical sequence. 
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Series
{
    private HashMap<Integer, Object> serie;
    private String title;
    
    /**
     * Holds the information about a series.
     * 
     * @param title  // The tittle of the series.
     * @param number // The number placement of the series object.
     * @param object // The object that is the series.
     */
    public Series(String title, int number, Object object)
    {
        serie = new HashMap<>();  
    }

    /**
     * Returns the title of the series.
     * @return Returns the title of the series. 
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Add an object with its placement to the series.
     * @param number // The number placement of the series object.
     * @param objcet // The object that is the series.
     */
    public void addToSeries(int number, Object objcet)
    {
        serie.put(number, objcet);
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
    public Object getObject(int number) 
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
}

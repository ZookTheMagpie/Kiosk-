
import java.util.Iterator;

/**
 * This class deals with the logic of the kiosk.
 */
/**
 *
 * @author HaIIvard
 */
public class KioskLogic
{

    private Register register;
    private Parser parser;

    public KioskLogic()
    {
        register = new Register();
        parser = new Parser();
    }

    /**
     * Makes the register add a publisher with a given name to a collection.
     *
     * @param publisherName name of the publisher
     */
    public void addPublisherToRegister(String publisherName)
    {
        register.addPublisher(publisherName);
    }

    /**
     * Returns a publisher with the given name from the register, null if there
     * is no publisher with that name.
     *
     * @param publisherName name of the publisher
     * @return Publisher with the given name.
     */
    public Publisher getPublisher(String publisherName)
    {
        return register.getPublisher(publisherName);
    }

    /**
     * Adds litterature of the selected kind to the store.
     *
     * @param menuSelection choice made by user
     * @param title title of the litterature to add
     * @param author author of the litterature to add
     * @param publ publisher of thelitterature to add
     */
    public void addLitteratureToRegister(int menuSelection, String title, String author, Publisher publ)
    {
        switch (menuSelection)
        {
            case 1:
                register.addLitterature(new Book(title, author, publ));
                break;

            case 2:
                register.addLitterature(new Newspaper(title, author, publ));
                break;

            case 3:
                register.addLitterature(new Magazine(title, author, publ));
                break;

            case 4:
                register.addLitterature(new Journal(title, author, publ));
                break;
        }
    }

    /**
     * Finds all the litterature that has a connection with the given search
     * condition and returns the info about them.
     * @param searchCondition the string you would like to search by
     * @param searchType The type of search you would like to make (by publisher, author or title)
     * 
     * @return the info of all the litterature found as a string
     */
    public String findLitterature(String searchCondition, String searchType)
    {
        String returnString = "";
        Iterator it = register.getLitteratureListIterator();
        while (it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if (searchType.equals("publisher"))
            {
                if (litterature.getPublisher().getName().equals(searchCondition))
                {
                    returnString = returnString + litterature.getInfo() + "\n\n";
                }
            } else if (searchType.equals("title"))
            {
                if (litterature.getTitle().equals(searchCondition))
                {
                    returnString = returnString + litterature.getInfo() + "\n\n";
                }
            } else if (searchType.equals("author"))
            {
                if (litterature.getAuthor().equals(searchCondition))
                {
                    returnString = returnString + litterature.getInfo() + "\n\n";
                }
            }
        }
        return returnString;
    }
    
    /**
     * Returns the information about all the litterature in the store as a string.
     * 
     * @return The information about all the litterature in the store as a string
     */
    public String getAllLitterature()
    {
        String returnString = "";
        Iterator it = register.getLitteratureListIterator();
        while (it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();

            returnString = returnString + litterature.getInfo() + "\n\n";
        }
        if (returnString.equals(""))
        {
            returnString = "There is no litterature.";
        }
        return returnString;
    }

}

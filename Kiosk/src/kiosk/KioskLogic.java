
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * This class deals with the logic of the kiosk.
 */
/**
 *
 * @author HaIIvard & Alexander Eilert Berg
 * @version 0.2
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
     * returns the list of literature
     *
     * @return the list of literature
     */
    public HashSet<Literature> getLiteratureList()
    {
        return register.getLiteratureList();
    }

    /**
     * Returns a publisher with the given name from the register, if there is no
     * publisher with that name, creates one and returns it.
     *
     * @param publisherName name of the publisher
     * @return Publisher with the given name.
     */
    public Publisher getPublisher(String publisherName)
    {
        try
        {
            return register.getPublisher(publisherName);
        } catch (IllegalArgumentException e)
        {
            register.addPublisher(publisherName);
            return register.getPublisher(publisherName);
        }
    }

    /**
     * removes literature from the list of literature
     *
     * @param The name of theliterature to be removed
     */
    public void removeLit(String litName)
    {

        try
        {
            Literature lit = this.findOneLiterature(litName);

            register.removeLiterature(lit);
        } catch (InputMismatchException e)
        {
            System.out.println(litName + " is not literature");
        } catch (IllegalArgumentException e)
        {
            System.out.println(litName + " is not in the list");
        }

    }

    /**
     * Adds literature of the selected kind to the store.
     *
     * @param menuSelection choice made by user
     * @param title title of the literature to add
     * @param publ publisher of the literature to add
     * @throws IllegalArgumentException if the menuSelection is unvalid.
     * @throws InputMismatchException if the input is unvalid
     */
    public void addLiteratureToRegister(String menuSelection, String title, Publisher publ, int issuesInYear, String genre)
    {
        if (title.length() > 0 && genre.length() > 0 && publ != null && menuSelection != null && title != null && genre != null)
        {
            switch (menuSelection)
            {
                case "newspaper":
                    register.addLiterature(new Newspaper(title, publ, issuesInYear, genre));
                    break;

                case "magazine":
                    register.addLiterature(new Magazine(title, publ, issuesInYear, genre));
                    break;

                case "journal":
                    register.addLiterature(new Journal(title, publ, issuesInYear, genre));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown selection: " + menuSelection);
            }
        } else
        {
            throw new InputMismatchException("Invalid input");
        }
    }

    /**
     * Adds literature of the selected kind to the store.
     *
     * @param menuSelection choice made by user
     * @param title title of the literature to add
     * @param author author of the literature to add
     * @param publ publisher of the literature to add
     * @throws IllegalArgumentException if the menuSelection is unvalid.
     * @throws InputMismatchException if the input is unvalid
     */
    /**
     * Adds literature of the selected kind to the store.
     *
     * @param menuSelection choice made by user
     * @param title title of the literature to add
     * @param author author of the literature to add
     * @param publ publisher of the literature to add
     * @param edition the edition number
     * @throws IllegalArgumentException if the menuSelection is unvalid.
     * @throws InputMismatchException if the input is unvalid
     */
    public void addLiteratureWithAuthorToRegister(String menuSelection, String title, String author, Publisher publ, int edition)
    {
        if (title.length() > 0 && author.length() > 0 && publ != null && title != null && author != null && menuSelection != null)
        {
            switch (menuSelection)
            {
                case "book":
                    register.addLiterature(new Book(title, author, publ, edition));
                    break;

                default:
                    throw new IllegalArgumentException("Unknown selection: " + menuSelection);
            }
        } else
        {
            throw new InputMismatchException("Invalid input");
        }
    }

    /**
     * Finds all the literature that has a connection with the given search
     * condition and returns the info about them. Searches by upper case.
     *
     * @param searchCondition the string you would like to search by
     *
     * @return the literature found
     */
    public HashSet<Literature> findLiterature(String searchCondition)
    {
        HashSet<Literature> filteredList = new HashSet<>();
        Iterator it = register.getLiteratureListIterator();
        while (it.hasNext())
        {
            Literature literature = (Literature) it.next();

            if (literature.getTitle().toUpperCase().contains(searchCondition))
            {
                filteredList.add(literature);
            }
            if (literature.getAuthor().toUpperCase().contains(searchCondition))
            {
                filteredList.add(literature);
            }
            if (literature.getPublisher().getName().toUpperCase().contains(searchCondition))
            {
                filteredList.add(literature);
            }
        }
        return filteredList;
    }

    /**
     * Returns the information about all the literature in the store as a
     * string.
     *
     * @return The information about all the literature in the store as a string
     */
    public String getAllLiterature()
    {
        String returnString = "";
        Iterator it = register.getLiteratureListIterator();
        while (it.hasNext())
        {
            Literature literature = (Literature) it.next();

            returnString = returnString + literature.getInfo() + "\n\n";
        }
        if (returnString.equals(""))
        {
            returnString = "There is no literature.";
        }
        return returnString;
    }

    /**
     * adds the observer from the input to the registers list of observers.
     *
     * @throws InputMismatchException if the input is null
     * @param obs observer to add to the list.
     */
    public void addToRegisterObserverList(Observer obs)
    {
        if (obs != null)
        {
            register.addObserver(obs);
        } else
        {
            throw new InputMismatchException("Input must be of the type observer.");
        }
    }

    /**
     * Finds a literature with the given name
     *
     * @param litName
     * @throws InputMismatchException if input is null
     * @return Literature
     */
    private Literature findOneLiterature(String litName)
    {
        if (litName != null)
        {
            Literature lit = null;
            Boolean finished = false;
            Iterator it = register.getLiteratureListIterator();
            while (it.hasNext() && !finished)
            {
                Literature literature = (Literature) it.next();

                if (literature.getTitle().toUpperCase().equals(litName))
                {
                    finished = true;
                    lit = literature;
                }
            }
            return lit;
        } else
        {
            throw new InputMismatchException("Input must be of the String type.");
        }
    }

}

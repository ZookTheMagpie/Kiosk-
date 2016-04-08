
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * The kiosk class deals with the user interface which allows the user to amongs
 * other things: add books, add publisher, search for books and other things.
 *
 * @author Hallvard
 * @version 12.02.16
 */
public class Kiosk
{

    private Register register;
    private Parser parser;

    /**
     * Creates the register and publisher storage.
     */
    public Kiosk()
    {
        register = new Register();
        parser = new Parser();
    }

    /**
     * The start method is responsible for running the application. It allows
     * the user to select a number of options from a menu system.
     */
    public void start()
    {
        printWelcome();

        boolean finished = false;
        while (!finished)
        {
            try
            {
                showMenu();
                int menuSelection = parser.menuSelection();
                switch (menuSelection)
                {
                    case 1:
                        this.initiateLitteratureAdd();
                        break;

                    case 2:
                        this.initiatePublisher();
                        break;

                    case 3:
                        this.findLLitteratureByPublisherName();
                        break;

                    case 4:
                        this.findLitteratureByTitle();
                        break;

                    case 5:
                        this.findLitteratureByAuthor();
                        break;

                    case 6:
                        this.printAllLitterature();
                        ;
                        break;

                    case 7:
                        System.out.println("\nThank you for using Application v1.0. Bye!\n");
                        finished = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and 7..\n");
            }
        }
        System.out.println("Good bye.");
    }

    /**
     * This method adds a new publisher to the register.
     */
    private void initiatePublisher()
    {
        String publisherName;
        System.out.println("Please enter the name of the publisher.");
        System.out.println();
        System.out.println("> ");
        publisherName = "";
        while (publisherName.trim().equals(""))
        {
            publisherName = parser.getInputString();
        }

        register.addPublisher(publisherName);
        System.out.println(publisherName + " added as a publisher.");
        System.out.println();
    }

    /**
     * This method gets an input from the user
     *
     * @return The input from the user as a string
     */
    private String getUserinput()
    {
        String input = "";
        System.out.println();
        System.out.println("> ");
        while (input.trim().equals(""))
        {
            input = parser.getInputString();
        }
        return input;
    }

    /**
     * Gets the publisher for the new litterature, if the publisher doesn't
     * exist, you have the choice of creating one.
     */
    private Publisher getPublisher()
    {

        String publisherName = "";

        System.out.println("Please enter the publisher.");
        publisherName = getUserinput();
        System.out.println();
        Publisher publ = register.getPublisher(publisherName);
         if(publ == null)
        {
            System.out.println("There is no publisher with that name, would you like to add one?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println();
            System.out.println("> ");
            int answer = parser.getYesOrNo();
            if (answer == 1)
            {
                register.addPublisher(publisherName);
                publ = register.getPublisher(publisherName);
            } else
            {
                System.out.println("The publisher was not added to the store.");
                System.out.println();
            }
        }
         return publ;
    }

    /**
     * gets an author from the user and returns it.
     *
     * @return the author of the litterature in creation
     */
    private String getAuthor()
    {
        String author = "";
        System.out.println("Please enter the author.");
        author = getUserinput();
        System.out.println();
        return author;
    }

    /**
     * gets a title from the user and returns it.
     *
     * @return the title of the litterature in creation
     */
    private String getTitle()
    {
        String title = "";
        System.out.println("Please enter the title.");
        title = getUserinput();
        System.out.println();
        return title;
    }

    /**
     * allows you to add a litterary work to the store.
     */
    private void initiateLitteratureAdd()
    {
        this.showLitteratureMenu();
        int menuSelection = parser.litteratureMenuSelection();
        if (menuSelection == 3)
        {
            System.out.println("Nothing was added.");
        } else
        {
            String title = this.getTitle();
            String author = this.getAuthor();
            Publisher publ = this.getPublisher();
            if (publ == null)
            {
                System.out.println(title + "was not added to the store.");
            } else
            {
                if(menuSelection == 1)
                {
                register.addLitterature(new Book(title, author, publ));
                }
                else if(menuSelection == 2)
                {
                    register.addLitterature(new Newspaper(title, author, publ));
                }
                System.out.println(title + " was added to the store.");
            }
        }
    }

    /**
     * Prints the menu system with the options to the user.
     */
    private void showMenu()
    {
        System.out.println();
        System.out.println("Please choose menu item (1-7): ");
        System.out.println("1. Add litterature.");
        System.out.println("2. Add publisher.");
        System.out.println("3. Find litterature by publisher.");
        System.out.println("4. Find litterature by title.");
        System.out.println("5. Find litterature by author.");
        System.out.println("6. Print all litterature");
        System.out.println("7. Quit.");
        System.out.println();
        System.out.println("> ");
    }

    /**
     * shows a menu where the different types of litterature is listed
     */
    private void showLitteratureMenu()
    {
        System.out.println();
        System.out.println("Please choose menu item (1-3): ");
        System.out.println("1. Add book.");
        System.out.println("2. Add Newspaper.");
        System.out.println("3. Go back.");
        System.out.println();
        System.out.println("> ");
    }

    /**
     * Welcomes you to the application.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to your new litterature store!");
        System.out.println();
    }

    /**
     * Allows you to search for litterature by the publisher.
     *
     * @param String name.
     */
    private void findLLitteratureByPublisherName()
    {
        System.out.println("What publisher would you like to search by?");
        String name = getUserinput();
        Publisher publ = register.getPublisher(name);
        String outputString = name + " has published: ";
        if (publ == null)
        {
            outputString = "There is no publisher with that name.";
        } else
        {
            Iterator it = register.getLitteratureListIterator();
            while (it.hasNext())
            {
                Litterature litterature = (Litterature) it.next();
                if (litterature.getPublisher().getName().equals(name))
                {
                    outputString = outputString + litterature.getInfo() + "/n";
                }
            }
            if (outputString.equals(name + " has published: "))
            {
                outputString = name + " has not published any books.";
            }
            System.out.println();
            System.out.println(outputString);
        }
    }

    /**
     * Allows you to search for litterature by title.
     */
    private void findLitteratureByTitle()
    {
        System.out.println("What title would you like to search by?");
        String litteratureTitle = "";
        litteratureTitle = getUserinput();
        String outputString = null;
        Iterator it = register.getLitteratureListIterator();
        while (it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if (litterature.getTitle().equals(litteratureTitle))
            {
                outputString = outputString + litterature.getInfo() + "/n";
            }
        }
        if (outputString == null)
        {
            outputString = "There is no litterature with that title.";
        }
        System.out.println();
        System.out.println(outputString);
    }

    /**
     * Allows you to search for litterature by its author.
     *
     * @param String litteratureAuthor.
     */
    private void findLitteratureByAuthor()
    {
        System.out.println("What author would you like to search by?");
        String litteratureAuthor = "";
        litteratureAuthor = getUserinput();
        String outputString = litteratureAuthor + " has written: ";
        Iterator it = register.getLitteratureListIterator();
        while (it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if (litterature.getAuthor().equals(litteratureAuthor))
            {
                outputString = outputString + litterature.getInfo() + "/n";
            }
        }
        if (outputString.equals(litteratureAuthor + " has written: "))
        {
            outputString = "There is no litterature with that author.";
        }
        System.out.println();
        System.out.println(outputString);
    }

    /**
     * Prints out the information about all the litterature in the register.
     */
    private void printAllLitterature()
    {
        String outputString = "";
        Iterator it = register.getLitteratureListIterator();
        while (it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();

            outputString = outputString + litterature.getInfo() + "/n";
        }
        if (outputString.equals(""))
        {
            outputString = "There is no litterature.";
        }
        System.out.println();
        System.out.println(outputString);
    }
}

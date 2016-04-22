
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * The kiosk class deals with the user interaction.
 *
 * @author Hallvard
 * @version 12.02.16
 */
public class KioskUI
{

    private Parser parser;
    private KioskLogic kioskL;

    /**
     * Creates the register and publisher storage.
     */
    public KioskUI()
    {
        parser = new Parser();
        kioskL = new KioskLogic();
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
                        System.out.println("Please enter the name of the publisher.");
                        this.initiatePublisher(this.getUserinput());
                        break;

                    case 3:
                        System.out.println("What publisher would you like to search by?");
                        this.findLitteratureByPublisherName(this.getUserinput());
                        break;

                    case 4:
                        System.out.println("What title would you like to search by?");
                        this.findLitteratureByTitle(this.getUserinput());
                        break;

                    case 5:
                        System.out.println("What author would you like to search by?");
                        this.findLitteratureByAuthor(this.getUserinput());
                        break;

                    case 6:
                        this.printAllLitterature();
                        break;

                    case 7:
                        System.out.println("What would you like to search for?");
                        this.searchLitterature(this.getUserinput());
                        break;

                    case 8:
                        System.out.println("\nThank you for using Application v1.0. Bye!\n");
                        finished = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and 8..\n");
            }
        }
        System.out.println("Good bye.");
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
     * This method adds a new publisher to the register.
     */
    private void initiatePublisher(String publisherName)
    {
        kioskL.addPublisherToRegister(publisherName);
        System.out.println(publisherName + " added as a publisher.");
        System.out.println();
    }

    /**
     * Returns the publisher for the new litterature, if the publisher doesn't
     * exist, you have the choice of creating one.
     *
     * @return Publisher to use for litterature creation.
     */
    private Publisher getPublisher()
    {
        String publisherName = "";
        System.out.println("Please enter the name of the publisher");
        publisherName = getUserinput();
        System.out.println();
        Publisher publ = kioskL.getPublisher(publisherName);
        if (publ == null)
        {
            System.out.println("There is no publisher with that name, would you like to add one?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            System.out.println();
            System.out.println("> ");
            int answer = parser.getYesOrNo();
            if (answer == 1)
            {
                kioskL.addPublisherToRegister(publisherName);
                publ = kioskL.getPublisher(publisherName);
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
        try
        {
            this.showLitteratureMenu();
            int menuSelection = parser.litteratureMenuSelection();
            if (menuSelection == 5)
            {
                System.out.println("Nothing was added.");
            } else
            {
                String title = this.getTitle();
                Publisher publ = this.getPublisher();
                if (menuSelection == 1 || menuSelection == 4)
                {
                    String author = this.getAuthor();
                    kioskL.addLitteratureWithAuthorToRegister(menuSelection, author, title, publ);
                } else if (publ == null)
                {
                    System.out.println(title + "was not added to the store.");
                } else
                {
                    kioskL.addLitteratureToRegister(menuSelection, title, publ);
                    System.out.println(title + " was added to the store.");
                }
            }
        } catch (InputMismatchException ime)
        {
            System.out.println("\nERROR: Please provide a number between 1 and 5..\n");
        }
    }

    /**
     * Prints the menu system with the options to the user.
     */
    private void showMenu()
    {
        System.out.println();
        System.out.println("Please choose menu item (1-8): ");
        System.out.println("1. Add litterature.");
        System.out.println("2. Add publisher.");
        System.out.println("3. Find litterature by publisher.");
        System.out.println("4. Find litterature by title.");
        System.out.println("5. Find litterature by author.");
        System.out.println("6. Print all litterature.");
        System.out.println("7. Search for litterature.");
        System.out.println("8. Quit.");
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
        System.out.println("3. Add Magazine.");
        System.out.println("4. Add Journal.");
        System.out.println("5. Go back.");
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
     * This method combines all the aspects of searching for litterature, and
     * automatically searches for author, title and publisher.
     *
     * @param String searchWord
     */
    private void searchLitterature(String searchWord)
    {
        String outputString = "";
        outputString = outputString + kioskL.findLitterature(searchWord, "title");
        outputString = outputString + kioskL.findLitterature(searchWord, "publisher");
        outputString = outputString + kioskL.findLitterature(searchWord, "author");
        if (outputString.equals(""))
        {
            System.out.println("No litterature were found");
        } else
        {
            System.out.println(outputString);
        }
    }

    /**
     * Allows you to search for litterature by the publisher.
     *
     * @param String name.
     */
    private void findLitteratureByPublisherName(String publisherName)
    {

        Publisher publ = kioskL.getPublisher(publisherName);
        String outputString = "";
        if (publ == null)
        {
            outputString = "There is no publisher with that name.";
        } else
        {
            outputString = "The litterature found were: " + kioskL.findLitterature(publisherName, "publisher");
            if (outputString.equals("The litterature found were: "))
            {
                outputString = publisherName + " has not published anything.";
            }
        }
        System.out.println();
        System.out.println(outputString);
    }

    /**
     * Allows you to search for litterature by title.
     *
     * @param String title of the litterature
     */
    private void findLitteratureByTitle(String litteratureTitle)
    {
        String outputString = "";
        outputString = "The litterature found were: " + kioskL.findLitterature(litteratureTitle, "title");
        if (outputString.equals("The litterature found were: "))
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
    private void findLitteratureByAuthor(String litteratureAuthor)
    {
        String outputString = "";
        outputString = "The litterature found were: " + kioskL.findLitterature(litteratureAuthor, "author");
        if (outputString.equals("The litterature found were: "))
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
        String outputString = kioskL.getAllLitterature();
        System.out.println();
        System.out.println(outputString);
    }
}


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
                        this.newBook();
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
            }
            
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and 7..\n");
            }
        }
        System.out.println("Good bye.");
    }

    /**
     * This method is responsible for creating a new publisher.
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
     * This method is responsible for creating a new book. If you choose a
     * publisher that doesn't exist while creating the book, it allows you to
     * make a new publisher with that name.
     */
    private void newBook()
    {
        String title = "";
        String author = "";
        String publisherName = "";
        System.out.println("Please enter the book's title.");
        System.out.println();
        System.out.println("> ");
        while (title.trim().equals(""))
        {
            title = parser.getInputString();
        }
        System.out.println();
        System.out.println("Please enter the book's author.");
        System.out.println();
        System.out.println("> ");
        while (author.trim().equals(""))
        {
            author = parser.getInputString();
        }
        System.out.println();
        System.out.println("Please enter the book's publisher.");
        System.out.println();
        System.out.println("> ");
        while (publisherName.trim().equals(""))
        {
            publisherName = parser.getInputString();
        }
        System.out.println();
        if (register.getPublisher(publisherName) != null)
        {
            this.addLitteratureToRegister(title, author, publisherName);
            System.out.println(title + " added to the store.");
        } else
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
                this.addLitteratureToRegister(title, author, publisherName);
                System.out.println(title + " added to the store.");
            } else
            {
                System.out.println("The book was not added to the store.");
                System.out.println();
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
        System.out.println("1. Add book.");
        System.out.println("2. Add publisher.");
        System.out.println("3. Find book by publisher.");
        System.out.println("4. Find book by title.");
        System.out.println("5. Find book by author.");
        System.out.println("6. Print all books");
        System.out.println("7. Quit.");
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
     * Adds a book to the book register.
     *
     * @param String title.
     * @param String author.
     * @param String publisherName.
     */
    private void addLitteratureToRegister(String title, String author, String publisherName)
    {
        Publisher publ = register.getPublisher(publisherName);
        if (publ == null)
        {
            System.out.println("There is no publisher with that name!");
            System.out.println(publisherName + " added to the list of publishers.");
            this.initiatePublisher();
            publ = register.getPublisher(publisherName);
            register.addLitterature(publ, new Book(title, author, publ));

        } else
        {
            register.addLitterature(publ, new Book(title, author, publ));
        }
    }

    /**
     * Allows you to search for a book by the publisher.
     *
     * @param String name.
     */
    private void findLLitteratureByPublisherName()
    {
        System.out.println("What publisher would you like to search by?");
        System.out.println();
        System.out.println("> ");
        String name = "";
        while (name.trim().equals(""))
        {
            name = parser.getInputString();
        }
        Publisher publ = register.getPublisher(name);
        String outputString = name + " has published: ";
        if (publ == null)
        {
            outputString = "There is no publisher with that name.";
        } else
        {
        Iterator it = register.getLitteratureListIterator();
        while(it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if(litterature.getPublisher().getName().equals(name))
            {
                outputString = outputString + litterature.getInfo() + "/n";
            }
        }     
        if(outputString.equals(name + " has published: "))
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
        System.out.println();
        System.out.println("> ");
        String litteratureTitle = "";
        while (litteratureTitle.trim().equals(""))
        {
            litteratureTitle = parser.getInputString();
        }
        String outputString = null;
        Iterator it = register.getLitteratureListIterator();
        while(it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if(litterature.getTitle().equals(litteratureTitle))
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
        System.out.println();
        System.out.println("> ");
        String litteratureAuthor = "";
        while (litteratureAuthor.trim().equals(""))
        {
            litteratureAuthor = parser.getInputString();
        }
        String outputString = litteratureAuthor + " has written: ";
        Iterator it = register.getLitteratureListIterator();
        while(it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            if(litterature.getAuthor().equals(litteratureAuthor))
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
        String outputString = null;
        Iterator it = register.getLitteratureListIterator();
        while(it.hasNext())
        {
            Litterature litterature = (Litterature) it.next();
            
            outputString = outputString + litterature.getInfo() + "/n";
        }
        if (outputString == null)
        {
            outputString = "There is no litterature.";
        }
        System.out.println();
        System.out.println(outputString);
    }
}

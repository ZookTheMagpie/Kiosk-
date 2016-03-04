package kioskprosjekt;

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * The kiosk allows you to add and find books. You can also add publishers and
 * search for books by the author.
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
                        this.findBookByPublisherName();
                        break;
                        
                    case 4:
                        this.findBookByTitle();
                        break;
                        
                    case 5:
                        this.findBookByAuthor();
                        break;
                        
                    case 6:
                        this.printAllBooks();;
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

    private void initiatePublisher()
    {
        String publisherName;
        System.out.println("Please enter the name of the publisher.");
        System.out.println();
        System.out.println("> ");
        publisherName = "";
        while(publisherName.trim().equals(""))
        {
        publisherName = parser.getInputString();
        }

        this.newPublisher(publisherName);
        System.out.println(publisherName + " added as a publisher.");
        System.out.println();
    }

    private void newBook()
    {
        String title = "";
        String author = "";
        String publisherName = "";
        System.out.println("Please enter the book's title.");
        System.out.println();
        System.out.println("> ");
        while(title.trim().equals(""))
        {
        title = parser.getInputString();
        }
        System.out.println();
        System.out.println("Please enter the book's author.");
        System.out.println();
        System.out.println("> ");
        while(author.trim().equals(""))
        {
        author = parser.getInputString();
        }
        System.out.println();
        System.out.println("Please enter the book's publisher.");
        System.out.println();
        System.out.println("> ");
        while(publisherName.trim().equals(""))
        {
        publisherName = parser.getInputString();
        }
        System.out.println();
        if(register.getPublisher(publisherName) != null)
        {
        this.addBookToRegister(title, author, publisherName);
        System.out.println(title + " added to the store.");
        }
        else
        {
            System.out.println("There is no publisher with that name, would you like to add one?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            int answer = parser.getYesOrNo();
            if(answer == 1)
            {
                register.addPublisher(publisherName);
                this.addBookToRegister(title, author, publisherName);
                System.out.println(title + " added to the store.");
            }
            else
            {
                System.out.println("The book was not added to the store.");
                System.out.println();
            }
        }
    }
    
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
    }

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
    private void addBookToRegister(String title, String author, String publisherName)
    {
        Publisher publ = register.getPublisher(publisherName);
        if (publ == null)
        {
            System.out.println("There is no publisher with that name!");
            System.out.println(publisherName + " added to the list of publishers.");
            this.newPublisher(publisherName);
            publ = register.getPublisher(publisherName);
            register.addBook(publ, new Book(title, author, publ));

        } else
        {
            register.addBook(publ, new Book(title, author, publ));
        }
    }

    /**
     * Allows you to search for a book by the publisher.
     *
     * @param String name.
     */
    private void findBookByPublisherName()
    {
        System.out.println("What publisher would you like to search by?");
        System.out.println();
        System.out.println("> ");
        String name = "";
        while(name.trim().equals(""))
        {
        name = parser.getInputString();
        }
        Publisher publ = register.getPublisher(name);
        String bookDetails;
        if (publ == null)
        {
            bookDetails = "There is no publisher with that name.";
        } else
        {
            bookDetails = register.findBookByPublisher(publ);
        }
        System.out.println(bookDetails);
    }

    /**
     * Allows you to search for a book by its title.
     *
     * @param String bookTitle.
     */
    private void findBookByTitle()
    {
        System.out.println("What title would you like to search by?");
        System.out.println();
        System.out.println("> ");
        String bookTitle = "";
        while(bookTitle.trim().equals(""))
        {
        bookTitle = parser.getInputString();
        }
        String bookDetails = register.findBookByName(bookTitle);
        System.out.println();
        System.out.println(bookDetails);
    }

    /**
     * Allows you to search for a book by its author.
     *
     * @param String bookAuthor.
     */
    private void findBookByAuthor()
    {
        System.out.println("What author would you like to search by?");
        System.out.println();
        System.out.println("> ");
        String bookAuthor = "";
        while(bookAuthor.trim().equals(""))
        {
        bookAuthor = parser.getInputString();
        }
        String bookDetails = register.findBookByAuthor(bookAuthor);
        System.out.println();
        System.out.println(bookDetails);
    }

    /**
     * Prints out the information for each book in the register.
     */
    private void printAllBooks()
    {
        System.out.println(register.getAllBooks());
    }

    /**
     * Creates a publisher.
     *
     * @param String publisherName.
     */
    private void newPublisher(String publisherName)
    {
        register.addPublisher(publisherName);
    }

}

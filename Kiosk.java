package kioskprosjekt;

import java.util.HashMap;

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
        printHelp();

        boolean finished = false;
        while (!finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Good bye.");
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if (command.isUnknown())
        {
            System.out.println("That is no valid command...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("add"))
        {
            if (command.hasSecondWord())
            {
                if (command.getSecondWord().equals("book"))
                {
                    this.newBook();
                } else if (command.getSecondWord().equals("publisher"))
                {
                    this.initiatePublisher();
                }
            } else
            {
                System.out.println("Add what?");
            }
        } else if (commandWord.equals("quit"))
        {
            wantToQuit = quit(command);
        } else if (commandWord.equals("help"))
        {
            printHelp();
        } else if (commandWord.equals("find"))
        {
            if (command.hasSecondWord())
            {
                if (command.getSecondWord().equals("by"))
                {
                    if (command.hasThirdWord())
                    {
                        if(command.getThirdWord().equals("publisher"))
                        {
                            this.findBookByPublisherName();
                        }
                        else if(command.getThirdWord().equals("title"))
                        {
                            this.findBookByTitle();
                        }
                        else if(command.getThirdWord().equals("author"))
                        {
                            this.findBookByAuthor();
                        }
                        else
                        {
                            System.out.println("Not a valid search method.");
                        }
                    } else
                    {
                        System.out.println("Find book by what?");
                    }
                } else
                {
                    System.out.println("You must type 'find by' and what method you want to use.");
                }

            } else
            {
                System.out.println("Not a valid command.");
            }
        }
        return wantToQuit;
    }

    private void initiatePublisher()
    {
        String publisherName;
        System.out.println("Please enter the name of the publisher.");
        System.out.println();
        System.out.println("> ");
        publisherName = parser.getInputString();

        this.newPublisher(publisherName);
        System.out.println(publisherName + " added as a publisher.");
    }

    private void newBook()
    {
        String title;
        String author;
        String publisherName;
        System.out.println("Please enter the book's title.");
        System.out.println();
        System.out.println("> ");
        title = parser.getInputString();
        System.out.println();
        System.out.println("Please enter the book's author.");
        System.out.println();
        System.out.println("> ");
        author = parser.getInputString();
        System.out.println();
        System.out.println("Please enter the book's publisher.");
        System.out.println();
        System.out.println("> ");
        publisherName = parser.getInputString();
        System.out.println();

        this.addBookToRegister(title, author, publisherName);

        System.out.println(title + " added to the store.");
    }

    private void printHelp()
    {
        System.out.println("Your command words are:");
        System.out.println(parser.getCommandWords().getValidCommands());
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
        String name = parser.getInputString();
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
        String bookTitle = parser.getInputString();
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
        String bookAuthor = parser.getInputString();
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

    private boolean quit(Command command)
    {
        if (command.hasSecondWord())
        {
            System.out.println("Quit what?");
            return false;
        } else
        {
            return true;  // signal that we want to quit
        }
    }

}

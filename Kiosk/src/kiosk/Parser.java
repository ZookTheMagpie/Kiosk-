
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HaIIvard
 */
public class Parser
{

    private CommandWords commands;
    private Scanner reader;
/**
 * Creates a CommandWords and Scanner object.
 */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
/**
 * 
 * @return A refrence to the commandWords object.
 */
    public CommandWords getCommandWords()
    {
        return commands;
    }
/**
 * promts the user to input.
 * 
 * @return The input from the user as a string.
 */
    public String getInputString()
    {
        return reader.nextLine();
    }
/**
 * This method gets the user's input number and returns it.
 * The input must be within a specified range.
 * 
 * @return The user's choice as an int.
 */
    public int menuSelection() throws InputMismatchException
    {
        if(reader.hasNext()&&!reader.hasNextInt())reader.nextLine();
        int menuChoice = reader.nextInt();
        if ((menuChoice < 1) || (menuChoice > 7))
        {
            throw new InputMismatchException();
        }
        return menuChoice;
    }
    
    /**
 * This method gets the user's input number and returns it.
 * The input must be within a specified range.
 * 
 * @return The user's choice as an int.
 */
    public int litteratureMenuSelection() throws InputMismatchException
    {
        if(reader.hasNext()&&!reader.hasNextInt())reader.nextLine();
        int menuChoice = reader.nextInt();
        if ((menuChoice < 1) || (menuChoice > 6))
        {
            throw new InputMismatchException();
        }
        return menuChoice;
    }
    /**
     * Gets an input from the user and checks if it is 1 or 2.
     * 
     * @return The user's choice of 1 or 2 as an int.
     */
        public int getYesOrNo()
    {
        int YesOrNo = reader.nextInt();
        if ((YesOrNo < 1) || (YesOrNo > 2))
        {
            throw new InputMismatchException();
        }
        return YesOrNo;
    }

/**
 * This method converts a string input from the user to a 
 * command of the command class.
 * 
 * @return The command the user submitted.
 */
    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;
        String word3 = null;

        System.out.println("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext())
        {
            word1 = tokenizer.next();
            if (tokenizer.hasNext())
            {
                word2 = tokenizer.next();
                if (tokenizer.hasNext())
                {
                    word3 = tokenizer.next();
                }
            }
        }

        if (commands.isCommand(word1))
        {
            return new Command(word1, word2, word3);
        } else
        {
            return new Command(null, word2, word3);
        }
    }
}

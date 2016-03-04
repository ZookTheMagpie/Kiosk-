/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD
 
=======
>>>>>>> origin/master

import java.util.Iterator;

/**
 *
 * @author HaIIvard
 */
public class CommandWords 
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "add", "help", "quit", "find"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }
    
    public String getValidCommands()
    {
        String returnString = "";
        for(int i = 0; i < validCommands.length; i++)
        {
            returnString = returnString + validCommands[i] + " ";
        }
        return returnString;
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     * 
     * @param aString string to be checked if it is a command.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}

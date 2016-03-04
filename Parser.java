package kioskprosjekt;

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

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public CommandWords getCommandWords()
    {
        return commands;
    }

    public String getInputString()
    {
        return reader.nextLine();
    }

    public int menuSelection()
    {
        System.out.println("> ");
        int menuChoice = reader.nextInt();
        if ((menuChoice < 1) || (menuChoice > 7))
        {
            throw new InputMismatchException();
        }
        return menuChoice;
    }
    
        public int getYesOrNo()
    {
        System.out.println("> ");
        int YesOrNo = reader.nextInt();
        if ((YesOrNo < 1) || (YesOrNo > 2))
        {
            throw new InputMismatchException();
        }
        return YesOrNo;
    }


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

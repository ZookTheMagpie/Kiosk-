/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HaIIvard
 */
public class Newspaper extends Litterature
{
    
    public Newspaper(String title, Publisher publisher)
    {
        super(title, publisher);
    }

    /**
     * Puts together a string that holds the information about the newspaper.
     * 
     * @return The information about the newspaper
     */
    @Override
    public String getInfo()
    {
        String returnString = super.superInfo();
        returnString = "The Newspaper " + returnString;
        return returnString;
    }
    
}

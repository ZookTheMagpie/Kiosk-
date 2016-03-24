/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HaIIvard
 */
public abstract class Litterature
{

    private String title;
    private Publisher publisher;
    
    public Litterature(String title, Publisher publisher)
    {
        this.publisher = publisher;
        this.title = title;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the publisher of the book.
     *
     * @return The publisher of the book.
     */
    public Publisher getPublisher()
    {
        return publisher;
    }
    
    /**
     * Returns the information about the book in a string.
     * 
     * @return The information about the litterature. 
     */
    public abstract String getInfo();
    
    /**
     * Starts building an information string about the litterature, must be finished elsewhere.
     * 
     * @return The information about the litterature avaliable in this super class. 
     */
    public String superInfo()
    {
        String returnString = title + "/npublished by " + publisher.getName();
        return returnString;
    }
    
}

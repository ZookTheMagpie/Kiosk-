 


 ;

/**
 * This class contains the information that defines a book.
 * 
 * @author HaIIvard
 */
public class Book 
{
    private String title;
    private String author;
    private Publisher publisher;
    
    /**
     * Creates a book by giving it a title, an author and a publisher.
     * 
     * @param String title.
     * @param String author.
     * @param Publisher publisher.
     */
    
 public Book(String title, String author, Publisher publisher)
 {
   this.title = title;
   this.publisher = publisher;
   this.author = author;
 }
 
 /**
  * Returns the author of the book.
  */
 public String getAuthor()
 {
     return author;
 }
 
 /**
  * Returns the title of the book.
  */
 public String getTitle()
 {
     return title;
 }
 
 /**
  * Returns the publisher of the book.
  */
 public Publisher getPublisher()
 {
     return publisher;
 }
}

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
    * 
    * @param title the title of the book.
    * @param author the author of the book
    * @param publisher  the publisher of the book
    */ 
 public Book(String title, String author, Publisher publisher)
 {
   this.title = title;
   this.publisher = publisher;
   this.author = author;
 }
 
 /**
  * Returns the author of the book.
  * 
  * @return The author of the book.
  */
 public String getAuthor()
 {
     return author;
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
}

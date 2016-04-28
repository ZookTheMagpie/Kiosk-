
import java.util.InputMismatchException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.Callback;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Creates a pop-up window where the user can add the necessary information for
 * a book. This information includes; The book title, the books publisher, the
 * books author, and the edition of the book.
 *
 * @author Alexander Eilert Berg
 * @version 0.3
 */
public class addBookDialog extends Dialog<Book>
{

    private String bookTitle;
    private String bookPublisher;
    private String bookAuthor;
    private int bookEdition;

    private boolean buttonOK = false;

    public addBookDialog()
    {
        super();
        setTitle("Book Details");

        //Add buttons
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField author = new TextField();
        author.setPromptText("Author");

        TextField edition = new TextField();
        edition.setPromptText("Edition");
        edition.setText("1");

        // Prevent characters (non-integers) to be added
        edition.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() != oldValue.length())
                    {
                        Integer.parseInt(newValue);
                        bookEdition = Integer.parseInt(edition.getText());
                    }
                } catch (NumberFormatException e)
                {
                    edition.setText(oldValue);
                }
            }
        });

        title.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                if (newValue.length() != oldValue.length())
                {
                    bookTitle = title.getText();
                }

            }
        });
        publisher.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {

                if (newValue.length() != oldValue.length())
                {
                    bookPublisher = publisher.getText();
                }

            }
        });
        author.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {

                if (newValue.length() != oldValue.length())
                {
                    bookAuthor = author.getText();
                }

            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Author:"), 0, 2);
        grid.add(author, 1, 2);
        grid.add(new Label("Edition:"), 0, 3);
        grid.add(edition, 1, 3);

        getDialogPane().setContent(grid);

        setResultConverter(new Callback<ButtonType, Book>()
        {
            @Override
            public Book call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {

                    buttonOK = true;
                }
                return null;
            }
        });

    }

    /**
     * Returns the status of the OK button.
     *
     * @return Returns the status of the OK button.
     */
    public boolean isButtonOK()
    {
        return buttonOK;
    }

    /**
     * Returns title of the book.
     *
     * @return Returns title of the book.
     */
    public String getBookTitle()
    {
        return bookTitle;
    }

    /**
     * Returns the books publisher.
     *
     * @return Returns the books publisher.
     */
    public String getBookPublisher()
    {
        return bookPublisher;
    }

    /**
     * Returns the books author.
     *
     * @return Returns the books author.
     */
    public String getBookAuthor()
    {
        return bookAuthor;
    }

    /**
     * Returns the books edition.
     *
     * @return Returns the books edition.
     */
    public int getBookEdition()
    {
        return bookEdition;
    }

}

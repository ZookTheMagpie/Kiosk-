
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

 *
 * @author Alexander Eilert Berg
 * @version 0.3
 */
public class addSeriesDialog extends Dialog<Series>
{

    private String seriesTitle;
    private String seriesPublisher;
    private Book  firstBook;
    private int booksInSeries;

    private boolean buttonOK = false;

    public addSeriesDialog()
    {
        super();
        setTitle("Series Details");

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
        
        TextField book = new TextField();
        book.setPromptText("Book");

        TextField number = new TextField();
        number.setPromptText("Books In Series");

        // Prevent characters (non-integers) to be added
        number.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() != oldValue.length() && newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                        booksInSeries = Integer.parseInt(number.getText());
                    }
                } catch (NumberFormatException e)
                {
                    number.setText(oldValue);
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
                    seriesTitle = title.getText();
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
                    seriesPublisher = publisher.getText();
                }

            }
        });

        book.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {

                if (newValue.length() != oldValue.length())
                {
                    seriesPublisher = publisher.getText();
                }

            }
        });
        
        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Book:"), 0, 2);
        grid.add(book, 1, 2);
        grid.add(new Label("Number in series:"), 0, 3);
        grid.add(number, 1, 3);

        getDialogPane().setContent(grid);

        setResultConverter(new Callback<ButtonType, Series>()
        {
            @Override
            public Series call(ButtonType button)
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
     * Returns title of the series.
     *
     * @return Returns title of the series.
     */
    public String getSeriesTitle()
    {
        return seriesTitle;
    }

    /**
     * Returns the series publisher.
     *
     * @return Returns the series publisher.
     */
    public String getSeriesPublisher()
    {
        return seriesPublisher;
    }
    
    /**
     * Returns the book in series.
     *
     * @return Returns the book in series.
     */
    public int getBookInSeries()
    {
        return booksInSeries;
    }

     /**
     * Returns the first book in the series.
     *
     * @return Returns the first book in the series
     */
    public Book getFirstBook()
    {
        return firstBook;
    }

}

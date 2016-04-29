
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
 * a newspaper. This information includes; The newspaper title, the newspaper
 * publisher, the newspaper genre, and the number of issues in a year.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class addNewspaperDialog extends Dialog<Newspaper>
{

    private String newspaperTitle;
    private String newspaperPublisher;
    private int newspaperIssuesInYear;
    private String newspaperGenre;

    private boolean buttonOK = false;

    public addNewspaperDialog()
    {
        super();
        setTitle("Newspaper Details");

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

        TextField genre = new TextField();
        genre.setPromptText("Genre");

        TextField issuesInYear = new TextField();
        issuesInYear.setPromptText("Issues In Year");

        // Prevent characters (non-integers) to be added
        issuesInYear.textProperty().addListener(new ChangeListener<String>()
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
                        newspaperIssuesInYear = Integer.parseInt(issuesInYear.getText());
                    }
                } catch (NumberFormatException e)
                {
                    issuesInYear.setText(oldValue);
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
                    newspaperTitle = title.getText();
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
                    newspaperPublisher = publisher.getText();
                }

            }
        });
        genre.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {

                if (newValue.length() != oldValue.length())
                {
                    newspaperGenre = genre.getText();
                }

            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Genre:"), 0, 2);
        grid.add(genre, 1, 2);
        grid.add(new Label("Issues In Year:"), 0, 3);
        grid.add(issuesInYear, 1, 3);

        getDialogPane().setContent(grid);

        setResultConverter(new Callback<ButtonType, Newspaper>()
        {
            @Override
            public Newspaper call(ButtonType button)
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
     * Returns the title of the newspaper.
     *
     * @return Returns the title of the newspaper..
     */
    public String getNewspaperTitle()
    {
        return newspaperTitle;
    }

    /**
     * Returns the newspaper publisher.
     *
     * @return Returns the newspaper Publisher.
     */
    public String getNewspaperPublisher()
    {
        return newspaperPublisher;
    }

    /**
     * Returns the genre for the newspaper.
     *
     * @return Returns the genre for the newspaper.
     */
    public String getNewspaperGenre()
    {
        return newspaperGenre;
    }

    /**
     * Returns number of newspaper issues in year.
     *
     * @return Returns number of newspaper issues in year.
     */
    public int getNewspaperIssuesInYear()
    {
        return newspaperIssuesInYear;
    }

}

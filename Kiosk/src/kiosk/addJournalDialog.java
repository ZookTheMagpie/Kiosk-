
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
 * a journal. This information includes; The journal title, the journal
 * publisher, the journal genre, and the number of issues in a year.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class addJournalDialog extends Dialog<Journal>
{

    private String journalTitle;
    private String journalPublisher;
    private int journalIssuesInYear;
    private String journalGenre;

    private boolean buttonOK = false;

    public addJournalDialog()
    {
        super();
        setTitle("Journal Details");

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
                        journalIssuesInYear = Integer.parseInt(issuesInYear.getText());
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
                    journalTitle = title.getText();
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
                    journalPublisher = publisher.getText();
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
                    journalGenre = genre.getText();
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

        setResultConverter(new Callback<ButtonType, Journal>()
        {
            @Override
            public Journal call(ButtonType button)
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
     * Returns the title of the journal.
     *
     * @return Returns the title of the journal..
     */
    public String getJournalTitle()
    {
        return journalTitle;
    }

    /**
     * Returns the journal publisher.
     *
     * @return Returns the journal Publisher.
     */
    public String getJournalPublisher()
    {
        return journalPublisher;
    }

    /**
     * Returns the genre for the journal.
     *
     * @return Returns the genre for the journal.
     */
    public String getJournalGenre()
    {
        return journalGenre;
    }

    /**
     * Returns number of journal issues in year.
     *
     * @return Returns number of journal issues in year.
     */
    public int getJournalIssuesInYear()
    {
        return journalIssuesInYear;
    }

}

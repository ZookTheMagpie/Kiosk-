
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
 * a magazine. This information includes; The magazine title, the magazines
 * publisher, the magazine genre, and the number of issues in a year.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class addMagazineDialog extends Dialog<Magazine>
{

    private String magazineTitle;
    private String magazinePublisher;
    private int magazineIssuesInYear;
    private String magazineGenre;

    private boolean buttonOK = false;

    public addMagazineDialog()
    {
        super();
        setTitle("Magazine Details");

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
        issuesInYear.setText("1");

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
                        magazineIssuesInYear = Integer.parseInt(issuesInYear.getText());
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
                    magazineTitle = title.getText();
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
                    magazinePublisher = publisher.getText();
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
                    magazineGenre = genre.getText();
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

        setResultConverter(new Callback<ButtonType, Magazine>()
        {
            @Override
            public Magazine call(ButtonType button)
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
     * Returns the title of the magazine.
     *
     * @return Returns the title of the magazine.
     */
    public String getMagazineTitle()
    {
        return magazineTitle;
    }

    /**
     * Returns the magazine publisher.
     *
     * @return Returns the magazine publisher.
     */
    public String getMagazinePublisher()
    {
        return magazinePublisher;
    }

    /**
     * Returns the genre for the magazine.
     *
     * @return Returns the genre for the magazine.
     */
    public String getMagazineGenre()
    {
        return magazineGenre;
    }

    /**
     * Returns number of magazines issues in year.
     *
     * @return Returns number of magazines issues in year.
     */
    public int getMagazineIssuesInYear()
    {
        return magazineIssuesInYear;
    }

}

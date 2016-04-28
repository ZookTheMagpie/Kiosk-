
import java.util.InputMismatchException;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author HaIIvard
 */
public class KioskGUI extends Application implements EventHandler<ActionEvent>, Observer
{

    private TextField filterField;

    private KioskLogic kioskL;
    private ObservableList<Literature> literatures;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void init()
    {
        kioskL = new KioskLogic();
        try
        {
            kioskL.addToRegisterObserverList(this);
        } catch (InputMismatchException e)
        {
            System.out.println("The observer is already in the list");
        } catch (IllegalArgumentException e)
        {
            System.out.println("You did not enter an Observer.");
        }

    }

    @Override
    public void start(Stage primaryStage)
    {

        BorderPane root = new BorderPane(); // Create the root node. The Menu will be placed at the top
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar menuBar = createMenu();
        topContainer.getChildren().add(menuBar);
        // Place the topcontainer in the top-section of the BorderPane
        root.setTop(topContainer);

        // Place the centre content
        root.setCenter(createCentreContent());

        // Create the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 400, 500);
        // Set title of the stage (window) and add the scene
        primaryStage.setTitle("Kiosk");
        primaryStage.setScene(scene);
        // Finally, make the stage (window) visible
        primaryStage.show();

    }

    @Override
    public void stop()
    {
        System.exit(0);
    }

    /**
     * Handles searches done by the user
     *
     * @param oldVal
     * @param newVal
     */
    public void handleSearchByKey(String oldVal, String newVal)
    {

        if (newVal.length() == 0)
        {
            update();
        }
        if (oldVal.length() != newVal.length())
        {

            // Change to upper case so that case is not an issue
            newVal = newVal.toUpperCase();

            literatures.setAll(kioskL.findLiterature(newVal));
        }
    }

    /**
     * Creates the centre content for the application
     *
     * @return the centre content
     */
    private Node createCentreContent()
    {
        VBox vbox = new VBox();
        TextField textField = new TextField();

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setPadding(new Insets(15, 15, 15, 15));
        textField.setMaxWidth(200.0);
        textField.setPromptText("Search");
        textField.setAlignment(Pos.CENTER);
        textField.textProperty().addListener(
                new ChangeListener()
        {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue)
            {
                handleSearchByKey((String) oldValue, (String) newValue);
            }
        });
        hbox1.getChildren().add(textField);

        TableView tableView;

        // Define the columns
        // The Title-column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        tableView = new TableView();
        tableView.setItems(getLitteratureList());
        tableView.getColumns().addAll(titleColumn, publisherColumn);

        vbox.getChildren().addAll(hbox1, tableView);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(15, 15, 15, 15));
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Exit application?");
                alert.setContentText("Are you sure you want to exit?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                    Platform.exit();
                } else
                {
                }
            }
        });
        exitButton.setAlignment(Pos.CENTER_RIGHT);

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                TablePosition pos = (TablePosition) tableView.getSelectionModel().getSelectedCells().get(0);

// this gives the value in the selected cell:
                String data = (String) pos.getTableColumn().getCellObservableValue(tableView.getItems().get(pos.getRow())).getValue();
                String litName = data.toUpperCase();

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Remove literature??");
                alert.setContentText("Are you sure you want to remove " + data + "?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                    kioskL.removeLit(litName);
                } else
                {
                }
            }
        });
        removeButton.setAlignment(Pos.CENTER_LEFT);

        hbox.getChildren().addAll(removeButton, exitButton);

        vbox.getChildren().add(hbox);

        return vbox;
    }

    /**
     * Creates the menu for the application
     *
     * @return The menu bar.
     */
    private MenuBar createMenu()
    {
        MenuBar menuBar = new MenuBar();
        Menu addMenu = new Menu("Add Literature");
        MenuItem book = new MenuItem("Book");
        MenuItem newspaper = new MenuItem("Newspaper");
        MenuItem magazine = new MenuItem("Magazine");
        MenuItem journal = new MenuItem("Journal");
        addMenu.getItems().addAll(book, newspaper, magazine, journal);
        book.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureWithAuthorToRegister("book", "Lord of the Rings", "J.R.R. Tolkien", getPublisher("Gyldendahl"), 1);
            }
        });
        newspaper.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("newspaper", "VG", getPublisher("Per"), 1, "News");
            }
        });
        magazine.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("magazine", "Se og Hør", getPublisher("Per"), 1, "Sladder");
            }
        });
        journal.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("journal", "MatLab", getPublisher("Ntnu"), 1, "Vitskap");
            }
        });
        Menu addSeries = new Menu("Add Series");

        menuBar.getMenus().addAll(addMenu, addSeries);
        return menuBar;
    }

    /**
     * Returns the publisher for the new litterature, if the publisher doesn't
     * exist, you have the choice of creating one.
     *
     * @return Publisher to use for litterature creation.
     */
    private Publisher getPublisher(String publisherName)
    {
        Publisher publ = kioskL.getPublisher(publisherName);
        if (publ == null)
        {
            kioskL.addPublisherToRegister(publisherName);
            publ = kioskL.getPublisher(publisherName);
        }

        return publ;
    }

    /**
     * Returns an ObservableList holding the literatures to display.
     *
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLitteratureList()
    {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures = FXCollections.observableArrayList(kioskL.getLiteratureList());
        return literatures;
    }

    /**
     * Updates the ObservableArray wrapper with the current content in the
     * Literature register. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    @Override
    public void update()
    {
        this.literatures.setAll(kioskL.getLiteratureList());
    }

    @Override
    public void handle(ActionEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

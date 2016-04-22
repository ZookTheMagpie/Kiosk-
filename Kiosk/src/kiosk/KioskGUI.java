
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.control.TableView;
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
public class KioskGUI extends Application implements EventHandler<ActionEvent>
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
     * Creates the centre content for the application
     * @return the centre content
     */
    private Node createCentreContent()
    {
        VBox vbox = new VBox();
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

        vbox.getChildren().add(tableView);

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
                if(result.get() == ButtonType.OK)
                {                
                Platform.exit();
                }
                else{}
            }
        });
        exitButton.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(exitButton);

        vbox.getChildren().add(hbox);

        return vbox;
    }

    /**
     * Creates the menu for the application
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
                updateObservableList();
            }
        });
        newspaper.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("newspaper", "VG", getPublisher("Per"), 1, "News");
                updateObservableList();
            }
        });
        magazine.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("magazine", "Se og Hør", getPublisher("Per"), 1, "Sladder");
                updateObservableList();
            }
        });
        journal.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                kioskL.addLiteratureToRegister("journal", "MatLab", getPublisher("Ntnu"), 1, "Vitskap");
                updateObservableList();
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
    private void updateObservableList()
    {
        this.literatures.setAll(kioskL.getLiteratureList());
    }

    @Override
        public void handle(ActionEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;

public class ListVieww extends Application
{
    private String[] countries = {"Canada", "Cuba", "Dominica", "Haiti", "Jamaica", "Mexico", "USA"};
    private String[] modes = {"SINGLE", "MULTIPLE"};

    @Override
    public void start(Stage primaryStage)
    {
        /* this part creates the components and sets them up */

        //this is the labels, selected items is set default to [single]
        Label selectedItems = new Label("Current selected item is ");
        Label selectionMode = new Label("Selection Mode: ");
       
        //combo box
        ComboBox<String> cbo = new ComboBox<>();
        cbo.getItems().addAll(FXCollections.observableArrayList(modes));
        cbo.getSelectionModel().selectFirst();

        //list view's default state is single
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(countries));
        lv.setPrefSize(490,180);

        /* this part sets the actions of the components */
        cbo.setOnAction(e -> {
            if(cbo.getValue().equals("SINGLE"))
            {
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                selectedItems.setText("Current selected(s) item are ");
            }
            else
            {
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                selectedItems.setText("The selected items are ");
            }
        });
        
        lv.getSelectionModel().selectedItemProperty().addListener( oc -> {
            String j = "";
            for(String i : lv.getSelectionModel().getSelectedItems())    
                j+=i+" ";

            selectedItems.setText(" Current selected item(s) is " + j);
        });

        //border panes
        BorderPane top = new BorderPane();
        top.setRight(cbo);
        top.setCenter(selectionMode);
    
        BorderPane total = new BorderPane();
        total.setTop(top);
        total.setCenter(new ScrollPane(lv));
        total.setBottom(selectedItems);

        //window sizing
        int width = 510;
        int height = 260;

        primaryStage.setMinHeight(height);
		primaryStage.setMinWidth(width);
        primaryStage.setMaxHeight(height);
		primaryStage.setMaxWidth(width);

        Scene scene = new Scene(total, width, height);
        primaryStage.setTitle("ListView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

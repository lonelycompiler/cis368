import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Priority;

public class Exercise_16_17 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
      Label text = new Label("Show Colors");
      text.setFont( new Font("Calibri", 25));
      //text.setTextFill(Color.RED)

      Slider redHorizontal = new Slider(0, 255, 255);
      Slider blueHorizontal = new Slider(0, 255, 0);
      Slider greenHorizontal = new Slider(0, 255, 0);
      Slider opacityHorizontal = new Slider(0, 1, 1);

      Label red = new Label("Red");
      red.setTextFill(Color.RED);
      Label blue = new Label("Blue");
      blue.setTextFill(Color.BLUE);
      Label green = new Label("Green");
      green.setTextFill(Color.GREEN);
      Label opacity = new Label("Opacity");

      text.setTextFill(Color.rgb((int)redHorizontal.getValue(), (int)greenHorizontal.getValue(), (int)blueHorizontal.getValue()));
      text.setOpacity(opacityHorizontal.getValue());

      redHorizontal.valueProperty().addListener(ov ->
        text.setTextFill(Color.rgb((int)redHorizontal.getValue(), (int)greenHorizontal.getValue(), (int)blueHorizontal.getValue())));

      greenHorizontal.valueProperty().addListener(ov ->
        text.setTextFill(Color.rgb((int)redHorizontal.getValue(), (int)greenHorizontal.getValue(), (int)blueHorizontal.getValue())));

      blueHorizontal.valueProperty().addListener(ov ->
        text.setTextFill(Color.rgb((int)redHorizontal.getValue(), (int)greenHorizontal.getValue(), (int)blueHorizontal.getValue())));
      
      opacityHorizontal.valueProperty().addListener(ov ->
        text.setOpacity(opacityHorizontal.getValue()));

      /* panes */
      HBox textpane = new HBox();
      textpane.getChildren().add(text);
      textpane.setAlignment(Pos.CENTER);

      HBox redslider = new HBox();
      redslider.getChildren().addAll(red, redHorizontal);
      redslider.setHgrow(redHorizontal, Priority.ALWAYS);

      HBox bluslider = new HBox();
      bluslider.getChildren().addAll(blue, blueHorizontal);
      bluslider.setHgrow(blueHorizontal, Priority.ALWAYS);
      
      HBox greenslider = new HBox();
      greenslider.getChildren().addAll(green, greenHorizontal);
      greenslider.setHgrow(greenHorizontal, Priority.ALWAYS);
      
      HBox opacityslider = new HBox();
      opacityslider.getChildren().addAll(opacity, opacityHorizontal);
      opacityslider.setHgrow(opacityHorizontal, Priority.ALWAYS);

      VBox stuff = new VBox();
      stuff.getChildren().addAll(redslider, bluslider, greenslider,opacityslider);
      stuff.setSpacing(30);
      stuff.setPadding(new Insets(10, 50, 50, 50));

      BorderPane pane = new BorderPane();
      pane.setCenter(textpane);
      pane.setBottom(stuff);

      /* window stuff */
      int width = 500;
      int height = 300;

      primaryStage.setMinHeight(height);
      primaryStage.setMinWidth(width);
      primaryStage.setMaxHeight(height);
      primaryStage.setMaxWidth(width);

      Scene scene = new Scene(pane, width, height);
      primaryStage.setTitle("Exercise_16_17");
      primaryStage.setScene(scene);
      primaryStage.show();
  }
}
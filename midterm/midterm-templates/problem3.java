import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class problem3 extends Application {

    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 400;


        pane.setOnMouseClicked(e-> {
            double x = e.getX();
            double y = e.getY();

            if (e.getButton() == MouseButton.PRIMARY) {
                Circle c = drawPoint(x,y);
                pane.getChildren().add(c);
            } else if (e.getButton() == MouseButton.SECONDARY) {

                removePoint(x, y);
            }


        });

        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("click to draw circle");
        primaryStage.show();
    }

    private Circle drawPoint(double x, double y) {
        Circle c = new Circle(x, y, 10, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        return c;
    }

    private void removePoint(double x, double y) {

        ObservableList<Node> list = pane.getChildren();
        for (int i = list.size() - 1; i >= 0; i--) {
            Node c = list.get(i);

            if (c instanceof Circle && c.contains(x, y)) {
                pane.getChildren().remove(c);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
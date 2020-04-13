import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import java.util.*;

public class Smiley extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Collection<Node> shapes = new ArrayList<Node>();

        //Drawing a Circle
        Circle face = new Circle();

        face.setCenterX(500.0);
        face.setCenterY(500.0);
        face.setRadius(500.0);
        face.setFill(javafx.scene.paint.Color.YELLOW);
        shapes.add(face);

        Ellipse leftEye = new Ellipse();
        leftEye.setCenterX(300);
        leftEye.setCenterY(300);
        leftEye.setRadiusX(50);
        leftEye.setRadiusY(150);
        shapes.add(leftEye);

        Ellipse rightEye = new Ellipse();
        rightEye.setCenterX(700);
        rightEye.setCenterY(300);
        rightEye.setRadiusX(50);
        rightEye.setRadiusY(150);
        shapes.add(rightEye);

        Arc smile = new Arc();
        smile.setCenterX(500.0f);
        smile.setCenterY(600.0f);
        smile.setRadiusX(350.0f);
        smile.setRadiusY(150.0f);
        smile.setStartAngle(220.0f);
        smile.setLength(100.0f);
        shapes.add(smile);

        //Creating a Group object  
        Group root = new Group(shapes); 

        //Creating a scene object 
        Scene scene = new Scene(root, 600, 300);  

        //Setting title to the Stage 
        stage.setTitle("Drawing a Circle"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
        stage.setWidth(1000);
        stage.setHeight(1000);

        //Displaying the contents of the stage 
        stage.show();
    }
}

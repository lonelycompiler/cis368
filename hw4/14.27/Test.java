//import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;

public class Test extends Application
{
    public static void main(String[] args)
    {
      launch(args);
   }

   @Override
   public void start(Stage stage)
   {
        //Test test = new Test();
        ClockPane clock = new ClockPane();
        clock.setWidth(300);
        clock.setHeight(300);
        clock.setCurrentTime();


        Scene scene = new Scene(clock, 600, 600);
        stage.setTitle("Clock Pane");
        stage.setScene(scene); 
        stage.show();
    }
}
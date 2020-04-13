import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;+

import javafx.stage.*;
import javafx.scene.paint.Color;
import java.util.*;

public class SudokuGrid extends Application
{

   private final int smallSquareSize = 100;
   private final int bigSquareSize = smallSquareSize*3;
   private final int offset = 10;

   private final int sizeOfGrid = 9;

   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      Collection<Node> squares = new ArrayList();
      //SMALL RECTANGLES
      for(int i = 0; i < sizeOfGrid; ++i) {
         for(int j = 0; j < sizeOfGrid; ++j) {
            Rectangle sRect = new Rectangle();
            sRect.setWidth(smallSquareSize);
            sRect.setHeight(smallSquareSize);
            sRect.setX(offset+i*smallSquareSize);
            sRect.setY(offset+j*smallSquareSize);
            sRect.setFill(javafx.scene.paint.Color.WHITE);
            sRect.setStroke(Color.BLACK);
            sRect.setStrokeType(StrokeType.OUTSIDE);
            sRect.setStrokeWidth(1);
            squares.add(sRect);
         }
      }
      int m =0;
      //BIG RECTANGLES
      for(int i = 0; i < sizeOfGrid/3; ++i) {
         for(int j = 0; j < sizeOfGrid/3; ++j) {
            if(m%3 == 0) {
               Rectangle bRect = new Rectangle();
               bRect.setWidth(bigSquareSize);   
               bRect.setHeight(bigSquareSize);
               bRect.setX(offset+i*bigSquareSize);
               bRect.setY(offset+j*bigSquareSize);
               bRect.setFill(Color.TRANSPARENT);
               bRect.setStroke(Color.BLACK);
               //bRect.setStrokeType(StrokeType.OUTSIDE);
               bRect.setStrokeWidth(3);
               squares.add(bRect);
               ++m;
            }
            m=0;
         }
      }

      Group group = new Group(squares);
      Scene scene = new Scene(group, 600, 300);
      stage.setTitle("SUDOKU");
      stage.setScene(scene); 
      stage.setWidth(900+offset*2);
      stage.setHeight(900+offset*6);
      stage.show();
   }
}

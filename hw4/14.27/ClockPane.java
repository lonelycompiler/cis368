import java.util.Calendar; 
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = Math.min(getWidth(), getHeight()) * 0.7 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    circle.setStrokeWidth(5);

    final int fontSize = 20;

    Text t1 = new Text(centerX - 1, centerY + clockRadius - 3,   "1");
    Text t2 = new Text(centerX + 3, centerY - clockRadius - 5,   "2");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3,  "3");
    Text t4 = new Text(centerX - 5, centerY - clockRadius + 12,  "4");
    Text t5 = new Text(centerX - 5, centerY - clockRadius - 12,  "5");
    Text t6 = new Text(centerX - 3, centerY + clockRadius - 3,   "6");
    Text t7 = new Text(centerX - 5, centerY - clockRadius + 12,  "7");
    Text t8 = new Text(centerX - 5, centerY - clockRadius + 12,  "8");
    Text t9 = new Text(centerX - clockRadius + 3, centerY + 5,   "9");
    Text t10 = new Text(centerX - 5, centerY - clockRadius + 12, "10");
    Text t11 = new Text(centerX - 5, centerY - clockRadius + 12, "11");
    Text t12 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    t1.setFont(new Font(fontSize));
    t2.setFont(new Font(fontSize));
    t3.setFont(new Font(fontSize));
    t4.setFont(new Font(fontSize));
    t5.setFont(new Font(fontSize));
    t6.setFont(new Font(fontSize));
    t7.setFont(new Font(fontSize));
    t8.setFont(new Font(fontSize));
    t9.setFont(new Font(fontSize));
    t10.setFont(new Font(fontSize));
    t11.setFont(new Font(fontSize));
    t12.setFont(new Font(fontSize));

    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLACK);
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.BLACK);
    
    getChildren().clear(); // Clear the pane
    getChildren().addAll(circle, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, sLine, mLine, hLine);
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}
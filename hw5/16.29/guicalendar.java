import java.time.LocalDate;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.paint.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class guicalendar extends Application
{
    private int cols = 7;
    private int rows = 7;

    private String getMonthStr(int m)
    {
        String month = "";
        System.out.println("m is " + m);
        switch(m)
        {
            case 1: month = "January";
            case 2: month = "February";
            case 3: month = "March";
            case 4: month = "April";
            case 5: month = "May";
            case 6: month = "June";
            case 7: month = "July";
            case 8: month = "August";
            case 9: month = "September";
            case 10: month = "October";
            case 11: month = "November";
            case 12: month = "December";
        }
        return month;
    }

    private String[][] generateCalendar(LocalDate current)
    {
        //[r][c]
        String[][] cal = new String[rows][cols];
        LocalDate firstDay = current.withDayOfMonth(1);
        cal[0][0] = "Su";
        cal[0][1] = "Mo";
        cal[0][2] = "Tu";
        cal[0][3] = "We";
        cal[0][4] = "Th";
        cal[0][5] = "Fr";
        cal[0][6] = "Sa";
        int fd = firstDay.getDayOfWeek().getValue()-1;
        int counter = 1, i = 1, j = 0;
        while(i < rows)
        {
            while(j < cols && counter != firstDay.lengthOfMonth())
            {
                if(i == 1 && j == 0) j = (fd+1)%7;
                cal[i][j] = ""+counter;
                j++;counter++;
            }
            j=0;
        ++i;
        }
        return cal;
    }
    LocalDate currentDate;
    @Override
    public void start(Stage primaryStage)
    {
        currentDate = LocalDate.now(); // 2016-06-17
        /*DayOfWeek dow = currentDate.getDayOfWeek(); // FRIDAY
        int dom = currentDate.getDayOfMonth(); // 17
        int doy = currentDate.getDayOfYear(); // 169
        Month m = currentDate.getMonth(); // JUNE
        int y = currentDate.getYear(); // 2016
        
*/
        //get first day of the month, use that to find the rest of the days..
        String[][] calendarStr = generateCalendar(currentDate);
        
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(30));
        gridpane.setHgap(80);
        gridpane.setVgap(60);
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
            {
                Label tempLabel = new Label(calendarStr[i][j]);
                String dayOfMonth = currentDate.getDayOfMonth() + "";
                if(calendarStr[i][j] != null && calendarStr[i][j].equals(dayOfMonth))
                tempLabel.setStyle("-fx-background-color: blue;");
                tempLabel.setTextFill(Color.WHITE);
                gridpane.add(tempLabel, j, i);
            }

        Label monthLabel = new Label(currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + currentDate.getYear());
        monthLabel.setFont( new Font("Calibri", 25));
        monthLabel.setTextFill(Color.WHITE);

        Button prevArrow = new Button("←");
        prevArrow.setPadding(new Insets(20));
        prevArrow.setTextFill(Color.WHITE);
        prevArrow.setStyle("-fx-background-color: black;");
        Button forwArrow = new Button("→");
        forwArrow.setPadding(new Insets(20));
        forwArrow.setTextFill(Color.WHITE);
        forwArrow.setStyle("-fx-background-color: black;");

        HBox arrStuff = new HBox();
        arrStuff.getChildren().addAll(prevArrow, forwArrow);

        BorderPane topStuff = new BorderPane();
        topStuff.setLeft(monthLabel);
        topStuff.setRight(arrStuff);

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: black;");
        pane.setTop(topStuff);
        pane.setCenter(gridpane);

        //window sizing
        int width = 670;
        int height = 550;

        primaryStage.setMinHeight(height);
		primaryStage.setMinWidth(width);
        primaryStage.setMaxHeight(height);
		primaryStage.setMaxWidth(width);

        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();

        prevArrow.setOnAction(e -> {
            LocalDate previousMonth = currentDate.withDayOfMonth(1).withMonth(currentDate.getMonthValue()-1);
            String[][] tempCalendar = generateCalendar( previousMonth );
            
            Label prevMonthLabel = new Label(previousMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + previousMonth.getYear());
            prevMonthLabel.setFont( new Font("Calibri", 25));
            prevMonthLabel.setTextFill(Color.WHITE);
            
            GridPane prevMonthCalendarPane = new GridPane();
            prevMonthCalendarPane.setPadding(new Insets(15));
            prevMonthCalendarPane.setHgap(80);
            prevMonthCalendarPane.setVgap(60);
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < cols; j++)
                {
                    Label tempLabel = new Label(tempCalendar[i][j]);
                    tempLabel.setTextFill(Color.WHITE);
                    prevMonthCalendarPane.add(tempLabel, j, i);
                }
            topStuff.setLeft(null);
            topStuff.setLeft(prevMonthLabel);
            pane.setTop(null);
            pane.setTop(topStuff);
            pane.setCenter(null);
            pane.setCenter(prevMonthCalendarPane);
            currentDate = previousMonth;
        });

        forwArrow.setOnAction(e -> {
            LocalDate nextMonth = currentDate.withDayOfMonth(1).withMonth(currentDate.getMonthValue()+1);
            String[][] tempCalendar = generateCalendar( nextMonth );
            
            Label nextMonthLabel = new Label(nextMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + nextMonth.getYear());
            nextMonthLabel.setFont( new Font("Calibri", 25));
            nextMonthLabel.setTextFill(Color.WHITE);
            
            GridPane nextMonthCalendarPane = new GridPane();
            nextMonthCalendarPane.setPadding(new Insets(15));
            nextMonthCalendarPane.setHgap(80);
            nextMonthCalendarPane.setVgap(60);
            for(int i = 0; i < rows; i++)
                for(int j = 0; j < cols; j++)
                {
                    Label tempLabel = new Label(tempCalendar[i][j]);
                    tempLabel.setTextFill(Color.WHITE);
                    nextMonthCalendarPane.add(tempLabel, j, i);
                }
            topStuff.setLeft(null);
            topStuff.setLeft(nextMonthLabel);
            pane.setTop(null);
            pane.setTop(topStuff);
            pane.setCenter(null);
            pane.setCenter(nextMonthCalendarPane);
            currentDate = nextMonth;
        });
    }
}

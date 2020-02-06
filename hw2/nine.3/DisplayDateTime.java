import java.util.Date;

public class DisplayDateTime {
    Date date = new Date();

    public static void main(String[] args) {
        DisplayDateTime ddt = new DisplayDateTime();
        
        long i = 10000L;
        while(i < (long) 100000000000L) {
            ddt.date.setTime(i);
            ddt.displayDate();
            i*=10;
        }
    }

    private void displayDate() {
        System.out.println("The date/time is " + date.toString() + "!");
    }
}
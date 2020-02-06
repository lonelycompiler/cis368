import java.util.GregorianCalendar;

public class displayDateSetTime {
	GregorianCalendar gc;
	public displayDateSetTime() {
		gc = new GregorianCalendar();
	}
	
	public void displayDate() {
		System.out.println("current year:  " + gc.get(GregorianCalendar.YEAR) );
		
		String month = "";
		
		switch( gc.get(GregorianCalendar.MONTH) ) {
			case 0: month = "January"; break;
			case 1: month = "February"; break;
			case 2: month = "March"; break;
			case 3: month = "April"; break;
			case 4: month = "May"; break;
			case 5: month = "June"; break;
			case 6: month = "July"; break;
			case 7: month = "August"; break;
			case 8: month = "September"; break;
			case 9: month = "October"; break;
			case 10: month = "November"; break;
			case 11: month = "December"; break;
		}
		System.out.println("current month: " +  month);
		
		System.out.println("current day:   " + gc.get(GregorianCalendar.DATE) );
	}
	
	public static void main(String[] args) {
		displayDateSetTime ddos = new displayDateSetTime();
		System.out.println("\n---- Displaying today's date ----");
		ddos.displayDate();
		
		System.out.println("\n---- Display date at 1234567898765L miliseconds ----");
		ddos.gc.setTimeInMillis(1234567898765L);
		ddos.displayDate();
	}
}

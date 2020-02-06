
public class Test {
	public static void main(String[] args) {
		Account ac = new Account(1122, 20000);
		ac.setAnnualInterestRate(0.045);
		
		ac.withdraw(2500);
		ac.deposit(3000);
		System.out.print(
		    "Current Balance is  $"  + ac.getBalance()
		+ "\nMonthly interest is "  + ac.getMonthlyInterestRate() + "%"
		+ "\nDate Created is     "  + ac.getDateCreated().getDate() + " of ");
		String month = "";
		
		switch( ac.getDateCreated().getMonth()) ) {
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
		System.out.println(", " +  ac.getDateCreated().getYear());

	}
}

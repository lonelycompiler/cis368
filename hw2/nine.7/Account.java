import java.util.Date;

public class Account {
	private int id;
	
	private double balance;
	private double annualInterestRate;
	
	private Date dateCreated; //when account was created
	
	public Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date(); //sets dateCreated to now, the exact milisecond it was created.
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	//accessor methods for id, balance, and annualInterestRate
	public int getID() { return id; }
	public double getBalance() { return balance; }
	public double getAnnualInterestRate() { return annualInterestRate; }
	public Date getDateCreated() { return this.dateCreated; }
	
	//mutator methods for id, balance, and annualInterestRate
	public void setID(int id) { this.id = id; }
	public void setBalance(double balance) { this.balance = balance; }
	public void setAnnualInterestRate(double annualInterestRate) { this.annualInterestRate = annualInterestRate; }
	
	//returns monthly interest rate
	public double getMonthlyInterestRate() { return annualInterestRate/12; }
	
	public void withdraw(double amount) { balance-=amount; }
	
	public void deposit(double amount) { balance+=amount; }
}

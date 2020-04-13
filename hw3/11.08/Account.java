import java.util.Date;
import java.util.ArrayList;

public class Account {
        private int id;

        private double balance;
        private double annualInterestRate;

        private Date dateCreated; //when account was created

	private String name;

	private ArrayList<Transaction> transaction;

	private class Transaction {
		Date date;
		char type;
		double amount;
		double balance;
		String description;

		Transaction(char type, double amount, double balance, String description) {
			this.type = type;
			this.amount = amount;
			this.balance = balance;
			this.description = new String(description);
		}

		//accessor methods
		char getType() {
			return this.type;
		}

		double getAmount() {
			return this.amount;
		}

		double getBalance() {
			return this.balance;
		}
		
		String getDescription() {
			return this.description;
		}

		//mutator methods
		void setType(char type) {
			this.type = type;
		}

		void setAmount(double amount) {
			this.amount = amount;
		}

		void setBalance(double balance) {
			this.balance = balance;
		}

		void setDescription(String description) {
			this.description = description;
		}
	}

        public Account() {
                id = 0;
                balance = 0;
                annualInterestRate = 0;
                dateCreated = new Date(); //sets dateCreated to now, the exact milisecond it was created.
        }

        public Account(int id, double balance) {
                this.id = id;
                this.balance = balance;
		dateCreated = new Date();
        }

	public Account(String name, int id, double balance) {
		this.name = name;
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


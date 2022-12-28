package bank;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements SavingsAccount {

	String username, password, name, address, phone;
	double balance;
	ArrayList<String> transactions;

	public Customer(String username, String password, String name, String address, String phone, double balance,
			Date date) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.balance = balance;
		transactions = new ArrayList<String>(5);
		addTransaction(String.format("Initial deposit - " + NumberFormat.getCurrencyInstance().format(balance)
				+ " as on " + "%1$tD" + " at " + "%1$tT.", date));
	}

	void update(Date date) {
		// TODO Auto-generated method stub
		if (balance >= 10_000)
			balance += rate * balance;
		else
			balance -= (int) balance / 100.0;
		addTransaction(String.format("Account updated. balance - " + NumberFormat.getCurrencyInstance().format(balance)
				+ " as on " + "%1$tD " + " at " + "%1$tT.", date));
	}

	private void addTransaction(String mess) {
		// TODO Auto-generated method stub
		transactions.add(0, mess);
		if (transactions.size() > 5) {
			transactions.remove(5);
			transactions.trimToSize();
		}
	}

	@Override
	public void deposit(double amount, Date date) {
		// TODO Auto-generated method stub
		balance += amount;
		addTransaction(String.format(
				NumberFormat.getCurrencyInstance().format(amount) + " credited to your account. balance - "
						+ NumberFormat.getCurrencyInstance().format(balance) + " as on " + "%1$tD " + " at " + "%1$tT.",
				date));
	}

	@Override
	public void withdraw(double amount, Date date) {
		// TODO Auto-generated method stub
		if (amount > (balance - 200)) {
			System.out.println("Insufficient balance.");
			return;
		}
		balance -= amount;
		addTransaction(String.format(
				NumberFormat.getCurrencyInstance().format(amount) + " debited from your account. Balance - "
						+ NumberFormat.getCurrencyInstance().format(balance) + " as on " + "%1$tD" + " at " + "%1$tT.",
				date));
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public double getbalance() {
		return balance;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}
}

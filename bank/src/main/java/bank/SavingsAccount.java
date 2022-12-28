package bank;

import java.util.Date;

public interface SavingsAccount {

	double rate = 0.02, limit = 10_000, limit1 = 200;

	void deposit(double amount, Date date);

	void withdraw(double amount, Date date);
}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SavingsAccountTest {
	
	private SavingsAccount theAccount;
	
	@Test
	public void new_accounts_start_with_a_zero_balance() {
		BankCustomer aCustomer = new BankCustomer("John Doe", "123 Main St", "123-456-7890");
		SavingsAccount theAccount = new SavingsAccount(aCustomer, new DollarAmount(0), "1234");
		DollarAmount currentAmount = theAccount.getBalance();
		DollarAmount zeroDollars = new DollarAmount(0);
		Assert.assertEquals(zeroDollars, currentAmount);
	}
	
	@Test
	public void deposit_increases_the_account_balance_by_the_amount_deposited() {
		BankCustomer aCustomer = new BankCustomer("John Doe", "123 Main St", "123-456-7890");
		SavingsAccount theAccount = new SavingsAccount(aCustomer, new DollarAmount(0), "1234");
		DollarAmount amountDeposited = new DollarAmount(12345);
		DollarAmount newBalance = theAccount.deposit(amountDeposited);
		Assert.assertEquals(amountDeposited, newBalance);
		Assert.assertEquals(amountDeposited, theAccount.getBalance());
	}
	@Test
	public void getReturns_sercharge_in_dollars() {
		BankCustomer bob = new BankCustomer("Bob", "1234 hill", "1234567890");
		DollarAmount bobsMoney = new DollarAmount(10000);
		String pin = new String ("1234");
		SavingsAccount charge = new SavingsAccount(bob, bobsMoney, pin);
		DollarAmount serCharge = charge.getSerChargeInDollars();
		Assert.assertEquals(new DollarAmount(200), serCharge);
	}
}

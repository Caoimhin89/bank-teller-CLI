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
	@Test
	public void subtracts_desired_amount_from_account_plus_sercharge_of_$2() {
		BankCustomer kevin = new BankCustomer("Kevin Glick", "Ohio", "2168709302");
		SavingsAccount myAccount = new SavingsAccount(kevin , new DollarAmount(10000), "1989");
		DollarAmount afterWithdraw = myAccount.withdraw(new DollarAmount(5000));
		Assert.assertEquals(new DollarAmount(4800), afterWithdraw);
	}
	@Test
	public void does_not_allow_withdraw_if_new_balance_is_negative() {
		BankCustomer kevin = new BankCustomer("Kevin Glick", "Ohio", "2168709302");
		SavingsAccount myAccount = new SavingsAccount(kevin , new DollarAmount(10000), "1989");
		DollarAmount afterWithdraw = myAccount.withdraw(new DollarAmount(9900));
		Assert.assertEquals(new DollarAmount(10000), afterWithdraw);
	}
	@Test
	public void new_balance_matches_current_balance_minus_withdrawn_amount() {
		BankCustomer kevin = new BankCustomer("Kevin Glick", "Ohio", "2168709302");
		SavingsAccount myAccount = new SavingsAccount(kevin , new DollarAmount(20000), "1989");
		DollarAmount afterWithdraw = myAccount.withdraw(new DollarAmount(1000));
		Assert.assertEquals(new DollarAmount(19000), afterWithdraw);
	}
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import banking.project.BankCustomer;
import banking.project.CheckingAccount;
import banking.project.DollarAmount;

public class CheckingAccountTest {
	
	@Test
	public void getPenalty_should_return_penalty_dollarAmount() {
		BankCustomer kevin = new BankCustomer("Kevin", "Ohio", "2168709302");
		CheckingAccount myAccount = new CheckingAccount(kevin, new DollarAmount(50000), "1989");
		DollarAmount penalty = myAccount.getPenalty();
		Assert.assertEquals(new DollarAmount(1000), penalty);
	}
	@Test
	public void getOverDraftLimit_should_return_overdraft_in_dollarAmount() {
		BankCustomer kevin = new BankCustomer("Kevin", "Ohio", "2168709302");
		CheckingAccount myAccount = new CheckingAccount(kevin, new DollarAmount(50000), "1989");
		DollarAmount overDraftLimit = myAccount.getOverDraftLimit();
		Assert.assertEquals(new DollarAmount(-10000), overDraftLimit);
	}
	@Test
	public void newBalance_equals_old_balance_minus_withdraw_amount() {
		BankCustomer kevin = new BankCustomer("Kevin", "Ohio", "2168709302");
		CheckingAccount myAccount = new CheckingAccount(kevin, new DollarAmount(50000), "1989");
		DollarAmount newBalance = myAccount.withdraw(new DollarAmount(10000));
		Assert.assertEquals(new DollarAmount(40000), newBalance);
	}
	@Test
	public void newBalance_equals_old_balance_minus_withdraw_and_minus_penalty_of_ten_dollars() {
		BankCustomer kevin = new BankCustomer("Kevin", "Ohio", "2168709302");
		CheckingAccount myAccount = new CheckingAccount(kevin, new DollarAmount(50000), "1989");
		CheckingAccount myOtherAccount = new CheckingAccount(kevin, new DollarAmount(50000), "1315");
		DollarAmount newBalanceEqualsOverDraft = myAccount.withdraw(new DollarAmount(59000));
		DollarAmount newBalanceGreaterThanOverDraft = myOtherAccount.withdraw(new DollarAmount(55000));
		Assert.assertEquals(new DollarAmount(-10000), newBalanceEqualsOverDraft);
		Assert.assertEquals(new DollarAmount(-6000), newBalanceGreaterThanOverDraft);
	}

}

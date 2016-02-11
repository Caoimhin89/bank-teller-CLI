
public class CheckingAccount extends BankAccount{
	private final long overDraftFeeInCents = -1000;
	private final DollarAmount overDraftLimit = new DollarAmount(-10000);
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(BankCustomer customer, DollarAmount balance) {
		super(customer, balance);
	}
	
	public long getOverDraftFeeInCents() {
		return this.overDraftFeeInCents;
	}
	
	public DollarAmount getOverDraftLimit() {
		return this.overDraftLimit;
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		DollarAmount penalty = new DollarAmount(this.getOverDraftFeeInCents());
		DollarAmount newBalance = this.balance.minus(amountToWithdraw);
		if(this.balance.minus(amountToWithdraw).getTotalAmountInCents() >= 0) {
			this.balance = newBalance;
			return this.balance;
		} else if(!this.balance.minus(amountToWithdraw).isLessThan(this.getOverDraftLimit())) {
			this.balance = newBalance;
			this.balance = this.balance.plus(penalty);
			return this.balance;
		}
		return this.balance;
		
	}

}

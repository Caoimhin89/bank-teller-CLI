
public class CheckingAccount extends BankAccount{
	private final long overDraftFeeInCents = -1000;
	private final DollarAmount overDraftLimit = new DollarAmount(-10000);
	
	public CheckingAccount() {
		this.accountHolderName = "John Doe";
		this.accountNumber = "0";
		this.balance = new DollarAmount(0);
	}
	
	public CheckingAccount(String name, String accountNum, DollarAmount balance) {
		super(name, accountNum, balance);
	}
	
	public long getOverDraftFeeInCents() {
		return this.overDraftFeeInCents;
	}
	
	public DollarAmount getOverDraftLimit() {
		return this.overDraftLimit;
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		DollarAmount penalty = new DollarAmount(this.getOverDraftFeeInCents());
		
		if(this.balance.minus(amountToWithdraw).getTotalAmountInCents() >= 0) {
			DollarAmount newBalance = this.balance.minus(amountToWithdraw);
			this.balance = newBalance;
			return this.balance;
		} else if(!this.balance.minus(amountToWithdraw).isLessThan(this.getOverDraftLimit())) {
			this.balance = this.balance.plus(penalty);
			return this.balance;
		}
		return this.balance;
		
	}

}


public class CheckingAccount extends BankAccount{
	private DollarAmount penalty = new DollarAmount(1000);
	private final DollarAmount overDraftLimit = new DollarAmount(-10000);
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(BankCustomer customer, DollarAmount balance) {
		super(customer, balance);
	}
	
	public DollarAmount getPenalty() {
		return this.penalty;
	}
	
	public DollarAmount getOverDraftLimit() {
		return this.overDraftLimit;
	}
	
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		DollarAmount newBalance = this.getBalance().minus(amountToWithdraw);
		DollarAmount penalized = this.getBalance().minus(amountToWithdraw.plus(this.getPenalty()));
		
		if(!newBalance.isNegative()) {
			this.setBalance(newBalance);
			
		} else if(newBalance.isNegative() && (penalized.isGreaterThan(this.getOverDraftLimit())) || penalized.equals(this.getOverDraftLimit())) {
			this.setBalance(penalized);
		}
		return this.getBalance();
		
	}

}

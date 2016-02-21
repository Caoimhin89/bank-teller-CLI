package banking.project;

public class SavingsAccount extends BankAccount {
	private final DollarAmount serChargeInDollars = new DollarAmount(200);
	
	public SavingsAccount(){
		super();
	}
	public SavingsAccount(BankCustomer customer, DollarAmount balance, String pin){
		super(customer, balance, pin);
	}

	
	public DollarAmount getSerChargeInDollars() {
		return serChargeInDollars;
	}
	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		DollarAmount currentBalance = this.getBalance();
		DollarAmount withDrawn = this.getBalance().minus(amountToWithdraw);
		DollarAmount penalized = withDrawn.minus(serChargeInDollars);
		
		if((!withDrawn.isNegative()) && !penalized.isNegative() && (currentBalance.isLessThan(new DollarAmount(15000)))) {
			this.setBalance(penalized);
			this.getCustomer().setSum();
			this.getCustomer().setCashInHand(this.getCustomer().getCashInHand().plus(amountToWithdraw));
		} else if(!withDrawn.isNegative() && !penalized.isNegative()) {
			this.setBalance(withDrawn);
			this.getCustomer().setSum();
			this.getCustomer().setCashInHand(this.getCustomer().getCashInHand().plus(amountToWithdraw));
		}
		return this.getBalance();
	}
}

public class SavingsAccount extends BankAccount {
	private final DollarAmount serChargeInDollars = new DollarAmount(200);
	
	public SavingsAccount(){
		super();
	}
	public SavingsAccount(BankCustomer customer, DollarAmount balance){
		super(customer, balance);
	}

	@Override
	public DollarAmount withdraw(DollarAmount amountToWithdraw) {
		DollarAmount currentBalance = this.getBalance();
		this.balance = this.getBalance().minus(amountToWithdraw);
		if(this.getBalance().getTotalAmountInCents() >= 0 && this.getBalance().getTotalAmountInCents() < 15000){
			this.balance = this.getBalance().minus(serChargeInDollars);
		} else if(this.balance.getTotalAmountInCents() < 0) {
			this.balance = currentBalance;
		}
		return balance;
	}
}

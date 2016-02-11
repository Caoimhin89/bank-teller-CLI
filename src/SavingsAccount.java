
public class SavingsAccount extends BankAccount {
	private final DollarAmount serChargeInDollars = new DollarAmount(200);
	
	public SavingsAccount(){
		this.accountHolderName = "John Doe";
		this.accountNumber = "0";
		this.balance = new DollarAmount(0);
	}
	public SavingsAccount(String name, String accountNum, DollarAmount balance){
		super(name, accountNum, balance);
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

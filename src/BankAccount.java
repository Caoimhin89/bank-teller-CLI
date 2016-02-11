

public abstract class BankAccount {
	protected String accountHolderName;
	protected String accountNumber;
	protected DollarAmount balance;
	
	public BankAccount() {
		this.accountHolderName = "John Doe";
		this.accountNumber = "0";
		this.balance = new DollarAmount(0);
	}
	
	public BankAccount(String name, String accountNum, DollarAmount balance) {
		this.accountHolderName = name;
		this.accountNumber = accountNum;
		this.balance = balance;
	}
	
	public DollarAmount deposit(DollarAmount amountToDeposit) {
		DollarAmount newBalance = this.balance.plus(amountToDeposit);
		this.balance = newBalance;
		return this.balance;
	}
	
	public DollarAmount getBalance() {
		return this.balance;
	}
	
	public void transfer(BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount newBalance = this.balance.minus(transferAmount);
		this.balance = newBalance;
		DollarAmount newBalance2 = destinationAccount.balance.plus(transferAmount);
		destinationAccount.balance = newBalance2;
	}
	
	public abstract DollarAmount withdraw(DollarAmount amountToWithdraw);
}

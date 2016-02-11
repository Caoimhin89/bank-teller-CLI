

public abstract class BankAccount {
	protected String accountHolderName;
	protected BankCustomer customer;
	protected DollarAmount balance;
	
	public BankAccount() {
		this.customer = new BankCustomer("John Doe", "Unknown", "Unknown");
		this.accountHolderName = customer.getName();
		this.balance = new DollarAmount(0);
	}
	
	public BankAccount(BankCustomer customer, DollarAmount balance) {
		this.customer = customer;
		this.accountHolderName = customer.getName();
		this.balance = balance;
		this.updateClient();
	}
	
	public DollarAmount deposit(DollarAmount amountToDeposit) {
		DollarAmount newBalance = this.balance.plus(amountToDeposit);
		this.balance = newBalance;
		this.getClient().setSum(this.getClient().getSum().plus(amountToDeposit));
		return this.balance;
	}
	
	public DollarAmount getBalance() {
		return this.balance;
	}
	
	public BankCustomer getClient() {
		return this.customer;
	}
	
	public void transfer(BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount newBalance = this.balance.minus(transferAmount);
		this.balance = newBalance;
		DollarAmount newBalance2 = destinationAccount.balance.plus(transferAmount);
		destinationAccount.balance = newBalance2;
		this.getClient().setSum(this.getClient().getSum().minus(transferAmount));
	}
	
	public void updateClient() {
		this.getClient().setSum(this.getClient().getSum().plus(this.getBalance()));
	}
	
	public abstract DollarAmount withdraw(DollarAmount amountToWithdraw);
}


public abstract class BankAccount {
	private String accountHolderName;
	private BankCustomer customer;
	private DollarAmount balance;

	public BankAccount() {
		this.customer = new BankCustomer("John Doe", "Unknown", "Unknown");
		this.accountHolderName = customer.getName();
		this.balance = new DollarAmount(0);
	}

	public BankAccount(BankCustomer customer, DollarAmount balance) {
		this.customer = customer;
		this.accountHolderName = customer.getName();
		this.balance = balance;
		this.getCustomer().getBankAccounts().add(this);
	}

	public DollarAmount deposit(DollarAmount amountToDeposit) {
		DollarAmount newBalance = this.balance.plus(amountToDeposit);
		this.balance = newBalance;
		this.getCustomer().setCashInHand(this.getCustomer().getCashInHand().minus(amountToDeposit));
		return this.balance;
	}

	public DollarAmount getBalance() {
		return this.balance;
	}

	public void setBalance(DollarAmount balance) {
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public BankCustomer getCustomer() {
		return customer;
	}

	public BankCustomer getClient() {
		return this.customer;
	}

	public void transfer(BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount newBalance = this.balance.minus(transferAmount);
		this.balance = newBalance;
		DollarAmount newBalance2 = destinationAccount.balance.plus(transferAmount);
		destinationAccount.balance = newBalance2;
	}

	public abstract DollarAmount withdraw(DollarAmount amountToWithdraw);
}

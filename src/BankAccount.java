
public abstract class BankAccount {
	private String accountHolderName;
	private String accountNumber;
	private BankCustomer customer;
	private DollarAmount balance;
	private String pin;

	public BankAccount() {
		this.customer = new BankCustomer("John Doe", "Unknown", "Unknown");
		this.accountHolderName = customer.getName();
		this.balance = new DollarAmount(0);
	}

	public BankAccount(BankCustomer customer, DollarAmount balance, String pin) {
		this.customer = customer;
		this.accountHolderName = customer.getName();
		this.balance = balance;
		this.getCustomer().getBankAccounts().add(this);
		this.pin = pin;
		this.getCustomer().setSum();
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public String getPin() {
		return this.pin;
	}

	public DollarAmount deposit(DollarAmount amountToDeposit) {
		DollarAmount newBalance = this.balance.plus(amountToDeposit);
		this.balance = newBalance;
		this.getCustomer().setSum();
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

	public void transfer(BankAccount destinationAccount, DollarAmount transferAmount) {
		DollarAmount currentBalance = this.getBalance();
		if(!this.withdraw(transferAmount).equals(currentBalance)) {                  // Apparently code that executes within an if-statement is not
//			this.withdraw(transferAmount);											// as hypothetical as originally thought. The withdraw within the
			this.getCustomer().setSum();											// if-statement actually executes and has an effect on the rest of
																					// the program. The withdraw is really made.
			destinationAccount.deposit(transferAmount);
			destinationAccount.getCustomer().setSum();
		}
	}

	public abstract DollarAmount withdraw(DollarAmount amountToWithdraw);
}

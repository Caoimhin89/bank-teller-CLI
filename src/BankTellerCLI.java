import com.techelevator.util.Terminal;

public class BankTellerCLI {
	private Bank theBank;

	public BankTellerCLI() {
		theBank = new Bank();
	}

	public static void main(String[] args) {
		BankTellerCLI application = new BankTellerCLI();
		application.run();

	}
	boolean continueSession = true;
	public void run() {
		while (continueSession) {
			String choice = getChoiceFromMainMenu();
			if (choice.equals("0")) {
				String account = getUserInput("your pin number");
				System.out.println(checkBalance(account));	
			} else if(choice.equals("1")) {
				addCustomer();
			} else if(choice.equals("2")) {
				String phone = getUserInput("phone number");
				addAccount(theBank.getClient(phone));
			} else if(choice.equals("3")) {
				System.out.println("Please choose an account: ");
				String account = getUserInput("your pin");
				String deposit = getUserInput("amount to deposit");
				makeDeposit(theBank.getAccount(account), new DollarAmount(Long.parseLong(deposit, 10)));
			} else if(choice.equals("4")){
				System.out.println("Please choose an account: ");
				String account = getUserInput("your pin");
				String withdraw = getUserInput("amount to withdraw");
				makeWithdraw(theBank.getAccount(account), new DollarAmount(Long.parseLong(withdraw, 10)));
			} else if(choice.equals("5")) {
				System.out.println("Please choose an account: ");
				String sender = getUserInput("your pin");
				String recipient = getUserInput("recipient's pin");
				String transfer = getUserInput("amount to transfer");
				performTransfer(theBank.getAccount(sender), theBank.getAccount(recipient), new DollarAmount(Long.parseLong(transfer, 10)));
			}
			if (choice.equals("6")) {
				exit();
			}
		}
	}

	private String getChoiceFromMainMenu() {
		System.out.println("\n####### MAIN MENU ########\n");

		System.out.println("Please choose from the following options:\n");

		System.out.println("0) Check Account Balance/n"
				+"1) Add Customer\n"
				+"2) Add Account\n"
				+"3) Deposit\n"
				+"4) Withdraw\n"
				+"5) Transfer\n"
				+"6) Exit");

		return getUserInput("number");
	}

	public void exit() {
		System.out.println("\n***Exiting... Have a nice day.***");
		System.exit(0);
		this.continueSession = false;
	}
	
	private String getUserInput(String prompt) {
		System.out.println("Enter " + prompt+ " >>> ");
		return Terminal.readLine();
	}

	public void addCustomer() {
		System.out.println("\n########## ADD CUSTOMER ##########\n");
		String name = getUserInput("name");
		String address = getUserInput("address");
		String phoneNumber = getUserInput("phone number");
		
		BankCustomer newClient = new BankCustomer(name, address, phoneNumber);
		theBank.addClient(newClient);
		System.out.println("\n***" + newClient.getName() + " added as a customer ***");
	}
	public void addAccount(BankCustomer newClient){
		System.out.println("\n########## ADD ACCOUNT ##########\n");
		System.out.println("1) Checking Account\n" + "2) Savings Account");
		String accountType= getUserInput("account type").toLowerCase();
		if( accountType.equals("1")) {
			String pin = getUserInput("a new 4-digit pin");
			CheckingAccount newChecking = new CheckingAccount(newClient, new DollarAmount(0), pin);
			theBank.addAccount(newChecking);
		} else if(accountType.equals("2")) {
			String pin = getUserInput("a new 4-digit pin");
			SavingsAccount newSavings = new SavingsAccount(newClient, new DollarAmount(0), pin);
			theBank.addAccount(newSavings);
		} else {
			System.out.println("Invalid account type. Please enter either '1' for checking or '2' for savings\n");
			addAccount(newClient);
		}
	}
	
	public void makeDeposit(BankAccount chosenAccount, DollarAmount amountToDeposit) {
		chosenAccount.setBalance(chosenAccount.getBalance().plus(amountToDeposit));
	}
	
	public void makeWithdraw(BankAccount chosenAccount, DollarAmount amountToWithdraw){
		chosenAccount.setBalance(chosenAccount.getBalance().minus(amountToWithdraw));
	}
	
	public void performTransfer(BankAccount sender, BankAccount recipient, DollarAmount amountToTransfer) {
		sender.setBalance(sender.getBalance().minus(amountToTransfer));
		recipient.setBalance(recipient.getBalance().minus(amountToTransfer));
	}
	
	public String checkBalance(String pin) {
		return theBank.getAccount(pin).toString();
	}
	

}

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
			if (choice.equals("1")) {
				addCustomer();
			}
			if (choice.equals("6")) {
				exit();
			}
		}
	}

	private String getChoiceFromMainMenu() {
		System.out.println("\n####### MAIN MENU ########\n");

		System.out.println("Please choose from the following options:\n");

		System.out.println("1) Add Customer\n"
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
	public void addAccount(BankCustomer newClient, long startingAmount){
		System.out.println("\n########## ADD ACCOUNT ##########\n");
		String accountType= getUserInput("account type").toLowerCase();
		if( accountType == "checking"){
			CheckingAccount newAccount = new CheckingAccount(newClient, new DollarAmount(startingAmount));
		} else if(accountType == "savings") {
			SavingsAccount newAccount = new SavingsAccount(newClient, new DollarAmount(startingAmount));
		} else {
			System.out.println("Invalid account type. Please enter either 'checking' or 'savings'\n");
			addAccount(newClient, startingAmount);
		}
	}
	public void makeDeposit(BankAccount chosenAccount, DollarAmount amountToDeposit) {
		chosenAccount.setBalance(chosenAccount.getBalance().plus(amountToDeposit));
	}
	public void makeWithdraw(BankAccount chosenAccount, DollarAmount amountToWithdraw){
		chosenAccount.setBalance(chosenAccount.getBalance().minus(amountToWithdraw));
	}
	

}
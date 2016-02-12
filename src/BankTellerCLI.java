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
	
	

}

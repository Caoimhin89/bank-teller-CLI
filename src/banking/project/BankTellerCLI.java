package banking.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;

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
				checkBalance();
			} else if (choice.equals("1")) {
				addCustomer();
			} else if (choice.equals("2")) {
				addAccount();
			} else if (choice.equals("3")) {
				try { makeDeposit();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (choice.equals("4")) {
				try { makeWithdraw();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (choice.equals("5")) {
				try {
					performTransfer();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (choice.equals("6")) {
				try {
					exportData();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (choice.equals("7")) {
					try {
						importData();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
			} else if (choice.equals("8")) {
				System.out.println("Exiting session...");
				exit();
			}
		}
	}

	private String getChoiceFromMainMenu() {
		System.out.println("\n####### MAIN MENU ########\n");

		System.out.println("Please choose from the following options:\n");

		System.out.println("0) Check Account Balance\n" 
						+ "1) Add Customer\n"
						+ "2) Add Account\n"
						+ "3) Deposit\n"
						+ "4) Withdraw\n"
						+ "5) Transfer\n"
						+ "6) Export\n"
						+ "7) Import\n"
						+ "8) Exit\n");

		return getUserInput("number");
	}

	public void exit() {
		System.out.println("\n***Exiting... Have a nice day.***");
		System.exit(0);
		this.continueSession = false;
	}

	private String getUserInput(String prompt) {
		System.out.println("Enter " + prompt + " >>> ");
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

	public void addAccount() {
		String phone = getUserInput("phone number");
		BankCustomer newClient = theBank.getClient(phone);
		System.out.println("\n########## ADD ACCOUNT ##########\n");
		System.out.println("1) Checking Account\n" + "2) Savings Account");
		String accountType = getUserInput("account type");
		if (accountType.equals("1")) {
			accountType = "checking";
			createAccount(newClient, accountType);
		} else if (accountType.equals("2")) {
			accountType = "savings";
			createAccount(newClient, accountType);
		} else {
			System.out.println("Invalid account type. Please enter either '1' for checking or '2' for savings\n");
		}
	}

	private void createAccount(BankCustomer newClient, String accountType) {
		BankAccount newAccount = null;
		String pin = getUserInput("a new 4-digit pin");
		if(accountType.equals("checking")) {
			newAccount = new CheckingAccount(newClient, new DollarAmount(0), pin);
		} else if(accountType.equals("savings")) {
		newAccount = new SavingsAccount(newClient, new DollarAmount(0), pin);
		}
		System.out.println("You have created a new " + accountType + " account.\n Your security pin is " + pin
				+ " and your account number is " + newAccount.getAccountNumber());
		theBank.addAccount(newAccount);
	}

	public void makeDeposit() throws Exception {
		System.out.println("Please choose an account: ");
		BankAccount chosenAccount = theBank.getAccount(getUserInput("your pin"));
		String[] depositString = getUserInput("amount to deposit in dollars and cents, separated by a period.\n EX: 500.00").split(Pattern.quote("."));
		DollarAmount amountToDeposit = new DollarAmount(Long.parseLong(depositString[0])*100 + Long.parseLong(depositString[1]));
		
		if (amountToDeposit.isLessThan(new DollarAmount(0))) {
				Exception e = new Exception("Cannot deposit negative sum. Please enter valid amount to deposit.");
				throw e;
		}
		chosenAccount.deposit(amountToDeposit);
	}

	public void makeWithdraw() throws Exception {
		System.out.println("Please choose an account: ");
		BankAccount chosenAccount = theBank.getAccount(getUserInput("your pin"));
		System.out.println("You chose to withdraw from: " + chosenAccount);
		String[] withdrawString = getUserInput("amount to withdraw in dollars and cents, separated by a period.\n EX: 500.00").split(Pattern.quote("."));
		DollarAmount amountToWithdraw = new DollarAmount(Long.parseLong(withdrawString[0])*100 + Long.parseLong(withdrawString[1]));
		System.out.println("Amount to withdraw is: " + amountToWithdraw);
		if (amountToWithdraw.isLessThan(new DollarAmount(0))) {
			Exception e = new Exception("Cannot withdraw a negative amount. Please input a valid amount to withdraw.");
			throw e;
		}
		chosenAccount.withdraw(amountToWithdraw);
	}

	public void performTransfer() throws Exception {
		System.out.println("Please choose an account: ");
		BankAccount sender = theBank.getAccount(getUserInput("your pin"));
		BankAccount recipient = theBank.getAccount(getUserInput("recipient's pin"));
		String[] transferString = getUserInput("amount to transfer in dollars and cents, separated by a period.\n EX: 500.00").split(Pattern.quote("."));
		DollarAmount amountToTransfer = new DollarAmount(Long.parseLong(transferString[0])*100 + Long.parseLong(transferString[1]));
			
		if (amountToTransfer.isLessThan(new DollarAmount(0))) {
			Exception e = new Exception("Cannot transfer a negative amount. Please input a valid amount to transfer.");
			throw e;
		}
		sender.withdraw(amountToTransfer);
		recipient.deposit(amountToTransfer);
	}

	public void checkBalance() {
		String account = getUserInput("your pin number");
		System.out.println("Your present balance is: " + theBank.getAccount(account).getBalance().toString());
	}

	public void exportData() throws Exception {
		String filePath = getUserInput("a file directory to which to send the bank data.");
		String fileName = getUserInput("a name for the file, which will store the bank data.");
		File targetFile = new File(filePath, fileName);
		targetFile.createNewFile();
		PrintWriter writer = new PrintWriter(targetFile);
		if(!targetFile.canWrite()) {
			Exception e = new IOException("Sorry, the file you have specified cannot be written to. Please enter a valid file path.");
			throw e;
		}
		for (Map.Entry<String, BankCustomer> client : theBank.getClients().entrySet()) {
			String clientInfo = "C|" + client.getValue().getName() + "|" + client.getValue().getAddress() + "|"
					+ client.getValue().getPhoneNumber();
			System.out.println(clientInfo);
			writer.println(clientInfo);
			for (BankAccount account : client.getValue().getBankAccounts()) {
				if (account instanceof CheckingAccount) {
					String checkingInfo = "A|C|" + account.getAccountNumber() + "|"
							+ account.getBalance().getTotalAmountInCents() + "|" + account.getPin();
					System.out.println(checkingInfo);
					writer.println(checkingInfo);
				} else {
					String savingsInfo = "A|S|" + account.getAccountNumber() + "|"
							+ account.getBalance().getTotalAmountInCents() + "|" + account.getPin();
					System.out.println(savingsInfo);
					writer.println(savingsInfo);
				}
			}
		}
		writer.close();
	}

	public void importData() throws IOException {
		String filePath = getUserInput("the filepath for the source file of the data you would like to import.");
		File sourceFile = new File(filePath);
	 
		FileReader reader = new FileReader(sourceFile);
		BufferedReader br = new BufferedReader(reader);
		String sentence = br.readLine();
		BankCustomer newClient;

		while (sentence != null && sentence.length() > 0) {
			System.out.println(sentence); 
			String [] subStrings = sentence.split("\\|");
			
			if (subStrings[0].equals("C")) {
				newClient = new BankCustomer(subStrings[1], subStrings[2], subStrings[3]);
				theBank.addClient(newClient);
			} else if (subStrings[0].equals("A")) {
				if (subStrings[1].equals("C")) {
					newClient = new BankCustomer(subStrings[1], subStrings[2], subStrings[3]);
					theBank.addAccount(new CheckingAccount(newClient, new DollarAmount(Long.parseLong(subStrings[3])),
							subStrings[2], subStrings[4]));
				} else if (subStrings[1].equals("S")) {
					newClient = new BankCustomer(subStrings[1], subStrings[2], subStrings[3]);
					theBank.addAccount(new SavingsAccount(newClient, new DollarAmount(Long.parseLong(subStrings[3])),
							subStrings[2], subStrings[4]));
				}
			}
			sentence = br.readLine();
		}
		reader.close();
	}

}

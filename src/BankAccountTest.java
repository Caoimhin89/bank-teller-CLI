

public class BankAccountTest {

	public static void main(String[] args) {
		BankCustomer bobby = new BankCustomer("Bob Villa", "123 Sesame Street", "555-555-5555");
		DollarAmount villa = new DollarAmount(50000);
		DollarAmount trans = new DollarAmount(50000);
		DollarAmount withdraw = new DollarAmount(100);
		BankAccount someAccount = new CheckingAccount();
		BankAccount bobAccount1 = new CheckingAccount(bobby, villa, "1234");
		BankAccount bobAccount2 = new SavingsAccount(bobby, trans, "5678");
		BankAccount bobAccount3 = new CheckingAccount(bobby, withdraw, "2468");
		
		System.out.println("Bob Villa's sum should be $950.00 \n"
				+ "Bob's sum is: " + bobby.getSum());
		
		System.out.println();
		
		System.out.println("Bob's current balance is $" + bobAccount1.getBalance().getDollars() + "." + bobAccount1.getBalance().getCents());
		
		bobAccount1.transfer(someAccount, trans);
		System.out.println("John Doe's current balance is $" + someAccount.getBalance().getDollars() + "." + someAccount.getBalance().getCents());
		System.out.println("Bob's new balance is $" + bobAccount1.getBalance().getDollars() + "." + bobAccount1.getBalance().getCents());

		System.out.println();
		
		System.out.println("Bob's new sum should be $750. \n"
				+ "Bob's new sum is: " + bobby.getSum());
		
		System.out.println();
		
		System.out.println("John Doe wants to withdraw $200.00");
		System.out.println("John Doe's current balance is $" + someAccount.getBalance().getDollars() + "." + someAccount.getBalance().getCents());
		someAccount.withdraw(withdraw);
		System.out.println("John Doe's new balance is $" + someAccount.getBalance().getDollars() + "." +someAccount.getBalance().getCents());
	}

}

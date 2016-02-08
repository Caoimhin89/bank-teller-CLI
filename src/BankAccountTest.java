
public class BankAccountTest {

	public static void main(String[] args) {
		DollarAmount villa = new DollarAmount(999555000);
		DollarAmount trans = new DollarAmount(50000);
		BankAccount someAccount = new BankAccount();
		BankAccount ourAccount = new BankAccount("Bob Villa", "000001", villa);
		
		System.out.println("Bob's current balance is $" + ourAccount.getBalance().getDollars() + "." + ourAccount.getBalance().getCents());
		
		ourAccount.transfer(someAccount, trans);
		System.out.println("John Doe's current balance is $" + someAccount.getBalance().getDollars() + "." + someAccount.getBalance().getCents());
		System.out.println("Bob's new balance is $" + ourAccount.getBalance().getDollars() + "." + ourAccount.getBalance().getCents());

		System.out.println();
		
		System.out.println("John Doe wants to deposit $500.00");
		System.out.println("John Doe's current balance is $" + someAccount.getBalance().getDollars() + "." + someAccount.getBalance().getCents());
		someAccount.deposit(trans);
		System.out.println("John Doe's new balance is $" + someAccount.getBalance().getDollars() + "." +someAccount.getBalance().getCents());
	}

}

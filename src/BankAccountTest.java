

public class BankAccountTest {

	public static void main(String[] args) {
		BankCustomer kevin = new BankCustomer("Kevin Glick", "Brunswick, OH", "216-870-9302");
		BankCustomer jack = new BankCustomer("Jack Korinek", "Cleveland, OH", "555-555-5555");
		DollarAmount glick = new DollarAmount(50000);
		DollarAmount korinek = new DollarAmount(50000);
		DollarAmount withdraw = new DollarAmount(25000);
		DollarAmount transfer = new DollarAmount(25000);
		BankAccount kevinChecking = new CheckingAccount(kevin, glick, "1989");
		BankAccount kevinSavings = new SavingsAccount(kevin, glick, "1798");
		BankAccount jackChecking = new SavingsAccount(jack, korinek, "5678");
		BankAccount jackSavings = new CheckingAccount(jack, korinek, "2468");
		
		System.out.println("Kevin Glick's sum should be $1000.00 \n"
				+ "Kevin's sum is : " + kevin.getSum());
		
		System.out.println();
		
		System.out.println("Kevin's current checking account balance is $" + kevinChecking.getBalance().getDollars() + "." + kevinChecking.getBalance().getCents());
		
		kevinChecking.transfer(jackChecking, transfer);
		System.out.println("Jack's current checking account balance is $" + jackChecking.getBalance().getDollars() + "." + jackChecking.getBalance().getCents());
		System.out.println("Kevin's new checking account balance is $" + kevinChecking.getBalance().getDollars() + "." + kevinChecking.getBalance().getCents());

		System.out.println();
		
		System.out.println("Kevin's new sum should be $750. \n"
				+ "Kevin's new sum is: " + kevin.getSum());
		
		System.out.println();
		
		System.out.println("Jack's new sum should be $1250.\n"
				+"Jack's new sum is: " + jack.getSum());
		
		System.out.println();
		
		System.out.println("Kevin Glick wants to withdraw $250.00");
		System.out.println("Kevin's current checking account balance is $" + kevinChecking.getBalance().getDollars() + "." + kevinChecking.getBalance().getCents());
		kevinChecking.withdraw(withdraw);
		System.out.println("Kevin's new balance is $" + kevinChecking.getBalance().getDollars() + "." +kevinChecking.getBalance().getCents());
		
		System.out.println("Kevin wants to transfer an additional $100 to Jack");
		kevinChecking.transfer(jackChecking, new DollarAmount(10000));
		System.out.println("Kevin's new checking balance is: " + kevinChecking.getBalance());
	}

}

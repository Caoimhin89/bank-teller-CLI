import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
	private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public boolean isVIP() {
		if(this.getSum().equals(new DollarAmount(2500000)) || this.getSum().isGreaterThan(new DollarAmount(2500000))) {
			return true;
		}
		return false;
	}

	public DollarAmount getSum() {
		DollarAmount sum = new DollarAmount(0);
		for(BankAccount account : bankAccounts) {
			sum.plus(account.getBalance());
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	
	
}
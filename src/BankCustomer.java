import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	private String name;
	private String address;
	private String phoneNumber;
	private DollarAmount cashInHand;
	private DollarAmount sum;
	private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public BankCustomer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cashInHand = new DollarAmount(0);
	}

	public boolean isVIP() {
		if(this.getSum().equals(new DollarAmount(2500000)) || this.getSum().isGreaterThan(new DollarAmount(2500000))) {
			return true;
		}
		return false;
	}
	
	public DollarAmount getCashInHand() {
		return cashInHand;
	}
	
	public void setCashInHand(DollarAmount cash) {
		this.cashInHand = cash;
	}

	public DollarAmount getSum() {
		return this.sum;
	}
	
	public void setSum() {
		long cents = 0;
		for(BankAccount account : bankAccounts) {
			cents += account.getBalance().getTotalAmountInCents();
		}
		this.sum = new DollarAmount(cents);
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bank {
	private Map<String, BankCustomer> clients;
	private Map<String, BankAccount> accounts;

	public Bank() {
		clients = new HashMap<String, BankCustomer>();
		accounts = new HashMap<String, BankAccount>();
	}

	public void addClient(BankCustomer client) {
		this.clients.put(client.getPhoneNumber(), client);
	}

	public BankCustomer getClient(String key) {
		return clients.get(key);
	}
	public Map<String, BankCustomer> getClients() {
		return this.clients;
	}
	
	public void addAccount(BankAccount accountToAdd) {
		this.accounts.put(accountToAdd.getPin(), accountToAdd);
	}

	public BankAccount getAccount(String pin) {
		return accounts.get(pin);
	}
	
	
}
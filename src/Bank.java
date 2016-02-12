import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<BankCustomer> clients;

	public Bank() {
		clients = new ArrayList<BankCustomer>();
	}

	public void addClient(BankCustomer client) {
	clients.add(client);
	}

	public List<BankCustomer> getClients() {
		return clients;
	}
	
}
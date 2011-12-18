/*
 * 2. Aufgabe: Exception Handling
 *
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
 
import java.util.HashMap;
 
/**
 * Verwaltet mehrere Accounts in einer HashMap.
 */
public class Bank {

	private HashMap<String, Account> accounts;
	
	/**
	 * Erzeugt eine neue Bank, anfangs ohne Accounts.
	 */ 
	public Bank() {
		this.accounts = new HashMap<String, Account>();
	}
	
	/**
	 * Fügt einen Account mit der angegebenen id hinzu.
	 * 
	 * @param accountID Die id des Accounts als String
	 * @param account Der hinzuzufügende Account
	 */
	public void addAccount(String accountID, Account account){
		this.accounts.put(accountID, account);
	}
	
	/**
	 * Löscht den Account mit der angegebenen id.
	 * 
	 * @param accountID Die id des zu löschenden Accounts
	 * @throws AccountIsDeleteProtectedException 
	 * 			Falls der zu löschende Account geschützt ist
	 */
	public void deleteAccount(String accountID) throws AccountIsDeleteProtectedException {
	
		Account account = this.accounts.get(accountID);
	
		if(account.isProtected()) {
			throw new AccountIsDeleteProtectedException();
		}
		
		this.accounts.remove(accountID);
	
	}
	
	/**
	 * Gibt einen String, der alle Account-ids in beliebiger
	 * Reihenfolge beinhaltet, zurück.
	 * 
	 * @return Eine Auflistung der ids der gespeicherten Accounts
	 */
	public String toString() {
		return this.accounts.keySet().toString();
	}

}

/*
 * 2. Aufgabe: Exception Handling
 *
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
public class BankManager {

	public static void main(String[] args) {
	
	Bank bank = new Bank();
	bank.addAccount("12-3", new Account(false));
	bank.addAccount("9-78", new Account(true));
	bank.addAccount("0-55", new Account(false));
	
	/*
	 * Ausgangssituation
	 * 3 Konten enthalten (beliebige Reihenfolge):
	 * 12-3, 9-78, 0-55
	 */
	{
		System.out.println(bank);
	}
	
	/*
	 * Fall 1
	 * Ein bestehendes Konto (12-3) wird gelöscht, es
	 * sind noch 2 Konten enthalten (beliebige Reihenfolge):
	 * 9-78, 0-55
	 */
	{
	
		System.out.println("\nKorrektes Löschen");
		
		try {
			bank.deleteAccount("12-3");
		} catch(Exception e) {
			System.out.println("Account is protected");
		}
		
		System.out.println(bank);
	
	}
	
	/*
	 * Fall 2
	 * Ein schreibgeschütztes Konto soll gelöscht werden,
	 * es tritt korrekterweise eine Exception auf, 
	 * sind weiterhin 2 Konten enthalten (beliebige Reihenfolge):
	 * 9-78, 0-55
	 */
	{
	
		System.out.println("\nKorrektes Fehlschlagen des Löschens");
		
		try {
			bank.deleteAccount("9-78");
		} catch(Exception e) {
			System.out.println("Account is protected");
		}
		
		System.out.println(bank);
	
	}
	
	/*
	 * Fall 3
	 * Ein Konto, das nicht existiert, soll gelöscht werden, es
	 * tritt die Meldung "Account is protected" auf, dies ist jedoch
	 * keine korrekte Fehlerbeschreibung.
	 * Es sind weiterhin 2 Konten enthalten (beliebige Reihenfolge):
	 * 9-78, 0-55
	 */
	{
	
		System.out.println("\nFehlerhaftes Verhalten (das Konto existiert nicht)");
		
		try {
			bank.deleteAccount("0-000-000-1");
		} catch(Exception e) {
			System.out.println("Account is protected");
		}
		
		System.out.println(bank);
		
		}
	
	}
	
}

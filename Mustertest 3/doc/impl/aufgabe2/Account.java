/*
 * 2. Aufgabe: Exception Handling
 *
 * Der Inhalt dieser Datei wird nicht bewertet.
 */

/**
 * Repräsentiert einen Account.
 */
public class Account {

	private boolean isProtected;
	
	/**
	 * Initialisiert einen neuen Account.
	 * 
	 * @param isProtected 
	 * 		boolean ob der Account vor Löschen geschützt ist
	 */
	public Account(boolean isProtected) {
		this.isProtected = isProtected;
	}
	
	/**
	 * Gibt zurück, ob der Account vor Löschen geschützt ist
	 * 
	 * @return true, falls der Account geschützt ist, sonst false
	 */
	public boolean isProtected() {
		return this.isProtected;
	}

}
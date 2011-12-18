/*
 * 2. Aufgabe: Exception Handling
 *
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
 
/**
 * Beschreibt den Fehlerfall, bei dem versucht wird einen 
 * geschützten Account zu löschen.
 */
public class AccountIsDeleteProtectedException extends Exception{

	/**
	 * Default Konstruktor.
	 */
	public AccountIsDeleteProtectedException() {
		super();
	}
	
	/**
	 * Konstruktor mit einer Nachricht.
	 * 
	 * @param message Fehlerbeschreibung als String
	 */
	public AccountIsDeleteProtectedException(String message) {
		super(message);
	}

}
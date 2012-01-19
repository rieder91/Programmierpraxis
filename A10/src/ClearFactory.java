import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class ClearFactory implements Factory {
	/**
	 * Standardkonstruktor
	 */
	public ClearFactory() {	}
	
	/**
	 * Gibt die ClearOperation zum Löschen des Bildes zurück
	 */
	public Operation create(Scanner scanner) {
		return new ClearOperation();
	}
}

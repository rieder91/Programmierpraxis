/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

@SuppressWarnings("serial")
public class OperationException extends Exception {
	/**
	 * Standardkonstruktor
	 */
	public OperationException() {
		super();
	}

	/**
	 * Standardkonstruktor mit einer Nachricht
	 * 
	 * @param message
	 *            Nachricht
	 */
	public OperationException(String message) {
		super(message);
	}
}

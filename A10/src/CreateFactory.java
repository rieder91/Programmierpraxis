import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class CreateFactory implements Factory {

	/**
	 * Standardkosntruktor für die CreateFactory
	 */
	public CreateFactory() {

	}

	/**
	 * Liest die Parameter des Create-Befehls von @param scanner ein und gibt
	 * eine CreateOperation zurück. Im Fehlerfall wird eine FactoryException
	 * geworfen
	 * 
	 * @param scanner
	 *            Scanner von dem gelesen wird
	 * @return Create-Operation mit den eingelesenen Parametern
	 */
	public Operation create(Scanner scanner) throws FactoryException {
		int x, y;
		String charset;

		if (scanner.hasNextInt()) {
			x = scanner.nextInt();
			if (scanner.hasNextInt()) {
				y = scanner.nextInt();
				if (scanner.hasNext()) {
					charset = scanner.next();
				} else {
					throw new FactoryException();
				}
			} else {
				throw new FactoryException();
			}
		} else {
			throw new FactoryException();
		}

		return new CreateOperation(x, y, charset);
	}
}

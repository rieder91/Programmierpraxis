import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class LoadFactory implements Factory {
	/**
	 * Standardkonstruktor
	 */
	public LoadFactory() {
	}

	/**
	 * Liest die Parameter für das laden eines Bildes ein
	 * 
	 * @return Lade-Operation mit den Input-Daten
	 */
	public Operation create(Scanner scanner) throws FactoryException {
		String eof = null;
		String line = null;
		String data = "";

		if (scanner.hasNext()) {
			eof = scanner.next();
			if (scanner.hasNext()) {
				line = scanner.next();
				while (!line.equals(eof)) {
					if (!scanner.hasNext()) {
						throw new FactoryException("invalid input");
					} else {
						data = data + line + '\n';
						line = scanner.next();
					}
				}
			}
		}
		return new LoadOperation(data);
	}
}

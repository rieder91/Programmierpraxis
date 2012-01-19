import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class SearchFactory implements Factory {
	// Bilderspeicher
	private MetricSet<AsciiImage> saved;

	/**
	 * Standardkonstruktor der den Bilderspeicher übergeben bekommt
	 * 
	 * @param saved
	 *            Bilderspeicher
	 */
	public SearchFactory(MetricSet<AsciiImage> saved) {
		this.saved = saved;
	}

	/**
	 * Erzeugt die entsprechenden Operation passend zu den von @param scanner
	 * eingelesenen Werten; bei einer falschen Eingabe wird eine
	 * FactoryException geworfen
	 * 
	 * @param scanner
	 *            Input-Stream
	 * @return erzeugte Operation
	 */
	public Operation create(Scanner scanner) throws FactoryException {
		String command;
		Operation op = null;

		if (scanner.hasNext()) {
			command = scanner.next();
			if (command.equals("pixelcount")) {
				op = new SearchOperation(saved, new PixelCountMetric());
			} else if (command.equals("uniquechars")) {
				op = new SearchOperation(saved, new UniqueCharsMetric());
			} else {
				throw new FactoryException();
			}
		} else {
			throw new FactoryException();
		}

		return op;
	}

}

import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class FilterFactory implements Factory {
	/**
	 * Standardkonstruktor
	 */
	public FilterFactory() {
	}

	/**
	 * liest die Parameter für die Filteroperationen ein und gibt die jeweilige
	 * Operation zurück
	 * 
	 * @return jeweilige Filteroperation (derzeit nur median)
	 */
	public Operation create(Scanner scanner) throws FactoryException {
		// nur 1 Zeile auslesen
		scanner = new Scanner(scanner.nextLine());

		String filter = null;
		String genType = null;
		Operation ret = null;
		BlockGenerator gen = new XBlockGenerator();
		int size = 3;

		if (scanner.hasNext()) {
			filter = scanner.next();

			// Zusätzlicher size-Parameter der Bonusaufgabe
			if (scanner.hasNextInt()) {
				size = scanner.nextInt();
				if ((size % 2) == 0 || size <= 1) {
					throw new FactoryException("invalid size");
				}
			}

			// Zusätzlicher Typ-Parameter der Bonusaufgabe
			if (scanner.hasNext()) {
				genType = scanner.next();
				if (genType.equals("x")) {
					gen = new XBlockGenerator(size);
				} else if (genType.equals("circular")) {
					gen = new CircularBlockGenerator(size);
				} else if (genType.equals("replicate")) {
					gen = new ReplicateBlockGenerator(size);
				} else if (genType.equals("symmetric")) {
					gen = new SymmetricBlockGenerator(size);
				} else {
					throw new FactoryException("wrong parameters");
				}
			}

			if (filter.equals("median")) {
				ret = new MedianOperation(gen);
			} else if (filter.equals("average")) {
				ret = new AverageOperation(gen);
			} else {
				throw new FactoryException("wrong parameters");
			}
		} else {
			throw new FactoryException("wrong parameters");
		}
		return ret;
	}
}

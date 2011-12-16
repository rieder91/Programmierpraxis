import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class ReplaceFactory implements Factory {

	/**
	 * Default constructor creates a new ReplaceFactory.
	 */
	public ReplaceFactory() {
	}

	/**
	 * This method reads the two required parameter for a ReplaceOperation and
	 * creates a new ReplaceOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new ReplaceOperation that is initialized with the read
	 *         parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a
	 *             wrong type
	 */
	public Operation create(Scanner scanner) throws FactoryException {

		char[] params = new char[2];

		for (int i = 0; i < params.length; i++) {
			if (!scanner.hasNext()) {
				throw new FactoryException("Insufficient parameter");
			}
			String s = scanner.next();
			if (s.length() > 1) {
				throw new FactoryException("Insufficient parameter");
			}
			params[i] = s.charAt(0);
		}

		return new ReplaceOperation(params[0], params[1]);

	}

}

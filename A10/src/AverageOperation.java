/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class AverageOperation extends FilterOperation {

	/**
	 * Standardkonstruktor
	 */
	public AverageOperation() {
		super();
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public AverageOperation(int size) {
		super(size);
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param gen
	 *            Generator der angewandt wird
	 */
	public AverageOperation(BlockGenerator gen) {
		super(gen);
	}

	/**
	 * @param values
	 *            Werte von denen der Durchschnitt berechnet wird
	 * @return gerundeter Durchschnitt von @param values
	 */
	public int filter(int[] values) {
		double sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return (int) Math.round(sum / values.length);
	}

}

import java.util.Arrays;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class MedianOperation extends FilterOperation {

	/**
	 * Standardkonstruktor
	 */
	public MedianOperation() {
		super();
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public MedianOperation(int size) {
		super(size);
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param gen
	 *            Generator der verwendet wird
	 */
	public MedianOperation(BlockGenerator gen) {
		super(gen);
	}

	/**
	 * @param values
	 *            Helligkeitsarray
	 * @return Median des Arrays
	 */
	public int filter(int[] values) {
		Arrays.sort(values);
		return values[(values.length) / 2];
	}
}

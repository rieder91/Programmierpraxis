/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public abstract class FilterOperation implements Operation {
	// Generator der verwendet wird
	private BlockGenerator gen;

	/**
	 * Standardkonstruktor Standardmäßig wird ein X-Generator verwendet
	 */
	public FilterOperation() {
		this.gen = new XBlockGenerator();
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public FilterOperation(int size) {
		this.gen = new XBlockGenerator(size);
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param gen
	 *            Generator der verwendet wird
	 */
	public FilterOperation(BlockGenerator gen) {
		this.gen = gen;
	}

	/**
	 * @param img
	 *            AsciiImage auf das die Operation angewandt wird
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException {
		AsciiImage ret = new AsciiImage(img);
		String charset = ret.getCharset();
		int width = ret.getWidth();
		int height = ret.getHeight();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Helligkeitsarray generieren
				int[] area = gen.getBlock(img, j, i);
				// neuen Wert eintragen
				ret.setPixel(j, i, charset.charAt(filter(area)));
			}
		}
		return ret;
	}

	/**
	 * Abstrakte Methode die alle FilterOperationen (derzeit Median und Average)
	 * implementieren
	 * 
	 * @param values
	 *            Int-Array auf den die Operation angewandt wird
	 * @return
	 */
	public abstract int filter(int[] values);
}

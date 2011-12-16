/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class SymmetricBlockGenerator extends BlockGenerator {
	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public SymmetricBlockGenerator(int size) {
		super(size); // me
	}

	/**
	 * Standardkonstruktor
	 */
	public SymmetricBlockGenerator() {
		super();
	}

	/**
	 * Wendet das "Symmetric"-Verfahren an und gibt den neuen Wert des Punktes
	 * x/y zurück
	 * 
	 * @param img
	 *            Ascii-Bild auf das das Verfahren angewendet wird
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @return neuer Wert des Pixel nach dem "Symmetric"-Verfahren
	 */
	public int getPixel(AsciiImage img, int x, int y) {
		String charset = img.getCharset();
		int ret;

		// Gültigkeitsprüfung
		if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
			ret = charset.indexOf(img.getPixel(x, y));
		} else {
			if (x >= img.getWidth()) {
				// durch x - (2 * img.getWidth()), kann ich es gleich behandeln
				// als wenn x < 0 wäre
				x = Math.abs(x - (2 * img.getWidth()) + 1);
			} else if (x < 0) {
				// x < 0
				x = Math.abs(x + 1);
			}
			if (y >= img.getHeight()) {
				// analog zu x
				y = Math.abs(y - (2 * img.getHeight()) + 1);
			} else if (y < 0) {
				// y < 0
				y = Math.abs(y + 1);
			}
			ret = charset.indexOf(img.getPixel(x, y));
		}

		return ret;
	}
}

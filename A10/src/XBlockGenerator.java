/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class XBlockGenerator extends BlockGenerator {
	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public XBlockGenerator(int size) {
		super(size); // me
	}

	/**
	 * Standardkonstruktor
	 */
	public XBlockGenerator() {
		super();
	}

	/**
	 * Wendet das "X"-Verfahren an und gibt den neuen Wert des Punkt x/y zurück
	 * 
	 * @param img
	 *            Ascii-Bild auf das das Verfahren angewendet wird
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @return neuer Wert des Pixel nach dem "X"-Verfahren
	 */
	public int getPixel(AsciiImage img, int x, int y) {
		String charset = img.getCharset();
		int background = charset.length() - 1;
		int ret = background;

		// Gültigkeitsprüfung
		if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
			ret = charset.indexOf(img.getPixel(x, y));
		}

		return ret;
	}
}

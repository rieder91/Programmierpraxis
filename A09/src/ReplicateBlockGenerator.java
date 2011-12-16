/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class ReplicateBlockGenerator extends BlockGenerator {
	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public ReplicateBlockGenerator(int size) {
		super(size); // me
	}

	/**
	 * Standardkonstruktor
	 */
	public ReplicateBlockGenerator() {
		super();
	}

	/**
	 * Wendet das "Circular"-Verfahren an und gibt den neuen Wert des Punktes
	 * x/y zurück
	 * 
	 * @param img
	 *            Ascii-Bild auf das das Verfahren angewendet wird
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @return neuer Wert des Pixel nach dem "Replicate"-Verfahren
	 */
	public int getPixel(AsciiImage img, int x, int y) {
		String charset = img.getCharset();
		int ret = 0;

		// Gültigkeitsprüfung
		if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
			ret = charset.indexOf(img.getPixel(x, y));
		} else {
			if (x < 0) {
				// linkes x
				x = 0;
			} else if (x >= img.getWidth()) {
				// rechts x
				x = img.getWidth() - 1;
			}
			if (y < 0) {
				// y oben
				y = 0;
			} else if (y >= img.getHeight()) {
				// y unten
				y = img.getHeight() - 1;
			}
			ret = charset.indexOf(img.getPixel(x, y));
		}

		return ret;
	}
}

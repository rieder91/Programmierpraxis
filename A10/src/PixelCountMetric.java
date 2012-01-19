/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class PixelCountMetric implements Metric<AsciiImage> {

	/**
	 * Liefert den Absolutbetrag der Differenz der Dimensionen von @param o1 und @param
	 * o2 zurück
	 * 
	 * @param o1
	 *            Bild #1
	 * @param o2
	 *            Bild #2
	 */
	public int distance(AsciiImage o1, AsciiImage o2) {
		int ret = o1.getWidth() * o1.getHeight() - o2.getWidth()
				* o2.getHeight();
		return ret < 0 ? ret * -1 : ret;
	}

}

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public abstract class BlockGenerator {
	// Größe des Feldes
	private int size;

	/**
	 * Standardkonstruktor Standardgröße eines Feldes = 3
	 */
	public BlockGenerator() {
		size = 3;
	}

	/**
	 * Standardkonstruktor
	 * 
	 * @param size
	 *            Größe des Feldes
	 */
	public BlockGenerator(int size) {
		this.size = size;
	}

	/**
	 * Speichert die Helligkeitswerte von allen Koordinaten im Feld in einem
	 * Int-Array
	 * 
	 * @param img
	 *            Ascii-Bild aus dem gelesen wird
	 * @param x
	 *            x-Ausgangskoordinate
	 * @param y
	 *            y-Ausgangskoordinate
	 * @return Array mit allen Helligkeitswerten des Feldes
	 */
	public int[] getBlock(AsciiImage img, int x, int y) {
		int[] ret = new int[size * size];
		int cursor = 0;

		// xScope und yScope gehen alle x- und y-Koordinaten in meinem Bereich
		// durch
		for (int xScope = x - (size / 2); xScope <= x + (size / 2); xScope++) {
			for (int yScope = y - (size / 2); yScope <= y + (size / 2); yScope++) {
				ret[cursor] = getPixel(img, xScope, yScope);
				cursor++;
			}
		}
		return ret;
	}

	// abstrakte Methode die alle Generatoren implementieren
	public abstract int getPixel(AsciiImage img, int x, int y);
}

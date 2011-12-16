/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class AsciiPoint {
	// x und y Koordinate
	private final int x;
	private final int y;

	/**
	 * Konstruktor
	 * 
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 */
	public AsciiPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Liefert die x-Koordinate zurück
	 * 
	 * @return x-Koordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Liefert die y-Koordinate zurück
	 * 
	 * @return y-Koordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * überladene toString-Methode
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

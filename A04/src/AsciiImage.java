/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-25
 * @description Lšsung fŸr das 4. †bungsbeispiel (AsciiShop #3);
 *              AsciiImage-Klasse
 */

public class AsciiImage {
	// Bild
	String image;

	// Breite und Hšhe
	int width, height;

	/**
	 * Default-Konstruktor
	 */
	public AsciiImage() {
		image = "";
		width = 0;
		height = 0;
	}

	/**
	 * FŸgt eine Linie hinzu
	 * 
	 * @param line
	 * @return true, wenn erfolgreich - ansonsten false
	 */
	public boolean addLine(String line) {
		if (image == "" && line.length() > 0) {
			// 1. Zeile die hinzugefŸgt wird
			width = line.length();
			image += line;
			height++;
		} else if (line.length() == width) {
			// alle folgenden Zeilen
			image += line;
			height++;
		} else {
			// ungŸltig
			return false;
		}
		return true;
	}

	/**
	 * @return liefert die Breite zurŸck
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return liefert die Hšhe zurŸck
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Ausgabe mittels Ÿberladener toString-Methode
	 * 
	 * @return Ausgabe des Bildes
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < height; i++) {
			output += image.substring(i * width, ((i + 1) * width)) + '\n';
		}
		return output;
	}

	/**
	 * Liefert die Anzahl der einzigartigen Zeichen im Bild zurŸck
	 * 
	 * @return Anzahl der einzigartigen Zeichen
	 */
	public int getUniqueChars() {
		String unique = "";
		unique += image.charAt(0);
		for (int i = 0; i < image.length(); i++) {
			if (!unique.contains(image.subSequence(i, i + 1))) {
				unique += image.charAt(i);
			}
		}
		return unique.length();
	}

	/**
	 * PrŸft ob das Bild symmetrisch ist
	 * 
	 * @return true falls symmetrisch
	 */
	public boolean isSymmetricH() {
		boolean result = true;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!(getPixel(j, i) == getPixel(width - j - 1, i))) {
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * spiegelt das Bild vertikal
	 */
	public void flipV() {
		String flipped1 = "";
		String flipped2 = "";
		for (int i = 0; i < height; i++) {
			flipped1 += image.substring((height - i - 1) * width,
					((height - i) * width));
			flipped2 = image.substring(i * width, ((i + 1) * width)) + flipped2;
		}
		image = flipped1 + flipped2;
	}

	/**
	 * vertauscht Spalten und Zeilen des Bildes
	 */
	public void transpose() {
		String transposed = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				transposed += getPixel(i, j);
			}
		}
		image = transposed;

		// vertauschen von width und height
		int c = width;
		width = height;
		height = c;
	}

	/**
	 * liefert den Pixel an der Stelle (x, y)
	 * 
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @return character (x, y)
	 */
	private char getPixel(int x, int y) {
		return image.charAt(x + (width * y));
	}

	/**
	 * Setzt den Pixel an der Stelle (x, y)
	 * 
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @param c
	 *            Replacement-Character
	 */
	private void setPixel(int x, int y, char c) {
		image = image.substring(0, x + (width * y)) + c
				+ image.substring(x + (width * y) + 1);
	}

	/**
	 * rekursiver Flood-Fill
	 * 
	 * @param x
	 *            x-Koordinate
	 * @param y
	 *            y-Koordinate
	 * @param c
	 *            Zeichen mit dem ersetzt wird
	 */
	public void fill(int x, int y, char c) {
		int c_old = getPixel(x, y);

		setPixel(x, y, c);

		// nur prŸfen, falls nicht ganz oben
		if (y != 0) {
			if (getPixel(x, y - 1) == c_old) {
				fill(x, y - 1, c);
			}
		}

		// nur prŸfen, falls nicht ganz unten
		if (y != (height - 1)) {
			if (getPixel(x, y + 1) == c_old) {
				fill(x, y + 1, c);
			}
		}

		// nur prŸfen, falls nicht ganz rechts
		if (x != width - 1) {
			if (getPixel(x + 1, y) == c_old) {
				fill(x + 1, y, c);
			}
		}

		// nur prŸfen, falls nicht ganz links
		if (x != 0) {
			if (getPixel(x - 1, y) == c_old) {
				fill(x - 1, y, c);
			}
		}
	}
}
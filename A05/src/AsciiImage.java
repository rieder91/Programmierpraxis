/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-25
 * @description Lösung für das 5. Übungsbeispiel (AsciiShop #4);
 *              AsciiImage-Klasse
 */

public class AsciiImage {
	// Bild
	private char[][] image;

	// Breite und Höhe
	private int width, height;

	/**
	 * Konstruktur falls keine Parameter übergeben werden
	 */
	public AsciiImage() {
		width = 0;
		height = 0;
		image = null;
	}

	/**
	 * Konstruktur mit der Größe des Bildes als Parameter
	 * @param width Breite des Bildes
	 * @param height Höhe des Bildes
	 */
	public AsciiImage(int width, int height) {
		this.width = width;
		this.height = height;
		image = new char[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				image[i][j] = '.';
			}
		}
	}

	/**
	 * Löscht das Bild mit '.'
	 */
	public void clear() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				image[i][j] = '.';
			}
		}
	}

	/**
	 * Zeichnet eine Linie vom Punkt x0/y0 nach x1/y1 mit dem Zeichen @param c
	 * @param x0 x-Koordinate Start-Punkt
	 * @param y0 y-Koordinate Start-Punkt
	 * @param x1 x-Koordinate Ziel-Punkt
	 * @param y1 y-Koordinate Ziel-Punkt
	 * @param c Ersetzungszeichen
	 */
	public void drawLine(int x0, int y0, int x1, int y1, char c) { 
		double d_x, d_y, steigung, x, y;

		// delta x/y
		d_x = x1 - x0;
		d_y = y1 - y0;

		// x/y-Koordinate die in der Schleife verwendet werden
		x = x0;
		y = y0;

		// Ausgangspixel kann immer gesetzt werden
		setPixel(x0, y0, c);

		if(Math.abs(d_y) <= Math.abs(d_x) && d_x >= 0) {
			steigung = d_y / d_x;			
			while(x != x1) {
				x++;
				y += steigung;
				setPixel((int)x, (int)Math.round(y), c);
			}
		} else if(Math.abs(d_y) <= Math.abs(d_x) &&  d_x < 0) {
			// Umdrehen der Linie
			drawLine(x1, y1, x0, y0, c);
		} else if(Math.abs(d_y) > Math.abs(d_x) && d_y >= 0) {
			// Bild drehen, Linie zeichnen, zurückdrehen
			transpose();
			drawLine(y0, x0, y1, x1, c);
			transpose();
		} else if(Math.abs(d_y) > Math.abs(d_x) && d_y < 0) {
			// Bild drehen, umgekehrte Linie zeichnen, zurückdrehen
			transpose();
			drawLine(y1, x1, y0, x0, c);
			transpose();
		}
	}

	/**
	 * Ersetzt alle Vorkommnisse eines Characters durch einen anderen
	 * @param oldChar zu ersetzender Char
	 * @param newChar Char mit dem ersetzt wird
	 */
	public void replace(char oldChar, char newChar) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(image[i][j] == oldChar) {
					image[i][j] = newChar;
				}
			}
		}
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
	 * Ausgabe mittels überladener toString-Methode
	 * 
	 * @return Ausgabe des Bildes
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				output += image[j][i];
			}
			output += '\n';
		}
		return output;
	}


	/**
	 * vertauscht Spalten und Zeilen des Bildes
	 */
	public void transpose() {
		char[][] transposed = new char[height][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				transposed[j][i] = getPixel(i, j);
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
	public char getPixel(int x, int y) {
		return image[x][y];
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
	public void setPixel(int x, int y, char c) {
		image[x][y] = c;
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
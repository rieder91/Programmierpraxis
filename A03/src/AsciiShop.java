import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-04
 * @description Lösung für das 3. Übungsbeispiel (AsciiShop #2)
 */

public class AsciiShop {

	/**
	 * Bekommt ein Bild (als String-Array) als Parameter und füllt beginndend
	 * beim Zeichen(x,y) alle umliegenden, identen Zeichen mit @param c -
	 * arbeitet rekursiv
	 * 
	 * @param image
	 *            String-Array des Bildes
	 * @param x
	 *            x-Koordinate des zu ersetzenden Zeichens
	 * @param y
	 *            y-Koordinate des zu ersetzenden Zeichens
	 * @param c
	 *            Zeichen mit dem ersetzt wird
	 */
	public static void fill(String[] image, int x, int y, char c) {
		int c_old = image[y].charAt(x);

		// Ersetzen des Zeichens
		if (x == 0) {
			// Zeichen ganz links
			image[y] = c + image[y].substring(x + 1);
		} else {
			if ((x - 1) == image[y].length()) {
				// Zeichen ganz rechts
				image[y] = image[y].substring(0, x - 1) + c;
			} else {
				// Zeichen dazwischen
				image[y] = image[y].substring(0, x) + c
				+ image[y].substring(x + 1, image[y].length());
			}
		}

		// nur prüfen, falls nicht ganz oben
		if (y != 0) {
			if (image[y - 1].charAt(x) == c_old) {
				fill(image, x, y - 1, c);
			}
		}

		// nur prüfen, falls nicht ganz unten
		if (y != (image.length - 1)) {
			if (image[y + 1].charAt(x) == c_old) {
				fill(image, x, y + 1, c);
			}
		}

		// nur prüfen, falls nicht ganz rechts
		if (x != image[y].length() - 1) {
			if (image[y].charAt(x + 1) == c_old) {
				fill(image, x + 1, y, c);
			}
		}

		// nur prüfen, falls nicht ganz links
		if (x != 0) {
			if (image[y].charAt(x - 1) == c_old) {
				fill(image, x - 1, y, c);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String Array mit dem Bild
		String[] bild = new String[0];

		// Scanner Initialisierung mit System-Input als Target
		Scanner sc = new Scanner(System.in);

		// Variable in die die Zeilen hineingelesen werden
		String line = "";

		// Anzahl der Zeilen, Länge, maximale Länge, x/y-Koordinate
		int count = 0;
		int length = 0;
		int length_max = 0;
		int x = 0;
		int y = 0;

		// Zeichen mit dem ersetzt wird
		char replacement;

		// Fehler-Fälle
		boolean failure = false;
		boolean failure_2 = false;

		// read Einlesen
		if (sc.hasNext()) {
			line = sc.next();
			// Zeilenanzahl einlesen und ersten String prüfen
			if (sc.hasNextInt() && line.equals("read")) {
				count = sc.nextInt();
				// String Array erneut mit richtiger Size initialisieren
				bild = new String[count];
			} else {
				failure = true;
			}
		} else {
			failure = true;
		}

		for (int i = 0; !failure && i < count; i++) {
			bild[i] = sc.nextLine();
			// Leerzeilen abfangen
			if (!bild[i].equals("")) {
				// Längenbestimmung und Prüfung auf Abweichung
				length = bild[i].length();
				if (length_max != length && length_max != 0) {
					failure = true;
				} else {
					length_max = length;
				}
			} else {
				i--;
			}
		}

		// Einlesen der fill-Befehle - falls/solange kein Fehler
		while (!failure && !failure_2 && sc.hasNext()) {
			line = sc.next();
			// Prüfung ob der String gleich fill ist: falls nein: read-Wert zu
			// klein => failure
			if (line.equals("fill") && sc.hasNextInt()) {
				x = sc.nextInt();
				// x-Wert
				if (sc.hasNextInt()) {
					y = sc.nextInt();
					// y-Wert
					if (sc.hasNext()) {
						// replacement character
						line = sc.next();
						// Char aus dem String ausschneiden falls Länge gleich 1
						// - Scanner hat keine nextChar() Methode
						if (line.length() == 1) {
							replacement = line.charAt(0);
							if (x >= length_max || y >= count) {
								failure_2 = true;
							} else {
								// fill-Methode mit den soeben eingelesen Werten
								// aufrufen
								fill(bild, x, y, replacement);
							}
						} else {
							failure = true;
						}
					} else {
						failure = true;
					}
				} else {
					failure = true;
				}
			} else {
				failure = true;
			}
		}

		// Bild ausgeben, falls kein Fehler
		if (!failure && !failure_2) {
			for (int i = 0; i < count; i++) {
				System.out.println(bild[i]);
			}
			// Breite/Höhe ausgeben
			System.out.println(length_max + " " + count);
		}

		// Ausgaben im Fehlerfall
		if (failure) {
			System.out.println("INPUT MISMATCH");
		}
		if (failure_2) {
			System.out.println("OPERATION FAILED");
		}
	}
}

import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-25
 * @description Lösung für das 4. Übungsbeispiel (AsciiShop #3)
 */

public class AsciiShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AsciiImage bild = new AsciiImage();

		// Scanner Initialisierung mit System-Input als Target
		Scanner sc = new Scanner(System.in);

		// Variable in die die Zeilen hineingelesen werden
		String line = "";

		// Anzahl der Zeilen, Länge, maximale Länge, x/y-Koordinate
		int count = 0;
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
			} else {
				failure = true;
			}
		} else {
			failure = true;
		}

		for (int i = 0; !failure && i < count; i++) {
			if (!bild.addLine(sc.next())) {
				failure = true;
			}
		}

		// Einlesen der Befehle - falls/solange kein Fehler
		while (!failure && !failure_2 && sc.hasNext()) {
			line = sc.next();

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
							if (x >= bild.getWidth() || y >= count) {
								failure_2 = true;
							} else {
								// fill-Methode mit den soeben eingelesen Werten
								// aufrufen
								bild.fill(x, y, replacement);
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

			} else if (line.equals("uniqueChars")) {
				System.out.println(bild.getUniqueChars());

			} else if (line.equals("flip-v")) {
				bild.flipV();

			} else if (line.equals("transpose")) {
				bild.transpose();

			} else if (line.equals("symmetric-h")) {
				System.out.println(bild.isSymmetricH());

			} else {
				failure = true;
			}
		}

		// Bild ausgeben, falls kein Fehler
		if (!failure && !failure_2) {
			System.out.print(bild.toString());
			System.out.println(bild.width + " " + bild.getHeight());
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

import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-03
 * @description Lösung für das 1. Übungsbeispiel (AsciiShop)
 */

public class AsciiShop {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Scanner Initialisierung mit System-Input als Target
		Scanner sc = new Scanner(System.in);

		// Variable in die die Zeilen hineingelesen werden
		String line = "";

		// Höhe, Breite und maximale Breite zur Prüfung ob ein INPUT MISMATCH
		// vorliegt
		int width = 0;
		int widthmax = 0;
		int height = 0;

		// true falls INPUT MISMATCH / Schleifenabbruch
		boolean failure = false;

		while (!failure && sc.hasNextLine()) {
			// Zeile einlesen und width deren Länge zuweisen
			line = sc.nextLine();
			width = line.length();

			// Prüfung ob ein INPUT MISMATCH vorliegt
			if (widthmax != width && widthmax != 0) {
				failure = true;
				System.out.println("INPUT MISMATCH");
			} else {
				widthmax = width;
			}
			// Höhe des Bildes +1
			height++;
		}

		// Ausgabe vom Breite und Höhe, falls kein INPUT MISMATCH
		if (!failure) {
			System.out.println(width + " " + height);
		}
	}
}

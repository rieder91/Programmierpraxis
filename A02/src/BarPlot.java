import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-04
 * @description Lösung für das 2. Übungsbeispiel (BarPlot)
 */

public class BarPlot {
	/**
	 * Wiederholt ein Zeichen @param c @param n mal
	 * 
	 * @param c
	 *            Zeichen das wiederholt wird
	 * @param n
	 *            Anzahl der Wiederholungen
	 * @return Zeichen @parm c @parm n mal wiederholt als String
	 */
	static String repeat(char c, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += c;
		}
		return result;
	}

	/**
	 * Erzeugt ein Label aus @param label; alles länger als @param n Zeichen
	 * wird abgeschnitten; falls @param Label zu kurz ist wird es mit ' ' auf @param
	 * n Zeichen ergänzt
	 * 
	 * @param label
	 *            String aus dem das Label erzeugt wird
	 * @param n
	 *            Anzahl der Stellen die das Label haben soll
	 * @return Generiertes Label als String
	 */
	static String drawLabel(String label, int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			if (i < label.length()) {
				result += label.charAt(i);
			} else {
				result += " ";
			}
		}
		return result;
	}

	/**
	 * Erzeugt ein Balkendiagramm mit dem Label @param label und der absoluten
	 * Länge @param value; '|' dienen als delimiter
	 * 
	 * @param label
	 *            Label des Balkendiagramms
	 * @param value
	 *            Länge des Balkens
	 * @return Balken als String
	 */
	static String drawBar(String label, int value) {
		String result = "";
		result = repeat('#', value) + repeat(' ', 30 - value);
		return drawLabel(label, 8) + "|" + result + "|";
	}

	/**
	 * Erzeugt ein Balkendiagramm mit dem Label @param label und der
	 * prozentuellen Länge @param value; '|' dienen als delimiter. Anhand der
	 * Beispiel-Ausgabedateien sieht man, dass man Runden muss.
	 * 
	 * @param label
	 *            Label des Balkendiagramms
	 * @param value
	 *            Länge des Balken in Prozent
	 * @return Balken als String
	 */
	static String drawBar(String label, double value) {
		String result = "";
		int count = (int) Math.round(30 * value);
		result = repeat('#', count) + repeat(' ', 30 - count);
		return drawLabel(label, 8) + "|" + result + "|";
	}

	/**
	 * Liest die zu zeichnenden Balken aus dem Standard-Input ein und
	 * verarbeitet sie
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialisiert den Scanner mit dem Target System-Input
		Scanner sc = new Scanner(System.in);

		String label = "";
		int bar_i = 0;
		double bar_d = 0;

		// true falls Input-Error
		boolean failure = false;

		// solange kein Input-Error und Stream nicht zu Ende
		while (!failure && sc.hasNext()) {
			label = sc.next();
			// Zahl = Integer
			if (sc.hasNextInt()) {
				bar_i = sc.nextInt();
				// Gültigkeitsprüfung
				if (bar_i <= 30) {
					System.out.println(drawBar(label, bar_i));
				} else {
					System.out.println("INPUT ERROR");
					failure = true;
				}
			} else {
				// Zahl = Double (radix point = . ; US locale)
				if (sc.hasNextDouble()) {
					bar_d = sc.nextDouble();
					// Gültigkeitsprüfung
					if (bar_d <= 1.0) {
						System.out.println(drawBar(label, bar_d));
					} else {
						System.out.println("INPUT ERROR");
						failure = true;
					}
				} else {
					System.out.println("INPUT ERROR");
					failure = true;
				}
			}
		}
	}
}

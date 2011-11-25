import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-11-25
 * @description Lösung für das 5. Übungsbeispiel (AsciiShop #4)
 */

public class AsciiShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AsciiImage bild = new AsciiImage();

		// Scanner Initialisierung mit System-Input als Target
		Scanner sc = new Scanner(System.in);

		String command = null;
		String end = null;

		// Größe des Bildes, x/y-Koordinaten von fill
		int count_x = 0;
		int count_y = 0;
		int x = 0;
		int y = 0;

		// Koordinaten des Line-Befehls
		int line_x0 = 0;
		int line_y0 = 0;
		int line_x1 = 0;
		int line_y1 = 0;

		// Zeichen mit dem ersetzt wird
		char replacement;

		// Fehler-Fälle
		boolean failure = false;
		boolean failure_2 = false;
		boolean failure_3 = false;

		// create Einlesen
		if (sc.hasNext()) {
			command = sc.next();
			if (sc.hasNextInt() && command.equals("create")) {
				count_x = sc.nextInt();
				if (sc.hasNextInt()) {
					count_y = sc.nextInt();
					if(count_y <= 0 || count_x <= 0) {
						failure = true;
					} else {
						bild = new AsciiImage(count_x, count_y);
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

		// Einlesen der Befehle - falls/solange kein Fehler
		while (!failure && !failure_2 && sc.hasNext()) {
			command = sc.next();
			if (command.equals("fill") && sc.hasNextInt()) {
				x = sc.nextInt();
				// x-Wert
				if (sc.hasNextInt()) {
					y = sc.nextInt();
					// y-Wert
					if (sc.hasNext()) {
						// replacement character
						command = sc.next();
						// Char aus dem String ausschneiden falls LŠnge gleich 1
						// - Scanner hat keine nextChar() Methode
						if (command.length() == 1) {
							replacement = command.charAt(0);
							if (x >= bild.getWidth() || y >= bild.getHeight()) {
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
			} else if (command.equals("print")) {
				System.out.println(bild.toString());
			} else if (command.equals("transpose")) {
				bild.transpose();
			} else if (command.equals("clear")) {
				bild.clear();
			} else if (command.equals("replace")) {
				if (sc.hasNext()) {
					command = sc.next();
					if (command.length() == 1) {
						replacement = command.charAt(0);
						if (sc.hasNext()) {
							command = sc.next();
							if (command.length() == 1) {
								bild.replace(replacement, command.charAt(0));
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
			} else if (command.equals("line")) {
				if (sc.hasNextInt()) {
					line_x0 = sc.nextInt();
					if (sc.hasNextInt()) {
						line_y0 = sc.nextInt();
						if (sc.hasNextInt()) {
							line_x1 = sc.nextInt();
							if (sc.hasNextInt()) {
								line_y1 = sc.nextInt();
								if (sc.hasNext()) {
									command = sc.next();
									if (command.length() == 1) {
										bild.drawLine(line_x0, line_y0,
												line_x1, line_y1,
												command.charAt(0));
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
					} else {
						failure = true;
					}
				} else {
					failure = true;
				}
			} else if (command.equals("create")) {
				failure_3 = true;
			} else if (command.equals("load")) {
				if (sc.hasNext()) {
					end = sc.next();
					if (sc.hasNext()) {
						command = sc.next();
						// einlesen bis EOF-Line kommt oder Fehler
						for (int i = 0; !command.equals(end) && !failure; i++) {
							if (command.length() < bild.getWidth()
									|| !sc.hasNext()) {
								// wenn die Zeilenlänge falsch ist oder der Stream zu Ende ohne EOF-Wort
								failure = true;
							} else {
								for (int j = 0; j < bild.getWidth() && !failure; j++) {
									// einzelnen Zeichen zum Bild hinzufügen
									bild.setPixel(j, i, command.charAt(j));
								}
								command = sc.next();
							}
						}
					} else {
						failure = true;
					}
				} else {
					failure = true;
				}
			} else {
				failure_3 = true;
			}
		}

		// Ausgaben im Fehlerfall
		if (failure) {
			System.out.println("INPUT MISMATCH");
		}
		if (failure_2) {
			System.out.println("OPERATION FAILED");
		}
		if (failure_3) {
			System.out.println("UNKNOWN COMMAND");
		}
	}
}

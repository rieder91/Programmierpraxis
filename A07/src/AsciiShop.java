import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description Lösung für das 7. Übungsbeispiel
 */

public class AsciiShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Bild
		AsciiImage bild = null;

		// undo-Stack
		AsciiStack stack = new AsciiStack();

		// Scanner Initialisierung mit System-Input als Target
		Scanner sc = new Scanner(System.in);

		String command = null;
		String end = null;
		String charset = null;
		String load_data = "";

		// Größe des Bildes, x/y-Koordinaten von fill
		int count_x = 0;
		int count_y = 0;

		// Zeichen mit dem ersetzt wird
		char replacement;

		// Fehler-Fälle
		boolean failure = false;
		boolean failure_2 = false;
		boolean failure_3 = false;
		
		Operation op = null;

		// create Einlesen
		if (sc.hasNext()) {
			command = sc.next();
			if (sc.hasNextInt() && command.equals("create")) {
				count_x = sc.nextInt();
				if (sc.hasNextInt()) {
					count_y = sc.nextInt();
					if(sc.hasNext()) {
						charset = sc.next();
						bild = new AsciiImage(count_x, count_y, charset);
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

		// Einlesen der Befehle - falls/solange kein Fehler
		while (!failure && !failure_2 && sc.hasNext()) {
			command = sc.next();
			if (command.equals("print")) {
				System.out.print(bild.toString());
			} else if (command.equals("clear")) {
				stack.push(new AsciiImage(bild));
				op = new ClearOperation();
				try {
					bild = op.execute(bild);
				} catch (OperationException e) {
					failure_2 = true;
				}
			} else if (command.equals("replace")) {
				if (sc.hasNext()) {
					command = sc.next();
					if (command.length() == 1) {
						replacement = command.charAt(0);
						if (sc.hasNext()) {
							command = sc.next();
							if (command.length() == 1) {
								stack.push(new AsciiImage(bild));
								op = new ReplaceOperation(replacement, command.charAt(0));
								try {
									bild = op.execute(bild);
								} catch (OperationException e) {
									failure_2 = true;
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
						stack.push(new AsciiImage(bild));
						for (int i = 0; !command.equals(end) && !failure; i++) {
							if (command.length() < bild.getWidth() || !sc.hasNext()) {
								// wenn die Zeilenlänge falsch ist oder der
								// Stream zu Ende ohne EOF-Wort
								failure = true;
							} else {
								load_data = load_data + command + '\n';
								command = sc.next();
							}
						}
						op = new LoadOperation(load_data);
						try {
							bild = op.execute(bild);
						} catch (OperationException e) {
							failure_2 = true;
						}
					} else {
						failure = true;
					}
				} else {
					failure = true;
				}
			} else if (command.equals("undo")) {
				if (stack.size() == 0) {
					System.out.println("STACK EMPTY");
				} else {
					bild = new AsciiImage(stack.pop());
				}
			} else if (command.equals("filter")) {
				if(sc.hasNext()) {
					command = sc.next();
					if(command.equals("median")) {
						op = new MedianOperation();
						try {
							bild = op.execute(bild);
						} catch (OperationException e) {
							failure_2 = true;
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

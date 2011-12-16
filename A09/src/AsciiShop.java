import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
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
		String charset = null;

		// Größe des Bildes
		int count_x = 0;
		int count_y = 0;

		// Fehler-Fälle
		boolean failure = false;
		boolean failure_2 = false;
		boolean failure_3 = false;

		Operation op = null;

		HashMap<String, Factory> commands = new HashMap<String, Factory>();
		commands.put("clear", new ClearFactory());
		commands.put("binary", new BinaryFactory());
		commands.put("filter", new FilterFactory());
		commands.put("load", new LoadFactory());
		commands.put("replace", new ReplaceFactory());

		// create Einlesen
		if (sc.hasNext()) {
			command = sc.next();
			if (sc.hasNextInt() && command.equals("create")) {
				count_x = sc.nextInt();
				if (sc.hasNextInt()) {
					count_y = sc.nextInt();
					if (sc.hasNext()) {
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
			if (commands.containsKey(command)) {
				try {
					op = commands.get(command).create(sc);
					stack.push(new AsciiImage(bild));
					bild = op.execute(bild);
				} catch (FactoryException e) {
					failure = true;
				} catch (OperationException e) {
					failure_2 = true;
				}
			} else if (command.equals("print")) {
				System.out.println(bild.toString());
			} else if (command.equals("undo")) {
				if (stack.size() == 0) {
					System.out.println("STACK EMPTY");
				} else {
					bild = new AsciiImage(stack.pop());
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

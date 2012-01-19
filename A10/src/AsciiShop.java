import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
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

		// Speicher
		MetricSet<AsciiImage> storage = new MetricSet<AsciiImage>();

		String command = null;

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
		commands.put("create", new CreateFactory());
		commands.put("save", new SaveFactory(storage));
		commands.put("search", new SearchFactory(storage));

		// 1. Befehl muss create sein
		if (sc.hasNext()) {
			command = sc.next();
			if (command.equals("create")) {
				try {
					op = new CreateFactory().create(sc);
					bild = op.execute(bild);
				} catch (FactoryException e) {
					failure = true;
				} catch (OperationException e) {
					failure_2 = true;
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
			} else if (command.equals("printsaved")) {
				if (storage.size() == 0) {
					System.out.println("NO SAVED IMAGES");
				} else {
					Iterator<AsciiImage> it = storage.iterator();
					while (it.hasNext()) {
						System.out.println(it.next().toString());
					}
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

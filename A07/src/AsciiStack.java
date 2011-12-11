/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description Lösung für das 7. Übungsbeispiel 
 *              
 */

public class AsciiStack {
	private AsciiStackNode head;

	/**
	 * Konstruktur für den stack
	 * 
	 * @param increment
	 *            Größe des Stacks; Schritte in denen der Stack
	 *            vergrößert/verkleinert wird
	 */
	public AsciiStack() {
		this.head = null;
	}


	/**
	 * @return true falls der Stack leer ist
	 */
	public boolean empty() {
		return head == null;
	}

	/**
	 * Entfernt das oberste Element vom Stack
	 * 
	 * @return das oberste Element des Stacks
	 */
	public AsciiImage pop() {
		if(head == null) {
			return null;
		} else {
			AsciiImage ret = head.getImage();
			head = head.getNext();
			return ret;
		}
	}

	/**
	 * Gibt das oberste Element zurück ohne es zu entfernen
	 * 
	 * @return das oberste Element des Stacks
	 */
	public AsciiImage peek() {
		return head == null ? null : head.getImage();
	}

	/**
	 * Fügt dem Stack ein Element hinzu
	 * 
	 * @param img
	 *            Element das dem Stack hinzugefügt wird
	 */
	public void push(AsciiImage img) {
		head = new AsciiStackNode(img, head);
	}

	/**
	 * Liefert die Anzahl der Element im Stack zurück
	 * 
	 * @return Anzahl der Elemente im Stack
	 */
	public int size() {
		return head == null ? 0 : head.size();
	}
}

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class AsciiStackNode {
	private AsciiImage image;
	private AsciiStackNode next;

	/**
	 * Standardkonstruktor
	 * 
	 * @param image
	 *            Bild des Knotens
	 * @param next
	 *            nächster Knoten
	 */
	public AsciiStackNode(AsciiImage image, AsciiStackNode next) {
		this.image = image;
		this.next = next;
	}

	/**
	 * getter für das Bild
	 * 
	 * @return Bild dieses Knotens
	 */
	public AsciiImage getImage() {
		return image;
	}

	/**
	 * getter für den nächsten Knoten
	 * 
	 * @return nächster Knoten
	 */
	public AsciiStackNode getNext() {
		return next;
	}

	/**
	 * Größe der verketteten Liste
	 * 
	 * @return Größe der Liste
	 */
	public int size() {
		if (image == null) {
			return 0;
		} else if (next == null) {
			return 1;
		} else {
			int sum = 0;
			AsciiStackNode count = next;
			while (count.getNext() != null) {
				sum++;
				count = count.getNext();
			}
			return sum + 1;
		}
	}
}

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2012-01-19
 * @description 10. Übungsbeispiel
 * 
 */

public class SaveOperation implements Operation {
	// Bilderspeicher
	private MetricSet<AsciiImage> saved;

	/**
	 * Standardkonstruktor der den Bilderspeicher übergeben bekommt
	 * 
	 * @param saved
	 *            Bilderspeicher
	 */
	public SaveOperation(MetricSet<AsciiImage> saved) {
		this.saved = saved;
	}

	/**
	 * Speichert das Bild @param img ab, falls es noch nicht vorhanden ist
	 * 
	 * @param img
	 *            Bild das gespeichert wird
	 * @return Kopie des gespeicherten Bildes
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException {
		if (!saved.contains(img) && img != null) {
			saved.add(img);
		}
		return new AsciiImage(img);
	}

	/**
	 * Getter für den Bilderspeicher
	 * 
	 * @return Bilderspeicher
	 */
	public MetricSet<AsciiImage> getSaved() {
		return saved;
	}

}

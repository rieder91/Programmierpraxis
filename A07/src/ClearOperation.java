/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description Lösung für das 7. Übungsbeispiel 
 *              
 */

public class ClearOperation implements Operation {
	
	/**
	 * Standardkonstruktor
	 */
	public ClearOperation() { }
	
	/**
	 *  Löscht das gesamte Bild mit der Hintergrundfarbe
	 *  @return gelöschtes Bild
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException {
		char replacement = img.getCharset().charAt(img.getCharset().length() - 1);
		AsciiImage ret = new AsciiImage(img);
		
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				ret.setPixel(i, j, replacement);
			}
		}
		
		return ret;
	}
}

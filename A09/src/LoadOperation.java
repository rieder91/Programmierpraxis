/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-16
 * @description 9. Übungsbeispiel
 * 
 */

public class LoadOperation implements Operation {
	private String data;

	/**
	 * Standardkonstruktor mit den Bilddaten
	 * 
	 * @param data
	 *            Zeilen des Bildes durch \n getrennt
	 */
	public LoadOperation(String data) {
		this.data = data;
	}

	/**
	 * Befüllt das AsciiBild mit den Werten aus data
	 * 
	 * @return befülltes AsciiBild
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException {
		int width = img.getWidth();
		int height = img.getHeight();
		String charset = img.getCharset();
		AsciiImage ret = new AsciiImage(width, height, charset);
		int cursor = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (data.charAt(cursor) == '\n'
						|| charset.indexOf(data.charAt(cursor)) == -1) {
					throw new OperationException("invalid format during load");
				} else {
					ret.setPixel(j, i, data.charAt(cursor));
					cursor++;
				}
			}
			cursor++;
		}
		return ret;
	}
}

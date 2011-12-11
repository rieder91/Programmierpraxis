import java.util.HashMap;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description 8. Übungsbeispiel
 *   
 */


public class Histogram {

	final static String background = ".";
	final static String bars = "#";

	/**
	 * Erstellt ein Histogramm aus dem Bild @param img
	 * @param img Bild von dem das Histogramm erstellt wird
	 * @return Histogramm von @param img
	 */
	public static AsciiImage getHistogram(AsciiImage img) {
		String base_charset = img.getCharset();
		String charset = img.getCharset() + "0123456789";
		String image = "";
		String temp = null;

		double total = img.getWidth() * img.getHeight();
		double max = 0.0, count = 0.0, increment = 0.0, value = 0.0;
		
		// charset für das neues Bild generieren
		if(charset.indexOf(background) == -1) {
			charset += background;
		}
		if(charset.indexOf(bars) == -1) {
			charset += bars;
		}
		for(Integer i = 0; i < 10; i++) {
			if(charset.indexOf(i.toString().charAt(0)) == -1) {
				charset += i.toString().charAt(0);
			}
		}
		
		AsciiImage ret = new AsciiImage(3 + img.getCharset().length(), 16, charset);
		HashMap<Character, Double> percentages = new HashMap<Character, Double>();

		// Prozenten von den einzelnen Zeichen berechnen
		for(int i = 0; i < base_charset.length(); i++) {
			count = (double) img.getPointList(base_charset.charAt(i)).size();
			value = count == 0.0 ? 0.0 : (count / (total/100));
			max = value > max ? value : max;
			percentages.put(base_charset.charAt(i), value);
		}
		
		// Inkrement in dem die Beschriftung verkleinert wird
		increment = max/15; 
		
		for(int i = 0; i < 16; i++) {		
			// alle 2 Zeilen Beschriftung ausgeben
			if(i % 2 == 0) {
				temp = (new Integer((int) Math.round(max))).toString();
				if(temp.length() == 1) {
					image += background + background + temp;
				} else if(temp.length() == 2) {
					image += background + temp;
				} else {
					image += temp;
				}
			} else {
				image += background + background + background;
				// in der letzten Zeile das charset ausgeben
				if(i == 15) {
					image += base_charset;
				}
			}
			// Balken generieren
			for(int j = 0; j < ret.getWidth() - 3 && i != 15; j++) {
				// falls die Prozente größer sind als meine Beschriftung -> bars
				if(percentages.get(base_charset.charAt(j)) > Math.round(max-increment)) {
					image += bars;
				} else {
					image += background;
				}
			}
			max -= increment;
			image += '\n';
		}
		
		Operation op = new LoadOperation(image);
		try {
			ret = op.execute(ret);
		} catch (OperationException e) {
			e.printStackTrace();
		}

		return ret;
	}
}

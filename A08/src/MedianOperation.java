import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description Lösung für das 7. Übungsbeispiel 
 *              
 */

public class MedianOperation implements Operation {
	/**
	 * Standardkonstruktor
	 */
	public MedianOperation() { }
	
	/**
	 * Führt die Median-Operation mit allen Punkten des Bildes durch
	 * @return geglättetes Bild
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException { 
		AsciiImage ret = new AsciiImage(img);
		int width = ret.getWidth();
		int height = ret.getHeight();
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				ret.setPixel(j, i, median(img, j, i));
			}
		}
		return ret;
	}
	
	/**
	 * Berechnung des Median
	 * @param img Quellbild
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 * @return geglätteter Punkt
	 */
	public char median(AsciiImage img, int x, int y) {
		ArrayList<Integer> points = new ArrayList<Integer>();
		String charset = img.getCharset();
		int width = img.getWidth();
		int height = img.getHeight();
		int background = charset.length() - 1;
		
		points.add(charset.indexOf(img.getPixel(x, y)));
		
		if(x != 0) {
			points.add(charset.indexOf(img.getPixel(x-1, y)));
		} else {
			points.add(background);
		}
		if(x != 0 && y != 0) {
			points.add(charset.indexOf(img.getPixel(x-1, y-1)));
		} else {
			points.add(background);
		}
		if(x != 0 && y < height-1) {
			points.add(charset.indexOf(img.getPixel(x-1, y+1)));
		} else {
			points.add(background);
		}
		if(y != 0) {
			points.add(charset.indexOf(img.getPixel(x, y-1)));
		} else {
			points.add(background);
		}
		if(y < height-1) {
			points.add(charset.indexOf(img.getPixel(x, y+1)));
		} else {
			points.add(background);
		}
		if(x < width-1) {
			points.add(charset.indexOf(img.getPixel(x+1, y)));
		} else {
			points.add(background);
		}
		if(x < width-1 && y != 0) {
			points.add(charset.indexOf(img.getPixel(x+1, y-1)));
		} else {
			points.add(background);
		}
		if(x < width-1 && y < height-1) {
			points.add(charset.indexOf(img.getPixel(x+1, y+1)));
		} else {
			points.add(background);
		}
		
		Collections.sort(points);
		return charset.charAt(points.get(4));
	}
}

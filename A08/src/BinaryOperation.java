/**
 * @author Thomas Rieder
 * @matrikelnummer 1125403
 * @date 2011-12-11
 * @description 8. Übungsbeispiel
 *   
 */

public class BinaryOperation implements Operation {
	private char treshhold;
	
	/**
	 * Standardkonstruktor
	 * @param threshold Schwellenwert für den Algorithmus
	 */
	public BinaryOperation(char threshold) { 
		this.treshhold = threshold;
	}
	
	/**
	 * Ersetzt alle Zeichen vor dem Schwellenwert mit dem dunkelsten und alle danach mit dem hellsten "Zeichen"
	 * @return binäres Bild
	 */
	public AsciiImage execute(AsciiImage img) throws OperationException {
		AsciiImage ret = new AsciiImage(img);
		String charset = ret.getCharset();
		Operation op = null;
		
		int limit = charset.indexOf(treshhold);
		
		if(limit == -1) {
			throw new OperationException("invalid treshhold");
		} else {
			for(int i = 0; i < charset.length(); i++) {
				if(i < limit) {
					op = new ReplaceOperation(charset.charAt(i), charset.charAt(0));
					ret = op.execute(ret);
				} else if (i >= limit) {
					op = new ReplaceOperation(charset.charAt(i), charset.charAt(charset.length() - 1));
					ret = op.execute(ret);
				}
			}
		}
		
		return ret;
	}
}

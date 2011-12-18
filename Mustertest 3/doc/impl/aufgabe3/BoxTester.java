/*
 * 3. Aufgabe: Rekursion und Collections
 * 
 * Der Inhalt dieser Datei wird nicht bewertet.
 */
public class BoxTester {
	
	public static void main(String[] args) {
	
		/*
		 * Fall 1
		 * "red" ist die am häufigsten vorkommende Farbe
		 */
		{
			Box whiteBox1 = new Box("white");
			Box redBox1 = new Box("red");
			Box greenBox1 = new Box("green");
			Box redBox2 = new Box("red");
			
			greenBox1.insert(redBox2);
			redBox1.insert(greenBox1);
			whiteBox1.insert(redBox1);
			
			System.out.println(whiteBox1.getMostFrequentColor());
		}
		
	}
	
}
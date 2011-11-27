// FILL IN

/**
 * Diese Klasse repräsentiert ein Lied aus der Musiksammlung. 
 * Ein Song ist der kleinste Bestandteil einer Musiksammlung 
 * und ist charakterisiert durch einen Titel, einen 
 * Interpreten und die Laufzeit in (ganzen) Sekunden. 
 */
public class Song {

	final private String title;
	final private String artist;
	final private int duration;

	/**
	 * Initialisiert diesen Song. artist gibt den Namen 
	 * des Interpreten an, title den Titel des Liedes. 
	 * Die Länge des Liedes wird in ganzen Sekunden 
	 * angegeben (duration). 
	 *
	 *
	 * @param artist Der Name des Interpreten 
	 * @param title Der Titel des Liedes 
	 * @param duration Die Dauer des Liedes in ganzen Sekunden 
	 */
	public Song(String artist, String title, int duration) {
		this.artist = artist;
		this.title = title;
		this.duration = duration;
	}

	/**
	 * Gibt den Namen des Interpreten zurück. 
	 *
	 * @return Name des Interpreten 
	 */
	public String getArtist() {
		return artist; 

	}

	/**
	 * Gibt den Titel des Songs zurück. 
	 *
	 * @return Titel des Songs 
	 */
	public String getTitle() {
		return title; 

	}

	/**
	 * Gibt die Dauer des Songs in ganzen Sekunden zurück. 
	 *
	 * @return Dauer des Songs in ganzen Sekunden 
	 */
	public int getDuration() {
		return duration; 
	}

	/**
	 * Gibt den Namen des Songs, gefolgt von einem Bindestrich 
	 * und dem Namen des Interpreten, gemeinsam mit 
	 * der Dauer des Liedes in Sekunden in Klammern 
	 * zurück. 
	 *  
	 * ERWARTETE FORM DER RÜCKGABE:
	 * Shine On You Crazy Diamond - Pink Floyd (810 sec)
	 *
	 * @return Eine lesbare Repräsentation des Songs 
	 */
	public String toString() {
		return title + " - " + artist + " (" + duration + " sec)"; 

	}

}
import java.util.Scanner;

public class Jukebox {
    
    /**
     * Test-Methode. 
     * 
     * Testen Sie in dieser Methode die Implementierung 
     * Ihres Programmes durch Objekt-Instanzierungen und 
     * Methodenaufrufe. Geben Sie Ausgaben (Rückgaben von 
     * Methoden, etc.) auf System.out aus.
     * 
     * Erstellen Sie zuletzt einen sinnvollen Testfall und 
     * beschreiben Sie kurz in einem Kommentar, wieso Sie 
     * diesen Testfall gewählt haben und was Sie damit 
     * überprüfen. Für einen sinnvollen und gut kommentierten 
     * Testfall können Sie einen zusätzlichen Punkt bekommen, 
     * der einen an einer anderen Stelle verlorenen Punkt 
     * ausgleicht (insgesamt können Sie jedoch nicht mehr 
     * als 25 Punkte erreichen). 
     * 
     * (max. 1 Zusatzpunkt)
     * 
     * Rufen Sie Ihre Anwendung mit 
     * java Jukebox
     * auf, um diese Methode auszuführen. 
     */
    public static void testing() {

	
	
	
	
    }
    
    /**
     * Sammelt verschiedene Testfälle.
     * 
     * Die Methode beinhaltet verschiedene Testfälle, 
     * mit denen Sie die Funktionalität Ihres Programmes
     * testen können.  
     * 
     * Rufen Sie Ihre Anwendung mit 
     * java Jukebox [number]
     * auf, wobei [number] die Nummer des Testfalls angibt.
     * 
     * VERÄNDERN SIE DIESE METHODE NICHT! 
     * 
     * Nutzen Sie für eigene Tests die Methode
     * testing() am Beginn dieser Datei. 
     * 
     * @param testCaseNumber Die Nummer des auszuführenden Testfalls.  
     */
    public static void testCases(int testCaseNumber) {

    	switch (testCaseNumber) {
		case 1:

		    /*
		     * spec.$1
		     * Überprüft die korrekte Implementierung der Song-Klasse
		     * 
		     * ERWARTETER OUTPUT:
		     * Atreyu
		     * Falling Down
		     * 215
		     * Falling Down - Atreyu (215 sec)
		     */

			{
		    	
				Song song1 = new Song("Atreyu", "Falling Down", 215);
				
				System.out.println(song1.getArtist());
				System.out.println(song1.getTitle());
				System.out.println(song1.getDuration());
				System.out.println(song1);
		    
			}

			break;
			
		case 2:

		    /*
		     * spec.$2
		     * Überprüft die korrekte Basisimplementierung der Playlist-Klasse
		     * 
		     * ERWARTETER OUTPUT:
		     * true
		     * false
		     * Falling Down - Atreyu (215 sec)
		     * Song 2 - Blur (126 sec)
		     * My Only One - Amy MacDonald (212 sec)
		     * 553 sec
		     */

			{
		    	
				Song song1 = new Song("Atreyu", "Falling Down", 215);
				Song song2 = new Song("Blur", "Song 2", 126);
				Song song3 = new Song("Amy MacDonald", "My Only One", 212);
				
				Playlist playlist1 = new Playlist();
				playlist1.addSong(song1);
				playlist1.addSong(song2);
				System.out.println(playlist1.addSong(song3));
				System.out.println(playlist1.addSong(song3));
				System.out.println(playlist1);
		    
			}

			break;
			
		case 3:

		    /*
		     * spec.$3
		     * Überprüft die erweiterte Implementierung (Kopie, Zusammenfügung, Extraktion) der Playlist-Klasse
		     * 
		     * ERWARTETER OUTPUT:
		     * Falling Down - Atreyu (215 sec)
		     * My Only One - Amy MacDonald (212 sec)
		     * Shine On You Crazy Diamond - Pink Floyd (810 sec)
		     * 1237 sec
		     * Mixtape - Jamie Cullum (299 sec)
		     * Back To The Ground - Jamie Cullum (277 sec)
		     * 576 sec
		     * 2
		     */

			{
		    	
				Song song1 = new Song("Atreyu", "Falling Down", 215);
				Song song2 = new Song("Amy MacDonald", "My Only One", 212);
				Song song3 = new Song("Pink Floyd", "Shine On You Crazy Diamond", 810);
				Song song4 = new Song("Jamie Cullum", "Mixtape", 299);
				Song song5 = new Song("Annie Stettin", "Beats For You", 245);
				Song song6 = new Song("Jamie Cullum", "Back To The Ground", 277);
				
				Playlist playlist1 = new Playlist();
				playlist1.addSong(song1);
				
				Playlist playlist2 = new Playlist(playlist1);
				playlist2.addSong(song2);
				
				Playlist playlist3 = new Playlist(playlist1, playlist2);
				playlist3.addSong(song3);
				System.out.println(playlist3);
		    
				Playlist playlist4 = new Playlist();
				
				playlist4.addSong(song4);
				playlist4.addSong(song5);
				playlist4.addSong(song6);
				
				Playlist jamieCullum = playlist4.extractPlaylistByArtist("Jamie Cullum");
				System.out.println(jamieCullum);
				System.out.println(playlist4.countSongsByArtist("Jamie Cullum"));
			
			}

			break;

		case 4:

		    /*
		     * spec.$4
		     * Überprüft die korrekte Basisimplementierung der Library-Klasse
		     * 
		     * ERWARTETER OUTPUT:
		     * true
		     * false
		     * true
		     * true
		     */

			{
		    	
				Song song1 = new Song("Atreyu", "Falling Down", 215);
				Song song2 = new Song("Blur", "Song 2", 126);
				Song song3 = new Song("Amy MacDonald", "My Only One", 212);
				Song song4 = new Song("Pink Floyd", "Shine On You Crazy Diamond", 810);
				
				Library library = new Library();
				
				Playlist playlist1 = new Playlist();
				playlist1.addSong(song1);
				playlist1.addSong(song2);
				
				Playlist playlist2 = new Playlist();
				playlist2.addSong(song3);
				playlist2.addSong(song4);
				
				library.addPlaylist("Favourites", playlist1);
				System.out.println(library.getPlaylist("Favourites") == playlist1);
				
				library.addPlaylist("Favourites", playlist2);
				System.out.println(library.getPlaylist("Favourites") == playlist1);
				System.out.println(library.getPlaylist("Favourites") == playlist2);
				
				library.removePlaylist("Favourites");
				System.out.println(library.getPlaylist("Favourites") == null);
			
			}

			break;
			
		case 5:

		    /*
		     * spec.$5
		     * Überprüft die Implementierung der Import-Funktion der Library-Klasse
		     * 
		     * ERWARTETER OUTPUT:
		     * null
		     * My Only One - Amy MacDonald (212 sec)
		     * Shine On You Crazy Diamond - Pink Floyd (810 sec)
		     * 1022 sec
		     * Mixtape - Jamie Cullum (299 sec)
		     * Beats For You - Annie Stettin (245 sec)
		     * 544 sec
		     */

			{
		    	
				Song song1 = new Song("Atreyu", "Falling Down", 215);
				Song song2 = new Song("Blur", "Song 2", 126);
				Song song3 = new Song("Amy MacDonald", "My Only One", 212);
				Song song4 = new Song("Pink Floyd", "Shine On You Crazy Diamond", 810);
				Song song5 = new Song("Jamie Cullum", "Mixtape", 299);
				Song song6 = new Song("Annie Stettin", "Beats For You", 245);
				
				Library library1 = new Library();
				
				Playlist playlist1 = new Playlist();
				playlist1.addSong(song1);
				playlist1.addSong(song2);
				
				Playlist playlist2 = new Playlist();
				playlist2.addSong(song3);
				playlist2.addSong(song4);
				
				Playlist playlist3 = new Playlist();
				playlist3.addSong(song5);
				playlist3.addSong(song6);
				
				library1.addPlaylist("Rock", playlist1);
				library1.addPlaylist("Lieblingslieder", playlist2);
				library1.addPlaylist("Unterwegs", playlist3);
				
				Library library2 = new Library(library1, new String[]{
						"Unterwegs",
						"Lieblingslieder" });
				
				System.out.println(library2.getPlaylist("Rock"));
				System.out.println(library2.getPlaylist("Lieblingslieder"));
				System.out.println(library2.getPlaylist("Unterwegs"));
				
			}

			break;
			
		}

    }
    
    /**
     * Ausführbare Methode des Programms.
     * 
     * Die Methode verarbeitet das übergebene Argument
     * (falls vorhanden) und ruft den entsprechenden 
     * Testfall auf. 
     * 
     * VERÄNDERN SIE DIESE METHODE NICHT! 
     * 
     * Nutzen Sie für eigene Tests die Methode
     * testing() am Beginn dieser Datei. 
     * 
     * @param args Das erste Argument gibt, falls 
     * 		vorhanden, die Nummer des Testfalls 
     * 		an, der aufgerufen werden soll.
     */
    public static void main(String[] args) {

		if (args.length>0) {
			
	    	Scanner argumentParser = new Scanner(args[0].replaceAll("[\\[\\]]",""));
		    if (argumentParser.hasNextInt()) {

				int testCaseNumber=argumentParser.nextInt();
				if (testCaseNumber>=1&&testCaseNumber<=5) {

				    testCases(testCaseNumber);
				    return;

				}

	    	}
	    
		    System.err.println("USAGE:");
		    System.err.println("");
		    System.err.println("java Jukebox");
		    System.err.println("Ruft die Methode testing() auf.");
		    System.err.println("");
		    System.err.println("java Jukebox [number]");
		    System.err.println("Ruft den angegebenen Testfall in testCases() auf.");
		    System.err.println("[number]: Eine Zahl zwischen 1 und 5");

	} else {

	    testing();

	}

    }

}

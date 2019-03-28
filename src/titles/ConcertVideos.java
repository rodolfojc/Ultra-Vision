package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay {

	public ConcertVideos(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre, album, band);
		
	}

	
}

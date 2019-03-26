package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay{

	public ConcertVideos(String title, String album, String band, String yearRelease, String genre) {
		super(title, album, band, yearRelease, genre);
		
	}

	
}

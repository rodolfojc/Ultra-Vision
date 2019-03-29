package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay {

	private boolean dvd;
	private boolean blueray;
	
	public ConcertVideos(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre, album, band);
		
	}

	@Override
	public boolean isBlueRayFormat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDVDformat() {
		// TODO Auto-generated method stub
		return false;
	}

	
}

package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay {

	private boolean dvd;
	private boolean blueray;
	
	public ConcertVideos(String title, String yearRelease, String genre, String album, String band, boolean dvd, boolean blueray) {
		super(title, yearRelease, genre, album, band);
		this.dvd = dvd;
		this.blueray = blueray;
	}

	@Override
	public boolean isBlueRayFormat() {
		return this.blueray;
	}

	@Override
	public boolean isDVDformat() {
		return this.dvd;
	}

	
}

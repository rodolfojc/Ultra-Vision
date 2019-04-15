package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay {

	private final String _TYPE = "BoxSet";
	
	private boolean dvd;
	private boolean blueray;
	
	public ConcertVideos(String title, String yearRelease, String genre, String album, String band, boolean dvd, boolean blueray) {
		super(title, yearRelease, genre, album, band);
		this.dvd = dvd;
		this.blueray = blueray;
	}
	
	@Override
	public String getType() {
		return this._TYPE ;
	}

	@Override
	public boolean isBlueRayFormat() {
		return this.blueray;
	}

	@Override
	public boolean isDVDformat() {
		return this.dvd;
	}

	@Override
	public String toString() {
		return "ConcertVideos [dvd=" + dvd + ", blueray=" + blueray + ", getAlbum()=" + getAlbum() + ", getBand()="
				+ getBand() + ", getTitle()=" + getTitle() + ", getYearRelease()=" + getYearRelease() + ", getGenre()="
				+ getGenre() + "]";
	}

	
	
}

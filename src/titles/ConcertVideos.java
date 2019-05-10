package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends Music implements DVD, BlueRay {

	//ATTRIBUTES
	private final String _TYPE = "ConcertVideo";
	private String dvd;
	private String blueray;
	
	public ConcertVideos(String title, String yearRelease, String genre, String album, String band, String dvd, String blueray) {
		super(title, yearRelease, genre, album, band);
		this.dvd = dvd;
		this.blueray = blueray;
	}
	
	//SUPER CLASS METHODS
	@Override
	public String getType() {
		return this._TYPE ;
	}

	//IMPLEMENTATIONS METHODS
	@Override
	public String isBlueRayFormat() {
		return this.blueray;
	}

	@Override
	public String isDVDformat() {
		return this.dvd;
	}

	//FOR TESTING
	@Override
	public String toString() {
		return "ConcertVideos [dvd=" + dvd + ", blueray=" + blueray + ", getAlbum()=" + getAlbum() + ", getBand()="
				+ getBand() + ", getTitle()=" + getTitle() + ", getYearRelease()=" + getYearRelease() + ", getGenre()="
				+ getGenre() + "]";
	}

	
	
}

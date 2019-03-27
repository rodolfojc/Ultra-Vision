package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class ConcertVideos extends title implements DVD, BlueRay{

	
	private String album;
	private String band;
	
	public ConcertVideos(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre);
		this.album = album;
		this.band = band;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	
}

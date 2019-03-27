package titles;

import titles.interfaces.CD;

public class AudioMusic extends title implements CD{

	private String album;
	private String band;
	
	public AudioMusic(String title, String yearRelease, String genre, String album, String band) {
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

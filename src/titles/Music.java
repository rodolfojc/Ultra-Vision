package titles;

public abstract class Music {

	private String title;
	private String album;
	private String band;
	private String yearRelease;
	private String genre;
	
	public Music(String title, String album, String band, String yearRelease, String genre) {
		this.title = title;
		this.album = album;
		this.band = band;
		this.yearRelease = yearRelease;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String yearRelease) {
		this.yearRelease = yearRelease;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
}

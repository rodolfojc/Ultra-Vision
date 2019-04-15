package titles;

import titles.interfaces.CD;

public class AudioMusic extends Music implements CD {

	private final String _TYPE = "AudioMusic";
	
	public AudioMusic(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre, album, band);
		
	}
	
	@Override
	public String getType() {
		return this._TYPE;
	}

	@Override
	public boolean isCDFormat() {
		return true;
	}

	@Override
	public String toString() {
		return "AudioMusic [getAlbum()=" + getAlbum() + ", getBand()=" + getBand() + ", getTitle()=" + getTitle()
				+ ", getYearRelease()=" + getYearRelease() + ", getGenre()=" + getGenre() + "]";
	}

	

}

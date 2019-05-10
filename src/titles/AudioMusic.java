package titles;

import titles.interfaces.CD;

public class AudioMusic extends Music implements CD {

	//ATTRIBUTE
	private final String _TYPE = "AudioMusic";
	
	//CONSTRUCTOR
	public AudioMusic(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre, album, band);
		
	}
	
	//SUPER CLASS METHODS 
	@Override
	public String getType() {
		return this._TYPE;
	}

	//IMPLEMENTATIONS MATHODS
	@Override
	public boolean isCDFormat() {
		return true;
	}

	//FOR TESTING
	@Override
	public String toString() {
		return "AudioMusic [getAlbum()=" + getAlbum() + ", getBand()=" + getBand() + ", getTitle()=" + getTitle()
				+ ", getYearRelease()=" + getYearRelease() + ", getGenre()=" + getGenre() + "]";
	}

	

}

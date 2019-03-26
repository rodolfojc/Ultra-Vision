package titles;

import titles.interfaces.CD;

public class AudioMusic extends Music implements CD{

	public AudioMusic(String title, String album, String band, String yearRelease, String genre) {
		super(title, album, band, yearRelease, genre);
		
	}

}

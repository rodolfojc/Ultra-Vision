package titles;

import titles.interfaces.CD;

public class AudioMusic extends Music implements CD {

	public AudioMusic(String title, String yearRelease, String genre, String album, String band) {
		super(title, yearRelease, genre, album, band);
		
	}

	@Override
	public boolean isCDFormat() {
		// TODO Auto-generated method stub
		return false;
	}

	

}

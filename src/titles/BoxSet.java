package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class BoxSet extends Tv implements DVD, BlueRay {

	public BoxSet(String title, String yearRelease, String genre, String director, String runningTime, String languages,
			String country) {
		super(title, yearRelease, genre, director, runningTime, languages, country);
		
	}
	
}

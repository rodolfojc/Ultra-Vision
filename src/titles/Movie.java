package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class Movie extends Tv implements DVD, BlueRay {

	
	public Movie(String title, String yearRelease, String genre, String director, String runningTime, String languages,
			String country, boolean blueRay, boolean dvd) {
		super(title, yearRelease, genre, director, runningTime, languages, country, blueRay, dvd);
			this.setBlueRay(blueRay);
			this.setDvd(dvd);
	}

	@Override
	public boolean isBlueRayFormat() {
		return this.isBlueRay();
	}

	@Override
	public boolean isDVDformat() {
		return this.isDvd();
	}

	@Override
	public String toString() {
		return "Movie [getDirector()=" + getDirector() + ", getRunningTime()=" + getRunningTime() + ", getLanguages()="
				+ getLanguages() + ", getCountry()=" + getCountry() + ", isBlueRay()=" + isBlueRay() + ", isDvd()="
				+ isDvd() + ", getTitle()=" + getTitle() + ", getYearRelease()=" + getYearRelease() + ", getGenre()="
				+ getGenre() + "]";
	}

	
}

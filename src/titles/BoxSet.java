package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class BoxSet extends Tv implements DVD, BlueRay {

	private final String _TYPE = "BoxSet";
	
	public BoxSet(String title, String yearRelease, String genre, String director, String runningTime, String languages,
			String country, boolean blueRay, boolean dvd) {
		super(title, yearRelease, genre, director, runningTime, languages, country, blueRay, dvd);
		this.setBlueRay(blueRay);
		this.setDvd(dvd);
	}
	
	

	@Override
	public String getType() {
		return this._TYPE;
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
		return "BoxSet [getDirector()=" + getDirector() + ", getRunningTime()=" + getRunningTime() + ", getLanguages()="
				+ getLanguages() + ", getCountry()=" + getCountry() + ", isBlueRay()=" + isBlueRay() + ", isDvd()="
				+ isDvd() + ", getTitle()=" + getTitle() + ", getYearRelease()=" + getYearRelease() + ", getGenre()="
				+ getGenre() + "]";
	}
	
	
	
}

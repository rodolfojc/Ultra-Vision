package titles;

import titles.interfaces.BlueRay;
import titles.interfaces.DVD;

public class Movie extends title implements DVD, BlueRay {

	private String director;
	private String runningTime;
	private String languages;
	private String country;
	
	public Movie(String title, String yearRelease, String genre, String director, String runningTime, 
			String languages, String country) {
		super(title, yearRelease, genre);
		this.director = director;
		this.runningTime = runningTime;
		this.languages = languages;
		this.country = country;
		
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}

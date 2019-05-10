package titles;

public abstract class Tv extends Title {

	// ATTRIBUTES
	private String director;
	private String runningTime;
	private String languages;
	private String country;
	private String blueRay;
	private String dvd;

	// CONSTRUCTOR
	public Tv(String title, String yearRelease, String genre, String director, String runningTime, String languages,
			String country, String blueRay, String dvd) {
		super(title, yearRelease, genre);
		this.director = director;
		this.runningTime = runningTime;
		this.languages = languages;
		this.country = country;
		this.setBlueRay(blueRay);
		this.setDvd(dvd);
	}

	// GETTER AND SETTERS

	// DIRECTOR NAME
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	// RUNNING TIME
	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	// LANGUAGES
	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	// COUNTRY
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	// BLUERAY
	public String isBlueRay() {
		return this.blueRay;
	}

	public void setBlueRay(String blueRay) {
		this.blueRay = blueRay;
	}

	// DVD
	public String isDvd() {
		return this.dvd;
	}

	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

}

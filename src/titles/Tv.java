package titles;

public abstract class Tv extends Title{

	private String director;
	private String runningTime;
	private String languages;
	private String country;
	private boolean blueRay;
	private boolean dvd;
	
	public Tv(String title, String yearRelease, String genre, String director, String runningTime, 
			String languages, String country, boolean blueRay, boolean dvd) {
		super(title, yearRelease, genre);
		this.director = director;
		this.runningTime = runningTime;
		this.languages = languages;
		this.country = country;
		this.setBlueRay(blueRay);
		this.setDvd(dvd);
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

	public boolean isBlueRay() {
		return blueRay;
	}

	public void setBlueRay(boolean blueRay) {
		this.blueRay = blueRay;
	}

	public boolean isDvd() {
		return dvd;
	}

	public void setDvd(boolean dvd) {
		this.dvd = dvd;
	}
	
	
}

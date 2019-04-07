package titles;

public abstract class Title {

	private String title;
	private String yearRelease;
	private String genre;
	private String id;
	
	public Title(String title, String yearRelease, String genre) {
		this.title = title;
		this.yearRelease = yearRelease;
		this.genre = genre;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String yearRelease) {
		this.yearRelease = yearRelease;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
		
}

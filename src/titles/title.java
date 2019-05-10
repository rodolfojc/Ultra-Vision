package titles;

// SUPER CLASS TITLE
public abstract class Title {

	//ATTRIBUTES
	private String title;
	private String yearRelease;
	private String genre;
	private String id;
	private String type = "Title";
	
	//CONSTRUCTOR
	public Title(String title, String yearRelease, String genre) {
		this.title = title;
		this.yearRelease = yearRelease;
		this.genre = genre;
		
	}
	
	//GETTERS AND SETTERS
	
	//TITLE NAME
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//YEAR OF RELEASE
	public String getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(String yearRelease) {
		this.yearRelease = yearRelease;
	}

	//GENRE
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	//ID
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//TYPE
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
		
}

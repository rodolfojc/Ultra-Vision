package app.model;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import app.database.Database;
import app.view.AddTitleView;
import titles.AudioMusic;
import titles.BoxSet;
import titles.ConcertVideos;
import titles.Movie;
import titles.Title;

public class AddTitleModel {

	private AudioMusic audioMusic;
	private ConcertVideos concertVideos;
	private Movie movie;
	private BoxSet boxSet;
	private AddTitleView addTitleView;
	private Database myDB;
	
	
	public AddTitleModel(Database database, AudioMusic audioMusic, AddTitleView addTitleView) {
		
		this.myDB = database;
		this.audioMusic = audioMusic;
		this.addTitleView = addTitleView;
		
	}
	
	public AddTitleModel(Database database, ConcertVideos concertVideos, AddTitleView addTitleView) {
		
		this.myDB = database;
		this.concertVideos = concertVideos;
		this.addTitleView = addTitleView;
		
	}
	
	public AddTitleModel(Database database, Movie movie, AddTitleView addTitleView) {
		
		this.myDB = database;
		this.movie = movie;
		this.addTitleView = addTitleView;
		
	}
	
	public AddTitleModel(Database database, BoxSet boxSet, AddTitleView addTitleView) {
		
		this.myDB = database;
		this.boxSet = boxSet;
		this.addTitleView = addTitleView;
		
	}


	public void addAudioMusic() {

			// FLAG FOR JOPTIONPANE MESSAGES
			boolean flag = true;
							
		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, album, genre, band, cd)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

				
				// PREPARATION
				PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
				preparedStmt.setString(1, this.audioMusic.getType());
				preparedStmt.setString(2, this.audioMusic.getTitle());
				preparedStmt.setString(3, this.audioMusic.getYearRelease());
				preparedStmt.setString(4, this.audioMusic.getAlbum());
				preparedStmt.setString(5, this.audioMusic.getGenre());
				preparedStmt.setString(6, this.audioMusic.getBand());
				preparedStmt.setString(7, "Yes");
				
				preparedStmt.execute();
				this.myDB.getConn().close();

			} catch (Exception e) {
				// ERROR MESSAGES
				JOptionPane.showMessageDialog(this.addTitleView, "Ups, there is a problem, try again!");
				flag = false;
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}

			// NO ERRORS
			if (flag == true)
				JOptionPane.showMessageDialog(this.addTitleView,
						"The title: "+this.audioMusic.getTitle()+" has been ADDED SUCCESSFUL");
			this.addTitleView.dispose();

		}
	
	public void addVideoMusic() {

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;
						
	try {

		String query = "INSERT INTO titles (type, title_name, year_rel, album, genre, band, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			
			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, this.concertVideos.getType());
			preparedStmt.setString(2, this.concertVideos.getTitle());
			preparedStmt.setString(3, this.concertVideos.getYearRelease());
			preparedStmt.setString(4, this.concertVideos.getAlbum());
			preparedStmt.setString(5, this.concertVideos.getGenre());
			preparedStmt.setString(6, this.concertVideos.getBand());
			preparedStmt.setString(7, this.concertVideos.isDVDformat());
			preparedStmt.setString(8, this.concertVideos.isBlueRayFormat());

			preparedStmt.execute();
			this.myDB.getConn().close();

		} catch (Exception e) {
			// ERROR MESSAGES
			JOptionPane.showMessageDialog(this.addTitleView, "Ups, there is a problem, try again!");
			flag = false;
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		// NO ERRORS
		if (flag == true)
			JOptionPane.showMessageDialog(this.addTitleView,
					"The Title: "+this.concertVideos.getTitle()+" has been ADDED SUCCESSFUL");
		this.addTitleView.dispose();

	}
	
	public void addMovieTv() {

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;
						
		try {

		String query = "INSERT INTO titles (type, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			
			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, this.movie.getType());
			preparedStmt.setString(2, this.movie.getTitle());
			preparedStmt.setString(3, this.movie.getYearRelease());
			preparedStmt.setString(4, this.movie.getGenre());
			preparedStmt.setString(5, this.movie.getDirector());
			preparedStmt.setString(6, this.movie.getRunningTime());
			preparedStmt.setString(7, this.movie.getLanguages());
			preparedStmt.setString(8, this.movie.getCountry());
			preparedStmt.setString(9, this.movie.isDVDformat());
			preparedStmt.setString(10, this.movie.isBlueRayFormat());
			
			preparedStmt.execute();
			this.myDB.getConn().close();

		} catch (Exception e) {
			// ERROR MESSAGES
			JOptionPane.showMessageDialog(this.addTitleView, "Ups, there is a problem, try again!");
			flag = false;
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		// NO ERRORS
		if (flag == true)
			JOptionPane.showMessageDialog(this.addTitleView,
					"The title: "+this.movie.getTitle()+" has been ADDED SUCCESSFUL");
		this.addTitleView.dispose();

	}
	
	public void addBoxTv() {

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;
						
		try {

		String query = "INSERT INTO titles (type, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			
			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, this.boxSet.getType());
			preparedStmt.setString(2, this.boxSet.getTitle());
			preparedStmt.setString(3, this.boxSet.getYearRelease());
			preparedStmt.setString(4, this.boxSet.getGenre());
			preparedStmt.setString(5, this.boxSet.getDirector());
			preparedStmt.setString(6, this.boxSet.getRunningTime());
			preparedStmt.setString(7, this.boxSet.getLanguages());
			preparedStmt.setString(8, this.boxSet.getCountry());
			preparedStmt.setString(9, this.boxSet.isDVDformat());
			preparedStmt.setString(10, this.boxSet.isBlueRayFormat());
			
			preparedStmt.execute();
			this.myDB.getConn().close();

		} catch (Exception e) {
			// ERROR MESSAGES
			JOptionPane.showMessageDialog(this.addTitleView, "Ups, there is a problem, try again!");
			flag = false;
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		// NO ERRORS
		if (flag == true)
			JOptionPane.showMessageDialog(this.addTitleView,
					"The title: "+this.boxSet.getTitle()+" has been ADDED SUCCESSFUL");
		this.addTitleView.dispose();

	}
	
	
	
	
}

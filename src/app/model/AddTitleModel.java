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

	// ATTRIBUTES
	private AddTitleView addTitleView;
	private Database myDB;
	private Title myTitle;

	// CONSTRUCTORS
	public AddTitleModel(Database database, Title tempTitle, AddTitleView addTitleView) {

		this.myDB = database;
		this.myTitle = tempTitle;
		this.addTitleView = addTitleView;

	}

	// ADD MUSIC TYPE METHOD
	public void addAudioMusic() {

		AudioMusic myTemp = (AudioMusic) this.myTitle;

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;

		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, album, genre, band, cd)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, myTemp.getType());
			preparedStmt.setString(2, myTemp.getTitle());
			preparedStmt.setString(3, myTemp.getYearRelease());
			preparedStmt.setString(4, myTemp.getAlbum());
			preparedStmt.setString(5, myTemp.getGenre());
			preparedStmt.setString(6, myTemp.getBand());
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
					"The title: " + myTemp.getTitle() + " has been ADDED SUCCESSFUL");

	}

	// ADD VIDEO TYPE METHOD
	public void addVideoMusic() {

		ConcertVideos myTemp = (ConcertVideos) this.myTitle;

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;

		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, album, genre, band, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, myTemp.getType());
			preparedStmt.setString(2, myTemp.getTitle());
			preparedStmt.setString(3, myTemp.getYearRelease());
			preparedStmt.setString(4, myTemp.getAlbum());
			preparedStmt.setString(5, myTemp.getGenre());
			preparedStmt.setString(6, myTemp.getBand());
			preparedStmt.setString(7, myTemp.isDVDformat());
			preparedStmt.setString(8, myTemp.isBlueRayFormat());

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
					"The Title: " + myTemp.getTitle() + " has been ADDED SUCCESSFUL");

	}

	// ADD MOVIE TYPE METHOD
	public void addMovieTv() {

		Movie myTemp = (Movie) this.myTitle;
		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;

		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, myTemp.getType());
			preparedStmt.setString(2, myTemp.getTitle());
			preparedStmt.setString(3, myTemp.getYearRelease());
			preparedStmt.setString(4, myTemp.getGenre());
			preparedStmt.setString(5, myTemp.getDirector());
			preparedStmt.setString(6, myTemp.getRunningTime());
			preparedStmt.setString(7, myTemp.getLanguages());
			preparedStmt.setString(8, myTemp.getCountry());
			preparedStmt.setString(9, myTemp.isDVDformat());
			preparedStmt.setString(10, myTemp.isBlueRayFormat());

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
					"The title: " + myTemp.getTitle() + " has been ADDED SUCCESSFUL");

	}
	
	// ADD BOXSET TYPE METHOD
	public void addBoxTv() {

		BoxSet myTemp = (BoxSet) this.myTitle;
		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;

		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, myTemp.getType());
			preparedStmt.setString(2, myTemp.getTitle());
			preparedStmt.setString(3, myTemp.getYearRelease());
			preparedStmt.setString(4, myTemp.getGenre());
			preparedStmt.setString(5, myTemp.getDirector());
			preparedStmt.setString(6, myTemp.getRunningTime());
			preparedStmt.setString(7, myTemp.getLanguages());
			preparedStmt.setString(8, myTemp.getCountry());
			preparedStmt.setString(9, myTemp.isDVDformat());
			preparedStmt.setString(10, myTemp.isBlueRayFormat());

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
					"The title: " + myTemp.getTitle() + " has been ADDED SUCCESSFUL");

	}

}

package app.model;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import app.database.Database;
import app.view.AddTitleView;
import titles.AudioMusic;
import titles.Title;

public class AddTitleModel {

	private Database myDB;
	private AudioMusic audioMusic;
	private AddTitleView addTitleView;
	
	
	public AddTitleModel(Database database, AudioMusic audioMusic, AddTitleView addTitleView) {
		
		this.myDB = database;
		this.audioMusic = audioMusic;
		this.addTitleView = addTitleView;
		
	}


	public void addAudioMusic() {

			// FLAG FOR JOPTIONPANE MESSAGES
			boolean flag = true;
							
		try {

			String query = "INSERT INTO titles (type, title_name, year_rel, album, genre, band)"
						+ "VALUES (?, ?, ?, ?, ?, ?)";

				
				// PREPARATION
				PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
				preparedStmt.setString(1, this.audioMusic.getType());
				preparedStmt.setString(2, this.audioMusic.getTitle());
				preparedStmt.setString(3, this.audioMusic.getYearRelease());
				preparedStmt.setString(4, this.audioMusic.getAlbum());
				preparedStmt.setString(5, this.audioMusic.getGenre());
				preparedStmt.setString(6, this.audioMusic.getBand());

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
						"The Title: "+this.audioMusic.getTitle()+" has been ADDED SUCCESSFUL");
			this.addTitleView.dispose();

		}
	
	
	
	
	
	
	
}

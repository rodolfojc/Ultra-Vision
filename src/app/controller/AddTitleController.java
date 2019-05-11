package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.database.Database;
import app.model.AddTitleModel;
import app.view.AddTitleView;
import app.view.MainView;
import titles.AudioMusic;
import titles.BoxSet;
import titles.ConcertVideos;
import titles.Movie;
import titles.Title;

public class AddTitleController implements ActionListener{

	private AddTitleView addTitleView;
	private AddTitleModel addTitleModel;
	private MainView mainView;
	private Database database;
	
	// IT MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
	private String regexGeneral = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
	//YEARS FROM 1900 TO 2099
	private String regexYears = "^(19|20)\\d{2}$";
	
	
	
	public AddTitleController(AddTitleView addTitleView, MainView mainView) {
		
		this.addTitleView = addTitleView;
		this.mainView = mainView;
	}
	
	public boolean musicValidation() {
		
		//VALIDATION FLAG
		boolean valFlag = true;
		
		
					
		//TITLE NAME
		if (!this.addTitleView.getMusicTitleName().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The title name is not correct or it is empty, " + "try again",
					"Title name Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		//BAND
		else if (!this.addTitleView.getMusicBand().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The band is not correct or it is empty, " + "try again",
					"Band Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		//ALBUM
		else if (!this.addTitleView.getMusicAlbum().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The album is not correct or it is empty, " + "try again",
					"Album Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		//YEAR
		else if (!this.addTitleView.getMusicYearRelease().getText().matches(regexYears)) {
					
			JOptionPane.showMessageDialog(this.addTitleView, "The year is not correct or it is empty, " + "try again",
			"Year Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
					
				}	
		//GENRE
		else if (!this.addTitleView.getMusicGenre().getText().matches(regexGeneral)) {
				
			JOptionPane.showMessageDialog(this.addTitleView, "The genre is not correct or it is empty, " + "try again",
			"Genre Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
					
		}else {
			
			return valFlag;
		
		}
		
		return valFlag;
	}
	
	public boolean tvValidation() {
	
		boolean valFlag = true;
		
		//TITLE NAME
		if (!this.addTitleView.getTvTitleName().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The title name is not correct or it is empty, " + "try again",
					"Title name Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		//YEAR
		else if (!this.addTitleView.getTvYearRelease().getText().matches(regexYears)) {
							
			JOptionPane.showMessageDialog(this.addTitleView, "The year is not correct or it is empty, " + "try again",
			"Year Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
							
				}
		
		//GENRE
		else if (!this.addTitleView.getTvGenre().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The genre is not correct or it is empty, " + "try again",
					"Genre Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		//DIRECTOR
		else if (!this.addTitleView.getTvDirector().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The director name is not correct or it is empty, " + "try again",
					"Director name Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		//RUNNING TIME
		else if (!this.addTitleView.getTvRunningTime().getText().toLowerCase().contains("min")) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The running time must contains 'min', it is not correct or it is empty, " + "try again",
					"Running time name Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
				
		//COUNTRY
		else if (!this.addTitleView.getCountry().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The country is not correct or it is empty, " + "try again",
			"Year Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
					
		}
		
		//LANGUAGE
		else if (!this.addTitleView.getLanguage().getText().matches(regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addTitleView, "The language is not correct or it is empty, " + "try again",
			"Year Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
					
		} else {
		
			return valFlag;
			
		}
		
		return valFlag;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Music")) {
			
			//VALIDATION
			if (this.musicValidation()) {
						
			
			if(addTitleView.getMusicType().equals("MusicCD")) {
				Title tempAudio = new AudioMusic(this.addTitleView.getMusicTitleName().getText(),
														this.addTitleView.getMusicYearRelease().getText(),
														this.addTitleView.getMusicGenre().getText(),
														this.addTitleView.getMusicAlbum().getText(),
														this.addTitleView.getMusicBand().getText());
				
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempAudio, this.addTitleView);
				this.addTitleModel.addAudioMusic();
				this.addTitleView.dispose();
				this.mainView.setVisible(true);
			}else {
				Title tempVideo = new ConcertVideos(this.addTitleView.getMusicTitleName().getText(),
															this.addTitleView.getMusicYearRelease().getText(),
															this.addTitleView.getMusicGenre().getText(),
															this.addTitleView.getMusicAlbum().getText(),
															this.addTitleView.getMusicBand().getText(),
															this.addTitleView.getIsDVDMusic(),
															this.addTitleView.getIsBlueMusic());
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempVideo, this.addTitleView);
				this.addTitleModel.addVideoMusic();
				this.addTitleView.dispose();
				this.mainView.setVisible(true);
			}
		  }
		}
		
		if(e.getActionCommand().equals("Add Tv")) {
			
			
			if(this.tvValidation()) {
			
			
			
			if(addTitleView.getTvType().equals("Movie")) {
				
				Title tempMovie = new Movie(this.addTitleView.getTvTitleName().getText(), 
											this.addTitleView.getTvYearRelease().getText(), 
											this.addTitleView.getTvGenre().getText(), 
											this.addTitleView.getTvDirector().getText(), 
											this.addTitleView.getTvRunningTime().getText(), 
											this.addTitleView.getLanguage().getText(), 
											this.addTitleView.getCountry().getText(), 
											this.addTitleView.getIsBlueTv(), 
											this.addTitleView.getIsDVDTv());
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempMovie, this.addTitleView);
				this.addTitleModel.addMovieTv();
				this.addTitleView.dispose();
				this.mainView.setVisible(true);
			
			}else {
				
				Title tempBox = new BoxSet(this.addTitleView.getTvTitleName().getText(), 
						this.addTitleView.getTvYearRelease().getText(), 
						this.addTitleView.getTvGenre().getText(), 
						this.addTitleView.getTvDirector().getText(), 
						this.addTitleView.getTvRunningTime().getText(), 
						this.addTitleView.getLanguage().getText(), 
						this.addTitleView.getCountry().getText(), 
						this.addTitleView.getIsBlueTv(), 
						this.addTitleView.getIsDVDTv());
				
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempBox, this.addTitleView);
				this.addTitleModel.addBoxTv();
				this.addTitleView.dispose();
				this.mainView.setVisible(true);
				
				
			}
				
		  }
			
		}
		
		if(e.getActionCommand().equals("Go back")) {
			
			this.addTitleView.dispose();
			this.mainView.setVisible(true);
			
		}
		
		
		
	}

	

}

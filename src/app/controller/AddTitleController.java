package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.AddTitleModel;
import app.view.AddTitleView;
import titles.AudioMusic;
import titles.ConcertVideos;
import titles.Movie;
import titles.Title;

public class AddTitleController implements ActionListener{

	private AddTitleView addTitleView;
	private AddTitleModel addTitleModel;
	private Database database;
	//private Title title;
	
	
	public AddTitleController(AddTitleView addTitleView) {
		this.addTitleView = addTitleView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Music")) {
			
			if(addTitleView.getMusicType().equals("MusicCD")) {
				AudioMusic tempAudio = new AudioMusic(this.addTitleView.getMusicTitleName().getText(),
														this.addTitleView.getMusicYearRelease().getText(),
														this.addTitleView.getMusicGenre().getText(),
														this.addTitleView.getMusicAlbum().getText(),
														this.addTitleView.getMusicBand().getText());
				
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempAudio, this.addTitleView);
				this.addTitleModel.addAudioMusic();
			}else {
				ConcertVideos tempVideo = new ConcertVideos(this.addTitleView.getMusicTitleName().getText(),
															this.addTitleView.getMusicYearRelease().getText(),
															this.addTitleView.getMusicGenre().getText(),
															this.addTitleView.getMusicAlbum().getText(),
															this.addTitleView.getMusicBand().getText(),
															this.addTitleView.getIsDVDMusic(),
															this.addTitleView.getIsBlueMusic());
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, tempVideo, this.addTitleView);
				this.addTitleModel.addVideoMusic();
			}
			
		}
		
		if(e.getActionCommand().equals("Add Tv")) {
			
			if(addTitleView.getTvType().equals("Movie")) {
				
				Movie tempMovie = new Movie(this.addTitleView.getTvTitleName().getText(), 
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
			}
				
			
			
		}
		
		
		
	}

	

}

package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.AddTitleModel;
import app.view.AddTitleView;
import titles.AudioMusic;
import titles.Title;

public class AddTitleController implements ActionListener{

	private AddTitleView addTitleView;
	private AddTitleModel addTitleModel;
	private Database database;
	private Title title;
	
	
	public AddTitleController(AddTitleView addTitleView) {
		this.addTitleView = addTitleView;
	}
	
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Music")) {
			
			if(addTitleView.getMusicType().getSelectedIndex() == 0) {
				this.setTitle(new AudioMusic(this.addTitleView.getMusicTitleName().getText(),
											this.addTitleView.getMusicYearRelease().getText(),
											this.addTitleView.getMusicGenre().getText(),
											this.addTitleView.getMusicAlbum().getText(),
											this.addTitleView.getMusicBand().getText()));
				
				this.database = new Database();
				this.addTitleModel = new AddTitleModel(this.database, this.title);
			
			}
			
		}
		
	}

	

}

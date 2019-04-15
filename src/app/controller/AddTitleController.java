package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.AddTitleView;
import titles.Title;

public class AddTitleController implements ActionListener{

	AddTitleView addTitleView;
	Title title;
	
	public AddTitleController(AddTitleView addTitleView) {
		this.addTitleView = addTitleView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add Music")) {
			
			if(addTitleView.) {
				
			}
			
		}
		
	}

}

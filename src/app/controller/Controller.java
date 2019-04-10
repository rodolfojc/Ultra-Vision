package app.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;
import app.view.SearchTitleView;


public class Controller implements ActionListener {

	
	public Controller() {
		
		new MainView("Welcome to Ultravision System", 500,600, true, this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search Title")) {
			new SearchTitleView("Search a Title", 500, 800, true, this);
		}
	}
	
}

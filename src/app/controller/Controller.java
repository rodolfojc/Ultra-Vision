package app.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;


public class Controller implements ActionListener {

	
	public Controller() {
		
		new MainView("Welcome to Ultravision System", 500,600, true, this);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
}

package app.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;


public class Controller implements ActionListener {

	MainViewController mainViewControler;
	
	public Controller() {
		
		this.mainViewControler = new MainViewController();
		new MainView("Welcome to Ultravision System", 500,600, true, mainViewControler);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

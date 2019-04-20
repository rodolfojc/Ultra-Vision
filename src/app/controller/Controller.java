package app.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;


public class Controller implements ActionListener {

	private MainViewController mainViewControler;
	
	public Controller() {
		
		//NEW INSTANCE OF MAIN VIEW
		new MainView("Welcome to Ultravision System", 500,700, true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

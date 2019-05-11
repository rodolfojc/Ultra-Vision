package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;

public class Controller implements ActionListener {

	//CONSTRUCTOR
	public Controller() {

		// NEW INSTANCE OF MAIN VIEW
		new MainView("Welcome to Ultravision System", 700, 800, true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

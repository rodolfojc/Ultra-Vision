package app.controller;

import app.view.GuiView;
import app.view.MainView;
import app.view.UserView;

public class Controller {

	
	public Controller() {
		//new UserView();
		new MainView("Welcome to Ultravision System", 500,600, true);
	}
	
}

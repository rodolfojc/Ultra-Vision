package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.AddMemberView;
import app.view.AddTitleView;
import app.view.FindMemberView;
import app.view.MainView;
import app.view.SearchMemberView;
import app.view.SearchTitleView;

public class MainViewController implements ActionListener {

	// ATTRIBUTES
	private MainView mainView;

	// CONSTRUCTOR
	public MainViewController(MainView mainView) {

		this.mainView = mainView;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// MAIN MENU ACTTIONS
		if (e.getActionCommand().equals("Search Title")) {

			new SearchTitleView("Search a Title", 1400, 1000, true, this.mainView);
			this.mainView.setVisible(false);

		}

		if (e.getActionCommand().equals("Search Customer")) {

			new SearchMemberView("Search a Customer", 1400, 1000, true, this.mainView);
			this.mainView.setVisible(false);
		}

		if (e.getActionCommand().equals("Add Title")) {

			new AddTitleView("Add Title Manager", 1400, 1000, true, this.mainView);
			this.mainView.setVisible(false);

		}

		if (e.getActionCommand().equals("Add Member")) {

			new AddMemberView("Add Member Manager", 1200, 750, true, this.mainView);
			this.mainView.setVisible(false);

		}

		if (e.getActionCommand().equals("Menu Members")) {

			new FindMemberView("Find Member Manager", 350, 450, true, this.mainView);
			this.mainView.setVisible(false);

		}

		// EXIT THE PROGRAM
		if (e.getActionCommand().equals("EXIT")) {

			System.exit(1);

		}

	}

}

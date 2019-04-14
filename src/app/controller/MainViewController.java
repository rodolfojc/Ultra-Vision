package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.AddMemberView;
import app.view.AddTitleView;
import app.view.SearchMemberView;
import app.view.SearchTitleView;

public class MainViewController implements ActionListener {

	SearchTitleController  searchTitleController;
	SearchMemberController searchCustomerController;
	AddTitleController addTitleController;
	AddMemberController addMemberController;

	
	public MainViewController() {
		
		this.searchTitleController = new SearchTitleController();
		this.searchCustomerController = new SearchMemberController();
		this.addTitleController = new AddTitleController();
		this.addMemberController = new AddMemberController();
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search Title")) {
			
			new SearchTitleView("Search a Title", 500, 800, true, this.searchTitleController);
		
		}
		
		if (e.getActionCommand().equals("Search Customer")) {
			
			new SearchMemberView("Search a Customer", 500, 800, true, this.searchCustomerController);
		
		}
		

		if (e.getActionCommand().equals("Add Title")) {
			
			new AddTitleView("Add Title Manager", 1200, 750, true, this.addTitleController);
		
		}
		
		if (e.getActionCommand().equals("Add Member")) {
			
			new AddMemberView("Add Member Manager", 1200, 750, true, this.addMemberController);
		
		}

	}

}

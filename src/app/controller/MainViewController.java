package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.AddMemberView;
import app.view.AddTitleView;
import app.view.SearchMemberView;
import app.view.SearchTitleView;

public class MainViewController implements ActionListener {

	private SearchTitleController  searchTitleController;
	private SearchMemberController searchCustomerController;
	private AddTitleController addTitleController;
	private AddMemberController addMemberController;
	private AddTitleView addTitleView;
	private AddMemberView addMemberView;

	
	public MainViewController() {
		
		this.searchTitleController = new SearchTitleController();
		this.searchCustomerController = new SearchMemberController();
		
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
			
			this.addTitleView = new AddTitleView("Add Title Manager", 1200, 750, true);
			
		}
		
		if (e.getActionCommand().equals("Add Member")) {
			
			this.addMemberView = new AddMemberView("Add Member Manager", 1200, 750, true);
		
		}

	}

}

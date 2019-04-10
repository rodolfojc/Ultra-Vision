package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.SearchCustomerView;
import app.view.SearchTitleView;

public class MainViewController implements ActionListener {

	SearchTitleController  searchTitleController;
	SearchCustomerController searchCustomerController;

	
	public MainViewController() {
		
		this.searchTitleController = new SearchTitleController();
		this.searchCustomerController = new SearchCustomerController();
		
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search Title")) {
			
			new SearchTitleView("Search a Title", 500, 800, true, searchTitleController);
		
		}
		
		if (e.getActionCommand().equals("Search Title")) {
			
			new SearchCustomerView("Search a Customer", 500, 800, true, searchCustomerController);
		
		}

	}

}

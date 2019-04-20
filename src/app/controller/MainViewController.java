package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.AddMemberView;
import app.view.AddTitleView;
import app.view.MainView;
import app.view.MemberMenuView;
import app.view.SearchMemberView;
import app.view.SearchTitleView;

public class MainViewController implements ActionListener {

	private AddTitleView addTitleView;
	private AddMemberView addMemberView;
	private SearchTitleView searchTitleView;
	private SearchMemberView searchMemberView;
	private MemberMenuView memberMenuView;
	private MainView mainView;
	
	public MainViewController(MainView mainView ) {
				
		this.mainView = mainView;
		
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search Title")) {
			
			this.searchTitleView = new SearchTitleView("Search a Title", 500, 800, true, this.mainView);
			this.mainView.setVisible(false);
		
		}
		
		if (e.getActionCommand().equals("Search Customer")) {
			
			this.searchMemberView = new SearchMemberView("Search a Customer", 500, 800, true, this.mainView);
			this.mainView.setVisible(false);
		}
		

		if (e.getActionCommand().equals("Add Title")) {
			
			this.addTitleView = new AddTitleView("Add Title Manager", 1200, 750, true, this.mainView);
			this.mainView.setVisible(false);
			
		}
		
		if (e.getActionCommand().equals("Add Member")) {
			
			this.addMemberView = new AddMemberView("Add Member Manager", 1200, 750, true, this.mainView);
			this.mainView.setVisible(false);
		
		}
		
		if (e.getActionCommand().equals("Add Member")) {
			
			this.memberMenuView = new MemberMenuView("Member Manager", 900, 900, true, this.mainView);
			this.mainView.setVisible(false);
			
		}
		
		if (e.getActionCommand().equals("EXIT")) {
			
			System.exit(1);
			
		}

	}

}

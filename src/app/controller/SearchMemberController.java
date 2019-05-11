package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.SearchMemberModel;
import app.view.MainView;
import app.view.SearchMemberView;

public class SearchMemberController implements ActionListener {

	// ATTRIBUTES
	private SearchMemberModel searchMemberModel;
	private SearchMemberView searchMemberView;
	private MainView mainView;
	private Database database;

	// CONSTRUCTOR
	public SearchMemberController(SearchMemberView searchMemberView, MainView mainView) {

		this.searchMemberView = searchMemberView;
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//ACTION SEARCH
		if (e.getActionCommand().equals("Search")) {

			String query = "SELECT mem_numb, mem_type, cust_name, cust_surname "
					+ "FROM customers WHERE cust_name LIKE '%" + this.searchMemberView.getSearchName().getText()
					+ "%';";
			this.database = new Database();
			this.searchMemberModel = new SearchMemberModel(this.database, this.searchMemberView);
			this.searchMemberModel.getData(query);
			this.searchMemberView.UpdateFrame();

		}

		//BACK MAIN MENU
		if (e.getActionCommand().equals("Go back")) {

			this.searchMemberView.dispose();
			this.mainView.setVisible(true);

		}

	}

}

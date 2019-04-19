package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.SearchMemberModel;
import app.view.SearchMemberView;

public class SearchMemberController implements ActionListener {

	private SearchMemberModel searchMemberModel;
	private SearchMemberView searchMemberView;
	private Database database;
	
	public SearchMemberController(SearchMemberView searchMemberView) {
		
		this.searchMemberView = searchMemberView;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search")) {
			
			String query = "SELECT mem_numb, mem_type, cust_name, cust_surname "
						 + "FROM customers WHERE cust_name='"+this.searchMemberView.getSearchName().getText()+"';";
			this.database = new Database();
			this.searchMemberModel = new SearchMemberModel(this.database, this.searchMemberView);
			this.searchMemberModel.getData(query);
			this.searchMemberView.UpdateFrame();
			
		}
		
		if (e.getActionCommand().equals("Go back")) {
			
			this.searchMemberView.dispose();
		}
		
		
	}

}

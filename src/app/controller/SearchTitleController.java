package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.SearchMemberModel;
import app.model.SearchTitleModel;
import app.view.MainView;
import app.view.SearchTitleView;

public class SearchTitleController implements ActionListener{

	private SearchTitleView searchTitleView;
	private SearchTitleModel searchTitleModel;
	private MainView mainView;
	private Database database;
		
	public SearchTitleController(SearchTitleView searchTitleView, MainView mainView) {
		
		this.searchTitleView = searchTitleView;
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search")) {
			
			String query = "SELECT id, type, title_name, year_rel "
						 + "FROM titles WHERE title_name LIKE '%"+this.searchTitleView.getSearchTitle().getText()+"%';";
			this.database = new Database();
			this.searchTitleModel = new SearchTitleModel(this.database, this.searchTitleView);
			this.searchTitleModel.getData(query);
			this.searchTitleView.UpdateFrame();
			
		}
		
		if (e.getActionCommand().equals("Go back")) {
			
			this.searchTitleView.dispose();
			this.mainView.setVisible(true);
			
		}
		
	}

}

package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.database.Database;
import app.model.MemberMenuModel;
import app.model.SearchMemberModel;
import app.model.SearchTitleModel;
import app.view.GuiView;
import app.view.MainView;
import app.view.MemberMenuView;
import app.view.SearchTitleView;

public class SearchTitleController implements ActionListener, ListSelectionListener{

	private SearchTitleView searchTitleView;
	private SearchTitleModel searchTitleModel;
	private MemberMenuView memberMenuView;
	private MainView mainView;
	private boolean mainFlag = true;
	private Database database;
	private String isFormatDB;
	private MemberMenuModel memberMenuModel;
		
	public SearchTitleController(SearchTitleView searchTitleView, MainView mainView) {
		
		this.searchTitleView = searchTitleView;
		this.mainView = mainView;
		
	}

	public SearchTitleController(SearchTitleView searchTitleView, MemberMenuView memberMenuView) {
		
		this.searchTitleView = searchTitleView;
		this.memberMenuView = memberMenuView;
		this.mainFlag = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search")) {
			
			String query = "SELECT * "
						 + "FROM titles WHERE title_name LIKE '%"+this.searchTitleView.getSearchTitle().getText()+"%';";
			this.database = new Database();
			this.searchTitleModel = new SearchTitleModel(this.database, this.searchTitleView);
			this.searchTitleModel.getData(query);
			this.searchTitleView.UpdateFrame();
			
		}
		
		if (e.getActionCommand().equals("Go back")) {
			
			this.searchTitleView.dispose();
			if (mainFlag) {
				this.mainView.setVisible(true);
			} 			
			
		}
		
		if (e.getActionCommand().equals("Rent")) {
			
			String TitleID = this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 0);
			int custID = this.memberMenuView.getMyCustomer().getId();
			this.database = new Database();
			this.memberMenuModel = new MemberMenuModel(this.database, this.searchTitleView, this.memberMenuView);
			
			int slotForRented = -1;
			boolean titlesRentedFull = false;
			
			if(this.memberMenuView.getMyCustomer().getTitleRentedInt(0) == 0) {
				slotForRented = 0;
			}else if (this.memberMenuView.getMyCustomer().getTitleRentedInt(1) == 0) {
				slotForRented = 1;
			}else if (this.memberMenuView.getMyCustomer().getTitleRentedInt(2) == 0) {
				slotForRented = 2;
			}else if (this.memberMenuView.getMyCustomer().getTitleRentedInt(3) == 0) {
				slotForRented = 3;
			}else {
				titlesRentedFull = true;
			}
			
			if (!titlesRentedFull) {
			//this.memberMenuModel.setRent(TitleID, custID, slotForRented, isFormatDB, true);
			this.memberMenuView.UpdateFrame(true);
			}else {
				JOptionPane.showMessageDialog(this.memberMenuView, 
											  "More than 4 titles have been rented by Member", 
											  "Error", 
											  JOptionPane.ERROR_MESSAGE);
			}
		  }
		
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		String isCD="";
		String isDVD="";
		String isBlueRay="";
		
		if (!this.searchTitleView.getMyTableModel().isSelectionEmpty()) {
			this.searchTitleView.setSelectedRow(this.searchTitleView.getMyTableModel().getMinSelectionIndex());
			

				isCD = this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 11);
				isDVD = this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 12);
				isBlueRay = this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 13);

			
			JOptionPane.showMessageDialog(this.searchTitleView,
					"Title selected: ID " + this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 0) + ", " + ""
							+ this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 1) + " " 
							+"" + this.searchTitleView.getTitlesStr(this.searchTitleView.getSelectedRow(), 2) +" "
							+". Please press ok to continue");
			
			List<String> optionsList = new ArrayList<>();
			List<String> optionsListDB = new ArrayList<>();
			
			optionsList.add("No availale");
			
			if (isCD.equals("Yes")) {
				optionsList.add("CD");
				optionsListDB.add("cd");
			}
			
			if (isDVD.equals("Yes")) {
				optionsList.add("DVD");
				optionsListDB.add("dvd");
			}
			
			if (isBlueRay.equals("Yes")) {
				optionsList.add("BlueRay");
				optionsListDB.add("blue_ray");
			}
			
			Object[] optionArray = optionsList.toArray();
						
			int format = JOptionPane.showOptionDialog(this.searchTitleView, "Select a FORMAT", "Format",
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.PLAIN_MESSAGE,
			        null, 
			        optionArray,
			        optionArray[0]);
			
			this.isFormatDB = optionArray[format].toString();
			
					
			
			
		}

	}
	
}

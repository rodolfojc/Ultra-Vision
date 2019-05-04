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
import app.model.SearchTitleModel;
import app.view.MainView;
import app.view.MemberMenuView;

public class MemberMenuController implements ActionListener, ListSelectionListener{

	private MemberMenuView memberMenuView;
	private MainView mainView;
	private Database database;
	private MemberMenuModel memberMenuModel;
	
	public MemberMenuController(MemberMenuView memberMenuView, MainView mainView) {
		
		this.memberMenuView = memberMenuView;
		this.mainView = mainView;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search")) {
			
			String query = this.memberMenuView.getSearchTitleName().getText();
			this.database = new Database();
			this.memberMenuModel = new MemberMenuModel(this.database, this.memberMenuView);
			this.memberMenuModel.getData(this.memberMenuView.getMyCustomer().getType(), query);
			this.memberMenuView.UpdateFrame();
		}
		
		if (e.getActionCommand().equals("Rent")) {
			
			String id = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 0);
			this.database = new Database();
			this.memberMenuModel = new MemberMenuModel(this.database, this.memberMenuView);
			this.memberMenuModel.setData();
		}
		
		
	}
	
		

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		String isCD="";
		String isDVD="";
		String isBlueRay="";
		
		
		//RENTED TABLE LISTENER
		if (!this.memberMenuView.getMyTableModelRented().isSelectionEmpty()) {
			this.memberMenuView.setSelectedRowRented(this.memberMenuView.getMyTableModelRented().getMinSelectionIndex());
			
			if (this.memberMenuView.getMyCustomer().getType().equals("MusicLovers")) {
				isCD = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 6);
			}else if (this.memberMenuView.getMyCustomer().getType().equals("VideoLovers") || (this.memberMenuView.getMyCustomer().getType().equals("TvLovers"))) {
				isDVD = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 8);
				isBlueRay = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 9);
			}else {
				isCD = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 10);
				isDVD = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 11);
				isBlueRay = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 12);
			}
			
			JOptionPane.showMessageDialog(this.memberMenuView,
					"Title selected: " + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 0) + ", " + ""
							+ this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 1) + " " 
							+"" + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 2) +" "
							+". If you want to release it, press return!");
			
					
			
		}
		
		//TITLES TABLE LISTENER
		if (!this.memberMenuView.getMyTableModelTitles().isSelectionEmpty()) {
			this.memberMenuView.setSelectedRowTitles(this.memberMenuView.getMyTableModelTitles().getMinSelectionIndex());
			
			if (this.memberMenuView.getMyCustomer().getType().equals("MusicLovers")) {
				isCD = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 6);
				isDVD = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 7);
				isBlueRay = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 8);
			}else if (this.memberMenuView.getMyCustomer().getType().equals("VideoLovers") || (this.memberMenuView.getMyCustomer().getType().equals("TvLovers"))) {
				isDVD = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 8);
				isBlueRay = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 9);
			}else {
				isCD = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 10);
				isDVD = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 11);
				isBlueRay = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 12);
			}
			
			JOptionPane.showMessageDialog(this.memberMenuView,
					"Title selected: ID " + this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 0) + ", " + ""
							+ this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 1) + " " 
							+"" + this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 2) +" "
							+". If you want rent it, press rent!");
			
			List<String> optionsList = new ArrayList<>();
			
			optionsList.add("No availale");
			
			if (isCD.equals("Yes")) {
				optionsList.add("CD");
			}
			
			if (isDVD.equals("Yes")) {
				optionsList.add("DVD");
			}
			
			if (isBlueRay.equals("Yes")) {
				optionsList.add("BlueRay");
			}
			
			Object[] optionArray = optionsList.toArray();
			
			
			int response = JOptionPane.showOptionDialog(this.memberMenuView, "Select a format", "Format",
			        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
			        null, optionArray, optionArray[0]);

		}
		
	}

}

package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		//RENTED TABLE LISTENER
		if (!this.memberMenuView.getMyTableModelRented().isSelectionEmpty()) {
			this.memberMenuView.setSelectedRowRented(this.memberMenuView.getMyTableModelRented().getMinSelectionIndex());
			JOptionPane.showMessageDialog(this.memberMenuView,
					"Title selected: " + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 0) + ", " + ""
							+ this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 1) + " " 
							+"" + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 2) +" "
							+". If you want to release it, press return!");

		}
		
		//TITLES TABLE LISTENER
		if (!this.memberMenuView.getMyTableModelTitles().isSelectionEmpty()) {
			this.memberMenuView.setSelectedRowTitles(this.memberMenuView.getMyTableModelTitles().getMinSelectionIndex());
			JOptionPane.showMessageDialog(this.memberMenuView,
					"Title selected: ID " + this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 0) + ", " + ""
							+ this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 1) + " " 
							+"" + this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 2) +" "
							+". If you want rent it, press rent!");

		}
		
	}

}

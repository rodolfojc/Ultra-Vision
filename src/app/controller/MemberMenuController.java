package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.database.Database;
import app.model.MemberMenuModel;
import app.model.SearchTitleModel;
import app.view.MainView;
import app.view.MemberMenuView;
import app.view.SearchTitleView;

public class MemberMenuController implements ActionListener, ListSelectionListener{

	private MemberMenuView memberMenuView;
	private MainView mainView;
	private Database database;
	private MemberMenuModel memberMenuModel;
	private String isFormatDB;
	
	
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
			this.memberMenuView.UpdateFrame(false);
		}
		
		if (e.getActionCommand().equals("Rent")) {
			
			String TitleID = this.memberMenuView.getTitlesStr(this.memberMenuView.getSelectedRowTitles(), 0);
			int custID = this.memberMenuView.getMyCustomer().getId();
			this.database = new Database();
			this.memberMenuModel = new MemberMenuModel(this.database, this.memberMenuView);
			
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
			this.memberMenuModel.setRent(TitleID, custID, slotForRented, isFormatDB, false);
			this.memberMenuView.UpdateFrame(true);
			}else {
				JOptionPane.showMessageDialog(this.memberMenuView, 
											  "More than 4 titles have been rented by Member", 
											  "Error", 
											  JOptionPane.ERROR_MESSAGE);
			}
		  }
		
		if (e.getActionCommand().equals("Return")) {
			
			int penalty = 0;
			int daysPenalty = 0;
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String dateStr = dateFormat.format(date);
			Date dataTwo = new Date();
			
			try {
				dataTwo = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			
			long diff = dataTwo.getTime() - this.memberMenuView.getDatesDate(this.memberMenuView.getSelectedRowRented()).getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

			if (diffDays >3) {
				daysPenalty = (diffDays - 3);
				penalty = daysPenalty*2;
			}
			
			String[] options = {"Pay by Card", "Cancel"};
			int opt = JOptionPane.showOptionDialog(this.memberMenuView, 
					  "The title is with = "+daysPenalty+" days penalty, TOTAL EXTRAS = €"+penalty+" ", 
					  "Confirm",
					  JOptionPane.DEFAULT_OPTION, 
				      JOptionPane.PLAIN_MESSAGE,
				      null,
					  options,
					  options[0]);
			
			if (opt == 0) {
				
				String isCD="";
				String isDVD="";
				String isBlueRay="";
				String format;
				
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
				
				if(isCD.equals(String.valueOf(this.memberMenuView.getMyCustomer().getId()))) {
					format = "cd";
				}else if(isDVD.equals(String.valueOf(this.memberMenuView.getMyCustomer().getId()))) {
					format = "dvd";
				}else {
					format = "blue_ray";
				}
				
				int selectedRow = this.memberMenuView.getSelectedRowRented();
				String TitleID = this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 0);
				int custID = this.memberMenuView.getMyCustomer().getId();
				this.database = new Database();
				this.memberMenuModel = new MemberMenuModel(this.database, this.memberMenuView);
				this.memberMenuModel.setReturn(TitleID, format, custID, selectedRow);
				this.memberMenuView.UpdateFrame(true);
			}
			
			
		} 
		
		if (e.getActionCommand().equals("FREE")) {
			
			new SearchTitleView("Search a Title", 500, 800, true, this.memberMenuView);
		
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
			JOptionPane.showMessageDialog(this.memberMenuView,
					"Title selected: " + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 0) + ", " + ""
							+ this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 1) + " " 
							+"" + this.memberMenuView.getTitlesRentedDataStr(this.memberMenuView.getSelectedRowRented(), 2) +" "
							+". If you want to release it, press Return to continue");
					
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
						
			int format = JOptionPane.showOptionDialog(this.memberMenuView, "Select a FORMAT", "Format",
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.PLAIN_MESSAGE,
			        null, 
			        optionArray,
			        optionArray[0]);
			
			this.isFormatDB = optionArray[format].toString();
			
						
						
		}
		
	}

}

package app.view;

import java.awt.Insets;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import app.controller.MemberMenuController;
import app.database.Database;
import app.model.MemberMenuModel;
import app.model.SearchMemberModel;
import customers.Customer;

public class MemberMenuView extends GuiView {

	//OTHERS
	private ListSelectionModel myTableModelTitles;
	private ListSelectionModel myTableModelRented;
	private MemberMenuController myController;
	private MemberMenuModel myModel;
	private Customer myCustomer;
	
	//ATTRIBUTES
	private JTextField fullName;
	private JTextField custBirth;
	private JTextField custEmail;
	private JTextField custMembType;
	private JTextField custPoints;
	private int selectedRowTitles, selectedRowRented;
	private boolean freeRentalFlag;
	
	//DATA
	private Database myDB;
	private String[][] titles;
	private String[][] titlesRentedData;
	private Date[] dates;
	private JButton rent;
	private JButton searchTitle;
	private JButton release;
	private JTextField searchTitleName;
	private JButton freeRentalBtn;
	
	
		
	
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView, Customer customer) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		this.myCustomer = customer;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.getStartingData();
		setFrame();
		
	}
	
	//GETTER AND SETTERS
	
	
	public String getTitlesRentedDataStr(int a, int b) {
		return this.titlesRentedData[a][b];
	}

	public boolean isFreeRentalFlag() {
		return freeRentalFlag;
	}

	public void setFreeRentalFlag(boolean freeRentalFlag) {
		this.freeRentalFlag = freeRentalFlag;
	}

	public JTextField getSearchTitleName() {
		return searchTitleName;
	}

	public void setSearchTitleName(JTextField searchTitleName) {
		this.searchTitleName = searchTitleName;
	}

	public ListSelectionModel getMyTableModelRented() {
		return myTableModelRented;
	}

	public void setMyTableModelRented(ListSelectionModel myTableModelRented) {
		this.myTableModelRented = myTableModelRented;
	}

	public int getSelectedRowRented() {
		return selectedRowRented;
	}

	public void setSelectedRowRented(int selectedRowRented) {
		this.selectedRowRented = selectedRowRented;
	}

	public int getSelectedRowTitles() {
		return selectedRowTitles;
	}

	public void setSelectedRowTitles(int selectedRow) {
		this.selectedRowTitles = selectedRow;
	}

	public ListSelectionModel getMyTableModelTitles() {
		return myTableModelTitles;
	}

	public void setMyTableModelTitles(ListSelectionModel myTableModel) {
		this.myTableModelTitles = myTableModel;
	}

	public Customer getMyCustomer() {
		return myCustomer;
	}

	public void setMyCustomer(Customer myCustomer) {
		this.myCustomer = myCustomer;
	}

	public void setTitlesRentedData(String[][] data) {
		this.titlesRentedData = Arrays.copyOf(data, data.length);;
	}
	
	public String getTitlesStr(int a, int b) {
		return this.titles[a][b];
	}

	public void setTitles(String[][] data) {
		this.titles = Arrays.copyOf(data, data.length);;
	}
	
	public void setDates(Date[] dates) {
		this.dates = Arrays.copyOf(dates, dates.length);;
	}
	
	public Date getDatesDate(int a) {
		return this.dates[a];
	}
	
	//METHODS
	public void getStartingData() {
		
		this.myDB = new Database();
		this.myModel = new MemberMenuModel(this.myDB, this);
		this.myModel.getData(this.myCustomer.getType(), "");
	}
	
	public void setTablesListeners() {
		
		this.myTableModelRented = this.myTable[0].getSelectionModel();
		this.myTableModelRented.addListSelectionListener(this.myController);
		this.myTableModelTitles = this.myTable[1].getSelectionModel();
		this.myTableModelTitles.addListSelectionListener(this.myController);
	}
	
	public void setBtnSearch(JPanel myTitles) {
		
		JPanel myBtnRentPanel = new JPanel();
		this.addLabel("By name ", myBtnRentPanel);
		this.searchTitleName = this.addTextField(20, myBtnRentPanel);
		this.searchTitle = this.addButtonAll("Search", "Search", myBtnRentPanel, this.myController);
		myTitles.add(myBtnRentPanel);
	}
	
	public void setBtnTitles(JPanel myPanel) {
		
		JPanel myBtnRentRealasePanel = new JPanel();
		this.rent = this.addButtonAll("Rent", "Rent", myBtnRentRealasePanel, this.myController);
		this.freeRentalBtn = this.addButtonAll("FREE RENTAL", "FREE", myBtnRentRealasePanel, this.myController);
		this.myCustomer.getMyMemberCard().setRentAllowed();
		if (!this.myCustomer.getMyMemberCard().isfreeRentAllowed()) {
			freeRentalBtn.setEnabled(false);
		}
		myPanel.add(myBtnRentRealasePanel);
		
	}
	
	public void setBtnRented(JPanel myPanel) {
		
		JPanel myBtnRentRelease = new JPanel();
		this.release = this.addButtonAll("Return", "Return", myBtnRentRelease, this.myController);
		this.addButtonAll("Go back", "Go back", myBtnRentRelease, this.myController);
		myPanel.add(myBtnRentRelease);
		
	}

	public void setFrame() {
		
		this.setGrid(3, 0, this.panel);
		
		JPanel myCustDetails = new JPanel();
		this.setGrid(8, 2, myCustDetails);
		
		JPanel title = new JPanel();
		this.addLabel("", title);
		myCustDetails.add(title);
		this.addLabel("Personal details", myCustDetails);
		
		this.addLabel("Member: ", myCustDetails);
		this.fullName = this.addTextField(20, myCustDetails);
		this.fullName.setText(this.myCustomer.getCustName()+" "+this.myCustomer.getCustSurname()+" ("+this.myCustomer.getId()+")");
		this.fullName.setEditable(false);
			
		this.addLabel("Date of birth: ", myCustDetails);
		this.custBirth = this.addTextField(20, myCustDetails);
		this.custBirth.setText(this.myCustomer.getBirthday());
		this.custBirth.setEditable(false);
				
		this.addLabel("Email: ", myCustDetails);
		this.custEmail = this.addTextField(20, myCustDetails);
		this.custEmail.setText(this.myCustomer.getEmail());
		this.custEmail.setEditable(false);
		
		this.addLabel("Membership type: ", myCustDetails);
		this.custMembType = this.addTextField(20, myCustDetails);
		this.custMembType.setText(this.myCustomer.getType());
		this.custMembType.setEditable(false);
		
		this.addLabel("Member points", myCustDetails);
		this.custPoints = this.addTextField(20, myCustDetails);
		this.custPoints.setText(String.valueOf(this.myCustomer.getMyMemberCard().getPoints()));
		this.custPoints.setEditable(false);
		
		this.addLabel("", myCustDetails);
		this.addLabel("", myCustDetails);
		this.panel.add(myCustDetails);
		
		JPanel myTitles = new JPanel();
		JPanel myRented = new JPanel();
		this.setGrid(3, 0, myTitles);
		this.setGrid(2, 0, myRented);
		
		if (this.myCustomer.getType().equals("MusicLovers")) {
			
			String[] columnsNameTitles = {"ID","Title", "Year", "Album", "Band", "Genre", "CD", "DVD", "BlueRay"};
			this.setBtnSearch(myTitles);
			this.addTableS(1, this.titles, columnsNameTitles, myTitles, "Titles - "+this.myCustomer.getType());
			this.setBtnTitles(myTitles);
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, myRented, "Titles - Rented");
			this.setBtnRented(myRented);
			
		
		}else if (this.myCustomer.getType().equals("VideoLovers") || (this.myCustomer.getType().equals("TvLovers"))) {
			
			String[] columnsNameTitles = {"ID","Title", "Year", "Genre", "Director", "Running Time", "Languages", "Country", "DVD", "BlueRay"};
			this.setBtnSearch(myTitles);
			this.addTableS(1, this.titles, columnsNameTitles, myTitles, "Titles - "+this.myCustomer.getType());
			this.setBtnTitles(myTitles);
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, myRented, "Titles - Rented");
			this.setBtnRented(myRented);
			
		} else {
			
			String[] columnsNameTitles = {"ID","Title", "Year", "Album", "Band", "Genre", "Director", "Running Time", "Languages", "Country", "CD", "DVD", "BlueRay"};
			this.setBtnSearch(myTitles);
			this.addTableS(1, this.titles, columnsNameTitles, myTitles, "Titles - "+this.myCustomer.getType());
			this.setBtnTitles(myTitles);
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, myRented, "Titles - Rented");
			this.setBtnRented(myRented);
		}
		
		this.panel.add(myTitles);
		this.panel.add(myRented);
		this.setTablesListeners();
		
		this.panel.setBorder(new EmptyBorder(new Insets(10, 40, 10, 40)));
		
		this.repaint();
		this.validate();
		
	}
	
	public void UpdateFrame(boolean flag) {
			
		this.panel.removeAll();
		
		if(flag) {
			this.getStartingData();
			setFrame();
		}else {
		setFrame();
		}
	}

}

package app.view;

import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JButton;
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
	
	//DATA
	private Database myDB;
	private String[][] titles;
	private String[][] titlesRentedData;
	private JButton rent;
	private JButton searchTitle;
	private JButton release;
	private JTextField searchTitleName;
	private JButton freeRentalBtn;
	
	
		
	
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView, Customer customer) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		this.myCustomer = customer;
		this.getStartingData();
		setFrame();
		
	}
	
	//GETTER AND SETTERS
	public String getTitlesRentedDataStr(int a, int b) {
		return this.titlesRentedData[a][b];
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
	
	
	//METHODS
	public void getStartingData() {
		
		this.myDB = new Database();
		this.myModel = new MemberMenuModel(this.myDB, this);
		this.myModel.getData(this.myCustomer.getType());
	}
	
	public void setTablesListeners() {
		
		this.myTableModelRented = this.myTable[0].getSelectionModel();
		this.myTableModelRented.addListSelectionListener(this.myController);
		this.myTableModelTitles = this.myTable[1].getSelectionModel();
		this.myTableModelTitles.addListSelectionListener(this.myController);
	}
	

	public void setFrame() {
		
		this.setGrid(8, 0, this.panel);
		
		JPanel myCustDetails = new JPanel();
		this.setGrid(6, 2, myCustDetails);
		
		JPanel title = new JPanel();
		this.addLabel("Personal details", title);
		myCustDetails.add(title);
		this.addLabel("", myCustDetails);
		
		this.addLabel("Member: ", myCustDetails);
		this.fullName = this.addTextField(20, myCustDetails);
		this.fullName.setText(this.myCustomer.getCustName()+" "+this.myCustomer.getCustSurname());
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
		
		//JPanel titlesRented = new JPanel();
		//String[][] titlesRentedData = new String[4][4];
		//String[] columnsNameRented = {"1", "2", "3", "4"};
		//this.addTableS(0, this.titlesRentedData, columnsNameRented, titlesRented, "Titles Rented");
		//JPanel searchTitles = new JPanel();
		this.panel.add(myCustDetails);
		//this.panel.add(titlesRented);
				
		if (this.myCustomer.getType().equals("MusicLovers")) {
			
			String[] columnsNameTitles = {"Title", "Year", "Album", "Band", "Genre", "CD", "DVD", "BlueRay"};
			this.addLabel("Titles for "+this.myCustomer.getType(), this.panel);
			
			JPanel myBtnRentPanel = new JPanel();
			this.searchTitleName = this.addTextField(20, myBtnRentPanel);
			this.searchTitle = this.addButtonAll("Searh", "Search", myBtnRentPanel, this.myController);
			this.panel.add(myBtnRentPanel);
			
			this.addTableS(1, this.titles, columnsNameTitles, this.panel, "Titles for "+this.myCustomer.getType());
			
			JPanel myBtnRentRealasePanel = new JPanel();
			this.rent = this.addButtonAll("Rent", "Rent", myBtnRentRealasePanel, this.myController);
			this.freeRentalBtn = this.addButtonAll("FREE RENTAL", "FREE", myBtnRentRealasePanel, this.myController);
			if (!this.myCustomer.getMyMemberCard().availFreeRent()) {
				freeRentalBtn.setEnabled(false);
			}
			this.panel.add(myBtnRentRealasePanel);
			
			this.addLabel("Titles rented", this.panel);
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, this.panel, "Titles Rented");
			JPanel myBtnRentRelease = new JPanel();
			this.release = this.addButtonAll("Release", "Release", myBtnRentRelease, this.myController);
			this.panel.add(myBtnRentRelease);
			
		
		}else if (this.myCustomer.getType().equals("VideoLovers") || (this.myCustomer.getType().equals("TvLovers"))) {
			
			String[] columnsNameTitles = {"Title", "Year", "Genre", "Director", "Running Time", "Languages", "Country", "DVD", "BlueRay"};
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, this.panel, "Titles Rented");
			this.addTableS(1, this.titles, columnsNameTitles, this.panel, "Titles for "+this.myCustomer.getType());
			
		} else {
			
			String[] columnsNameTitles = {"Title", "Year", "Album", "Band", "Genre", "Director", "Running Time", "Languages", "Country", "CD", "DVD", "BlueRay"};
			this.addTableS(0, this.titlesRentedData, columnsNameTitles, this.panel, "Titles Rented");
			this.addTableS(1, this.titles, columnsNameTitles, this.panel, "Titles for "+this.myCustomer.getType());
			
		}
		
		this.setTablesListeners();
		
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 25, 65)));
		
		//this.addTableS(1, titlesData, columnsNameTitles, searchTitles, "Titles for "+this.myCustomer.getType());
		//this.panel.add(myCustDetails);
		//this.panel.add(titlesRented);
		//this.panel.add(searchTitles);
		
		this.repaint();
		this.validate();
		
	}

}

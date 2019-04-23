package app.view;

import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.controller.MemberMenuController;
import app.database.Database;
import app.model.MemberMenuModel;
import app.model.SearchMemberModel;
import customers.Customer;

public class MemberMenuView extends GuiView {

	private MemberMenuController myController;
	private MemberMenuModel myModel;
	private Customer myCustomer;
	
	private JTextField fullName;
	private JTextField custBirth;
	private JTextField custEmail;
	private JTextField custMembType;
	private JTextField custPoints;
	
	//DATA
	private Database myDB;
	private String[][] titles;
	
		
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView, Customer customer) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		this.myCustomer = customer;
		this.getStartingData();
		setFrame();
		
	}
	
	//GETTER AND SETTERS
	public String getTitlesStr(int a, int b) {
		return this.titles[a][b];
	}

	public void setTitles(String[][] data) {
		this.titles = Arrays.copyOf(data, data.length);;
	}
	
	//METHODS
	private void getStartingData() {
		
		this.myDB = new Database();
		this.myModel = new MemberMenuModel(this.myDB, this);
		this.myModel.getData(this.myCustomer.getType());
	}
	

	public void setFrame() {
		
		this.setGrid(3, 0, this.panel);
		
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
		
		JPanel titlesRented = new JPanel();
		String[][] titlesRentedData = new String[4][4];
		String[] columnsNameRented = {"1", "2", "3", "4"};
		this.addTableS(0, titlesRentedData, columnsNameRented, titlesRented, "Titles Rented");
		
		JPanel searchTitles = new JPanel();
		
		if (this.myCustomer.getType().equals("MusicLovers")) {
			
			String[] columnsNameTitles = {"Title", "Year", "Album", "Band", "Genre", "CD", "DVD", "BlueRay"};
			this.addTableS(1, this.titles, columnsNameTitles, searchTitles, "Titles for "+this.myCustomer.getType());
		
		}else if (this.myCustomer.getType().equals("VideoLovers") || (this.myCustomer.getType().equals("TvLovers"))) {
			
			String[] columnsNameTitles = {"Title", "Year", "Genre", "Director", "Running Time", "Languages", "Country", "DVD", "BlueRay"};
			this.addTableS(1, this.titles, columnsNameTitles, searchTitles, "Titles for "+this.myCustomer.getType());
			
		} else {
			
			String[] columnsNameTitles = {"Title", "Year", "Album", "Band", "Genre", "Director", "Running Time", "Languages", "Country", "CD", "DVD", "BlueRay"};
			this.addTableS(1, this.titles, columnsNameTitles, searchTitles, "Titles for "+this.myCustomer.getType());
			
		}
				
		//this.addTableS(1, titlesData, columnsNameTitles, searchTitles, "Titles for "+this.myCustomer.getType());
		
				
		this.panel.add(myCustDetails);
		this.panel.add(titlesRented);
		this.panel.add(searchTitles);
		
		this.repaint();
		this.validate();
		
	}

}

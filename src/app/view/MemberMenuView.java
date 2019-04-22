package app.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.controller.MemberMenuController;
import customers.Customer;

public class MemberMenuView extends GuiView {

	private MemberMenuController myController;
	private Customer myCustomer;
	private JTextField fullName;
	private JTextField custBirth;
	private JTextField custEmail;
	private JTextField custMembType;
	private JTextField custPoints;
	
	
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView, Customer customer) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		this.myCustomer = customer;
		setFrame();
		
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
		String[][] titlesData = new String[4][4];
		String[] columnsName = {"1", "2", "3", "4"};
		this.addTableS(0, titlesData, columnsName, searchTitles, "Titles for "+this.myCustomer.getType());
		
		
		
		
		
		this.panel.add(myCustDetails);
		this.panel.add(titlesRented);
		this.panel.add(searchTitles);
		
		this.repaint();
		this.validate();
		
	}

}

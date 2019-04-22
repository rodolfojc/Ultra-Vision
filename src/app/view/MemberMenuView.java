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
	
	
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView, Customer customer) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		this.myCustomer = customer;
		setFrame();
		
	}

	public void setFrame() {
		
		this.setGrid(1, 0, this.panel);
		
		JPanel myCustDetails = new JPanel();
		this.setGrid(5, 2, myCustDetails);
		
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
		
		this.addLabel("Membership Type: ", myCustDetails);
		this.custMembType = this.addTextField(20, myCustDetails);
		this.custMembType.setText(this.myCustomer.getType());
		this.custMembType.setEditable(false);
				
		this.panel.add(myCustDetails);
		
		this.repaint();
		this.validate();
		
	}

}

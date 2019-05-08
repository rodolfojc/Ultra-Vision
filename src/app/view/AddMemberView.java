package app.view;

import java.awt.Font;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import app.controller.AddMemberController;

public class AddMemberView extends GuiView {

	// PERSONAL ATTRIBUTES
	private JTextField custName;
	private JTextField custSurname;
	private JTextField email;
	private JComboBox membType;
	
	// PAYMENT ATTRIBUTES
	private JComboBox cardType;
	private JTextField cardNumber;
	private JTextField cardHolder;
	private JTextField cardCVV;
	
	//OPTIONS
	private String[] cardTypeOpt = {"Mastercard", "Visa", "Other"};
	private String[] memberType = {"MusicLovers", "VideoLovers", "TvLovers", "Premiun"};
	
	//CONTROLLER
	private AddMemberController myController;
	private JDateChooser birthCal;
	private JDateChooser expCal;
	
	
	//CONSTRUCTOR
	public AddMemberView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new AddMemberController(this, mainView);;
		setFrame();
	}
	
	
	//SETTER AND GETTER
	public JTextField getCustName() {
		return custName;
	}

	public void setCustName(JTextField custName) {
		this.custName = custName;
	}

	public JTextField getCustSurname() {
		return custSurname;
	}

	public void setCustSurname(JTextField custSurname) {
		this.custSurname = custSurname;
	}

	public String getBirthday() {
		SimpleDateFormat myDateSimp = new SimpleDateFormat("dd/MM/yyyy"); 
		return myDateSimp.format(this.birthCal.getDate());
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public String getMembType() {
		return this.memberType[membType.getSelectedIndex()];
	}

	public void setMembType(JComboBox membType) {
		this.membType = membType;
	}

	public String getCardType() {
		return this.cardTypeOpt[cardType.getSelectedIndex()];
	}

	public void setCardType(JComboBox cardType) {
		this.cardType = cardType;
	}

	public JTextField getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(JTextField cardNumber) {
		this.cardNumber = cardNumber;
	}

	public JTextField getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(JTextField cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardExp() {
		SimpleDateFormat myDateSimp = new SimpleDateFormat("MM/yy"); 
		return myDateSimp.format(this.expCal.getDate());
	}

	public JTextField getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(JTextField cardCVV) {
		this.cardCVV = cardCVV;
	}

	public void setFrame() {
		
		this.setGrid(0, 2,this.panel);
		
		//PERSONAL DETAILS
		JPanel left = new JPanel();
		this.setGrid(14, 0, left);
		JLabel personalDetails = this.addLabel("Personal details", left);
		personalDetails.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetails.setFont(new Font("Serif", Font.BOLD, 35));
		this.addLabel("", left);
		this.addLabel("Name ", left);
		this.custName = this.addTextField(20, left);
		this.addLabel("Surname ", left);
		this.custSurname = this.addTextField(20, left);
		this.addLabel("Birthday DD/MM/YYYY", left);
		//JPanel birthPanel = new JPanel();
		this.birthCal = this.addCalen(left);
		//this.birthday = this.addTextField(20, birthPanel);
		//left.add(birthPanel);
		this.addLabel("Email", left);
		this.setEmail(this.addTextField(20, left));
		this.addLabel("Membership type ", left);
		this.membType = this.addComboB(memberType, left);
		this.addLabel("", left);
		this.addButtonAll("Go back", "Go back", left, this.myController);
		
		
		left.setBorder(new EmptyBorder(new Insets(0, 0, 0, 25)));
		
		//PAYMENT
		JPanel center = new JPanel();
		this.setGrid(14, 0, center);
		JLabel paymentDetails = this.addLabel("Payment details", center);
		paymentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		paymentDetails.setFont(new Font("Serif", Font.BOLD, 35));
		this.addLabel("", center);
		this.addLabel("Type ", center);
		this.cardType = this.addComboB(cardTypeOpt, center);
		this.addLabel("Card Number ", center);
		this.cardNumber = this.addTextField(20, center);
		this.addLabel("Card holder name (as printed on card) ", center);
		this.cardHolder = this.addTextField(20, center);
		this.addLabel("Expire date ", center);
		this.expCal = this.addCalen(center);
		this.expCal.setDateFormatString("MM/yy");
		//this.cardExp = this.addTextField(20, center);
		this.addLabel("CVV (3 digits) ", center);
		this.cardCVV = this.addTextField(20, center);
		this.addLabel("", center);
		this.addButtonAll("SUBMIT", "Submit", center, this.myController);
		
		
		center.setBorder(new EmptyBorder(new Insets(0, 25, 0, 0)));
		
		this.panel.add(left);
		this.panel.add(center);
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 45, 65)));
		
		this.validate();
		this.repaint();
		
	}

	

}

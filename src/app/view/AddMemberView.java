package app.view;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.AddMemberController;

public class AddMemberView extends GuiView {

	AddMemberController myController;
	
	public AddMemberView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		this.myController = new AddMemberController(this);;
		setFrame();
	}
	
	@Override
	public JLabel addLabel(String text, JPanel panel) {
		
		JLabel myLabel = new JLabel(text);
		myLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(myLabel);
		return myLabel;
	}
	
	
	@Override
	public JTextField addTextField(int a, JPanel panel) {
		
		JTextField myText = new JTextField(a);
		myText.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(myText);
		return myText;
	}
	
	

	@Override
	public JComboBox addComboB(String[] options, JPanel panel) {
		
		JComboBox myComboBox = new JComboBox(options);
		myComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(myComboBox);
		return myComboBox;
	}
	
	

	@Override
	public JButton addButton(String name, JPanel panel) {
		
		JButton myButton= new JButton(name);
		myButton.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(myButton);
		return myButton;
	}

	private void setFrame() {
		
		String[] cardType = {"Mastercard", "Visa", "Other"};
		String[] memberType = {"MusicLovers", "VideoLovers", "TvLovers", "Premiun"};
		
		this.setGrid(0, 2,this.panel);
		
		//PERSONAL DETAILS
		JPanel left = new JPanel();
		this.setGrid(14, 0, left);
		JLabel personalDetails = this.addLabel("Personal details", left);
		personalDetails.setHorizontalAlignment(SwingConstants.CENTER);
		personalDetails.setFont(new Font("Serif", Font.BOLD, 35));
		this.addLabel("", left);
		this.addLabel("Name ", left);
		this.addTextField(20, left);
		this.addLabel("Surname ", left);
		this.addTextField(20, left);
		this.addLabel("Birthday DD/MM/YYYY", left);
		this.addTextField(20, left);
		this.addLabel("Membership type ", left);
		this.addComboB(memberType, left);
		this.addLabel("", left);
		this.addLabel("", left);
		this.addLabel("", left);
		JButton goBack = this.addButton("Go Back", left);
		left.setBorder(new EmptyBorder(new Insets(0, 0, 0, 25)));
		
		//PAYMENT
		JPanel center = new JPanel();
		this.setGrid(14, 0, center);
		JLabel paymentDetails = this.addLabel("Payment details", center);
		paymentDetails.setHorizontalAlignment(SwingConstants.CENTER);
		paymentDetails.setFont(new Font("Serif", Font.BOLD, 35));
		this.addLabel("", center);
		this.addLabel("Type ", center);
		this.addComboB(cardType, center);
		this.addLabel("Card Number ", center);
		this.addTextField(20, center);
		this.addLabel("Card holder name (as printed on card) ", center);
		this.addTextField(20, center);
		this.addLabel("Expire date ", center);
		this.addTextField(20, center);
		this.addLabel("CVV (3 digits) ", center);
		this.addTextField(20, center);
		this.addLabel("", center);
		JButton submit = this.addButton("SUBMIT", center);
		submit.setActionCommand("Submit");
		submit.addActionListener(myController);
		
		center.setBorder(new EmptyBorder(new Insets(0, 25, 0, 0)));
		
		this.panel.add(left);
		this.panel.add(center);
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 45, 65)));
		
		this.validate();
		this.repaint();
		
	}

}

package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.database.Database;
import app.model.AddMemberModel;
import app.view.AddMemberView;
import app.view.MainView;
import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;
import customers.PremiunLovers;
import customers.TvLovers;
import customers.VideoLovers;

public class AddMemberController implements ActionListener{

	private AddMemberView addMemberView;
	private AddMemberModel addMemberModel;
	private DebitCreditCard debitCreditCard;
	private MembershipCard membershipCard;
	private MainView mainView;
	private Customer customer;
	private Database database;
	
	//REGEX
	//IT MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
	private String regexGeneral = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
	// EMAIL MUST HAVE A SIMBOL @
	private String regexEmail = "^(.+)@(.+)$";
	//CREDIT - DEBIT CARD FOR MASTERCAR, VISA AND OTHERS
	private String regexCard = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
	        "(?<mastercard>5[1-5][0-9]{14})|" +
	        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
	        "(?<amex>3[47][0-9]{13})|" +
	        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
	        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
	//CVV 3 - 4 DIGITS 0 - 9
	private String regexCVV = "^([0-9]{3,4})$";
	
	
	public AddMemberController(AddMemberView addMemberView, MainView mainView) {
		
		this.addMemberView = addMemberView;
		this.mainView = mainView;
				
	}
	
	public DebitCreditCard createPaymentCard(AddMemberView addMemberView) {
		
		return this.debitCreditCard = new DebitCreditCard(this.addMemberView.getCardType(),
				  								   this.addMemberView.getCardNumber().getText(),
				  								   this.addMemberView.getCardHolder().getText().toUpperCase(),
				  								   this.addMemberView.getCardExp(),
				  								   this.addMemberView.getCardCVV().getText());
		
	}
	
	public MembershipCard createMemberCard(DebitCreditCard debitCreditCard) {
		
		return this.membershipCard = new MembershipCard(debitCreditCard, 0, false);
				
	}
	
	public boolean registerValidation(){
		
		//VALIDATION FLAG
		boolean valFlag = true;
		
		//NAME
		if(!this.addMemberView.getCustName().getText().matches(this.regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The name is not correct or it is empty, try again"),
					"Name - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
		}
		
		// SURNAME 
		else if(!this.addMemberView.getCustSurname().getText().matches(this.regexGeneral)) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The surname is not correct or empty, try again"),
					"Surname - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		// EMAIL
		else if(!this.addMemberView.getEmail().getText().matches(this.regexEmail)) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The email is not correct or it is empty, try again"),
					"Email - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
		}
		
		//CARD		
		else if (!this.addMemberView.getCardNumber().getText().matches(this.regexCard)) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The card is not correct or it is empty, try again"),
					"Card - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		
		// CARDHOLDER MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
		// CARDHOLDER MUST CONTAIN SURNAME 
		else if (!this.addMemberView.getCardHolder().getText().toLowerCase().matches(this.regexGeneral) || 
				(!this.addMemberView.getCardHolder().getText().toLowerCase().contains(this.addMemberView.getCustSurname().getText().toLowerCase()))) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The cardholder is not correct (must be titular) or it is empty, " + "try again"),
					"Cardholder - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}
		//CVV 3 - 4 DIGITS 0 - 9
		else if(!this.addMemberView.getCardCVV().getText().matches(this.regexCVV)) {
			
			JOptionPane.showMessageDialog(this.addMemberView, this.addMemberView.addLabelOpt("The CVV number is not correct or it is empty, " + "try again"),
					"CVV - Error", JOptionPane.ERROR_MESSAGE);
			// IT DOES NOT MATCH, FLAG IS SET FALSE
			valFlag = false;
			
		}else {
			
			return valFlag;
			
		}
		
		return valFlag;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Submit")) {
			
			if (this.registerValidation()) {	
						
			
				this.debitCreditCard = createPaymentCard(addMemberView);
				this.membershipCard = createMemberCard(debitCreditCard);
				this.database = new Database();
				
				if (this.addMemberView.getMembType().equals("MusicLovers")) {
					
					this.customer = new MusicLovers(this.addMemberView.getCustName().getText(),
													this.addMemberView.getCustSurname().getText(),
													this.addMemberView.getBirthday(),
													this.addMemberView.getEmail().getText(),
													this.membershipCard,
													this.debitCreditCard);
					
				} else if (this.addMemberView.getMembType().equals("VideoLovers")) {
					
					this.customer = new VideoLovers(this.addMemberView.getCustName().getText(),
													this.addMemberView.getCustSurname().getText(),
													this.addMemberView.getBirthday(),
													this.addMemberView.getEmail().getText(),
													this.membershipCard,
													this.debitCreditCard);
					
				}else if (this.addMemberView.getMembType().equals("TvLovers")) {
					
					this.customer = new TvLovers(this.addMemberView.getCustName().getText(),
												 this.addMemberView.getCustSurname().getText(),
												 this.addMemberView.getBirthday(),
												 this.addMemberView.getEmail().getText(),
												 this.membershipCard,
												 this.debitCreditCard);
									
				}else {
					
					this.customer = new PremiunLovers(this.addMemberView.getCustName().getText(),
													this.addMemberView.getCustSurname().getText(),
													this.addMemberView.getBirthday(),
													this.addMemberView.getEmail().getText(),
													this.membershipCard,
													this.debitCreditCard);
					
				}
			
				this.addMemberModel = new AddMemberModel(database, addMemberView, this.customer);
				this.addMemberModel.AddMember();
				this.addMemberView.dispose();
				this.mainView.setVisible(true);
						
			}
		}
		
		if(e.getActionCommand().equals("Go back")) {
			
			this.addMemberView.dispose();
			this.mainView.setVisible(true);
			
		}
		
		
		
	}

	

}

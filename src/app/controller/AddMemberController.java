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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Submit")) {
			
			boolean valFlag = true;
			
			// NAME MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
			if(!this.addMemberView.getCustName().getText().matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$")) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The name is not correct or it is empty, " + "try again",
						"Name Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
			}
			
			// SURNAME MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
			if(!this.addMemberView.getCustSurname().getText().matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$")) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The surname is not correct or empty, " + "try again",
						"Surname Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
				
			}
			
			// EMAIL MUST HAVE A SIMBOL @
			if(!this.addMemberView.getEmail().getText().matches("^(.+)@(.+)$")) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The email is not correct or it is empty, " + "try again",
						"Email Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
			}
			
			//CREDIT - DEBIT CARD FOR MASTERCAR, VISA AND OTHERS
			String regexCard = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
			        "(?<mastercard>5[1-5][0-9]{14})|" +
			        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
			        "(?<amex>3[47][0-9]{13})|" +
			        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
			        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
			
			if (!this.addMemberView.getCardNumber().getText().matches(regexCard)) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The card is not correct or it is empty, " + "try again",
						"Card Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
				
			}
			
			// CARDHOLDER MUST BE LETTER A-Z, NO EMPTY FIELD AND UP TO 24 CHARACTERS
			// CARDHOLDER MUST CONTAIN SURNAME 
			if (!this.addMemberView.getCardHolder().getText().toLowerCase().matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$") || 
			(!this.addMemberView.getCardHolder().getText().toLowerCase().contains(this.addMemberView.getCustSurname().getText().toLowerCase()))) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The cardholder is not correct (must be titular) or it is empty, " + "try again",
						"Cardholder Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
				
			}
			//CVV 3 - 4 DIGITS 0 - 9
			if(!this.addMemberView.getCardCVV().getText().matches("^([0-9]{3,4})$")) {
				
				JOptionPane.showMessageDialog(this.addMemberView, "The CVV number is not correct or it is empty, " + "try again",
						"CVV Error", JOptionPane.ERROR_MESSAGE);
				// IT DOES NOT MATCH, FLAG IS SET FALSE
				valFlag = false;
				
			}
			
			
			if (valFlag) {	
			
			
			
			
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

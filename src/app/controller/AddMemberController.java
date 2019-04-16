package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.AddMemberModel;
import app.view.AddMemberView;
import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;

public class AddMemberController implements ActionListener{

	private AddMemberView addMemberView;
	private AddMemberModel addMemberModel;
	private Customer customer;
	private Database database;
	
	public AddMemberController(AddMemberView addMemberView) {
		
		this.addMemberView = addMemberView;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Submit")) {
		
			if (this.addMemberView.getMembType().equals("MusicLovers")) {
				
				DebitCreditCard tempDebitCreditCard = new DebitCreditCard(this.addMemberView.getCardType(),
																		  this.addMemberView.getCardNumber().getText(),
																		  this.addMemberView.getCardHolder().getText(),
																		  this.addMemberView.getCardExp().getText(),
																		  this.addMemberView.getCardCVV().getText());
				MembershipCard tempCard = new MembershipCard(tempDebitCreditCard, 0, false);
				this.customer = new MusicLovers(this.addMemberView.getCustName().getText(),
															  this.addMemberView.getCustSurname().getText(),
															  this.addMemberView.getBirthday().getText(),
															  tempCard,
															  tempDebitCreditCard);
				
				this.database = new Database();
				this.addMemberModel = new AddMemberModel(database, addMemberView, this.customer);
				this.addMemberModel.AddMember();
				
			}
			
			
			
			
		}
		
		
		
	}

	

}

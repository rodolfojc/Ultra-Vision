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
import customers.PremiunLovers;
import customers.TvLovers;
import customers.VideoLovers;

public class AddMemberController implements ActionListener{

	private AddMemberView addMemberView;
	private AddMemberModel addMemberModel;
	private DebitCreditCard debitCreditCard;
	private MembershipCard membershipCard;
	private Customer customer;
	private Database database;
	
	public AddMemberController(AddMemberView addMemberView) {
		
		this.addMemberView = addMemberView;
				
	}
	
	public DebitCreditCard createPaymentCard(AddMemberView addMemberView) {
		
		return this.debitCreditCard = new DebitCreditCard(this.addMemberView.getCardType(),
				  								   this.addMemberView.getCardNumber().getText(),
				  								   this.addMemberView.getCardHolder().getText(),
				  								   this.addMemberView.getCardExp().getText(),
				  								   this.addMemberView.getCardCVV().getText());
		
	}
	
	public MembershipCard createMemberCard(DebitCreditCard debitCreditCard) {
		
		return this.membershipCard = new MembershipCard(debitCreditCard, 0, false);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Submit")) {
		
			this.debitCreditCard = createPaymentCard(addMemberView);
			this.membershipCard = createMemberCard(debitCreditCard);
			this.database = new Database();
			
			if (this.addMemberView.getMembType().equals("MusicLovers")) {
				
				this.customer = new MusicLovers(this.addMemberView.getCustName().getText(),
												this.addMemberView.getCustSurname().getText(),
												this.addMemberView.getBirthday().getText(),
												this.membershipCard,
												this.debitCreditCard);
				
			} else if (this.addMemberView.getMembType().equals("VideoLovers")) {
				
				this.customer = new VideoLovers(this.addMemberView.getCustName().getText(),
												this.addMemberView.getCustSurname().getText(),
												this.addMemberView.getBirthday().getText(),
												this.membershipCard,
												this.debitCreditCard);
				
			}else if (this.addMemberView.getMembType().equals("TvLovers")) {
				
				this.customer = new TvLovers(this.addMemberView.getCustName().getText(),
											 this.addMemberView.getCustSurname().getText(),
											 this.addMemberView.getBirthday().getText(),
											 this.membershipCard,
											 this.debitCreditCard);
								
			}else {
				
				this.customer = new PremiunLovers(this.addMemberView.getCustName().getText(),
												this.addMemberView.getCustSurname().getText(),
												this.addMemberView.getBirthday().getText(),
												this.membershipCard,
												this.debitCreditCard);
				
			}
		
			this.addMemberModel = new AddMemberModel(database, addMemberView, this.customer);
			this.addMemberModel.AddMember();
			
						
		}
		
		
		
	}

	

}

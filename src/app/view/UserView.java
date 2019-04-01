package app.view;

import java.util.Scanner;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;

public class UserView {

	private Customer myUser;
	private DebitCreditCard myCard;
	MembershipCard myMembCard;
	
	public UserView() {
		createUser();
	}

	public void createUser() {
		
		System.out.println("Please, enter customer name");
		Scanner myScanner = new Scanner(System.in);
		String name = myScanner.nextLine();
				
		System.out.println("Please, enter customer astname");
		String lastName = myScanner.nextLine();
		
		System.out.println("Please, enter date of birth (DD/MM/YYYY)");
		String birthday = myScanner.nextLine();
		
		//TYPE OF ACCOUNT
		System.out.println("Please, enter type of account");
		System.out.println("(1) MusicLovers");
		System.out.println("(2) VideoLovers");
		System.out.println("(3) TvLovers");
		System.out.println("(4) Premium");
		String type = myScanner.nextLine();
		
		//PAYMENT - CARD
		System.out.println("Please, enter type of card");
		System.out.println("(1) Mastercad");
		System.out.println("(2) Visa");
		System.out.println("(3) Other");
		String cardType = myScanner.nextLine();
		
		System.out.println("PAYMENT - DEBIR / CREDIT CARD");
		System.out.println("Please, introduce card number");
		String card = myScanner.nextLine();
		
		System.out.println("Please, enter card holder name (as in printed in card)");
		String nameHolder = myScanner.nextLine();
		
		System.out.println("Please, enter the expiration date on the card (MM/YY)");
		String expDate = myScanner.nextLine();
		
		System.out.println("Please, anter the 3 digits of security code on the card");
		int cVV = myScanner.nextInt();
		
		//MEMBERSHIP -CARD
		System.out.println("Please, enter the registration membership number for customer");
		int memb = myScanner.nextInt();
		
		//CREATING USER
		if (type.equals("1")) {
			
			this.myCard = new DebitCreditCard(cardType, card, nameHolder, expDate, cVV);
			this.myMembCard = new MembershipCard(memb, myCard, 0, false);
			this.myUser = new MusicLovers(name, lastName, birthday, myMembCard, myCard);
			System.out.println(myUser);
		}
		
		
		
		
	}
	
	
}

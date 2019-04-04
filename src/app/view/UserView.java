package app.view;

import java.util.Scanner;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;
import customers.PremiunLovers;
import customers.TvLovers;
import customers.VideoLovers;
import titles.BoxSet;
import titles.Movie;
import titles.Title;

public class UserView {

	private Customer myUser;
	private Title myTitle;
	private DebitCreditCard myCard;
	private MembershipCard myMembCard;
	
	public UserView() {
		createUser();
	}
	
	public void showWelcome() {
		System.out.println("Welcome to UltraVision Management System");
	}
	
	public void showMenu() {
		
		System.out.println("Select an option");
		System.out.println("(1) Search Title");
		System.out.println("(2) Search Customer");
		System.out.println("(3) Add new Title");
		System.out.println("(4) Add new Customer");
		System.out.println("(5) Menu for Customer (registered)");
		
	}
	
	public void selectedMenu(int option) {
		
		if (option == 1) {
			//SEARCH TITLE
			
		}
		else if (option == 2) {
			//SEARCH CUSTOMER
			
		}
		else if (option == 3) {
			//ADD TITLE
			
		}
		else if (option == 4) {
			//ADD CUSTOMER
			createUser();
		}
		else if (option == 5) {
			//CUSTOMER MENU
			
		}
		
	}

	public void createUser() {
		
		System.out.println("Please, enter customer name");
		Scanner myScanner = new Scanner(System.in);
		String name = myScanner.nextLine();
				
		System.out.println("Please, enter customer surname");
		String surName = myScanner.nextLine();
		
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
		
		System.out.println("Please, enter card holder name (as is printed on the card)");
		String nameHolder = myScanner.nextLine();
		
		System.out.println("Please, enter the expiration date on the card (MM/YY)");
		String expDate = myScanner.nextLine();
		
		System.out.println("Please, anter the 3 digits of security code on the card");
		int cVV = myScanner.nextInt();
		
		//MEMBERSHIP -CARD
		System.out.println("Please, enter the registration membershipcard number for customer");
		int memb = myScanner.nextInt();
		
		//CREATING USER
		if (type.equals("1")) {
			
			this.myCard = new DebitCreditCard(cardType, card, nameHolder, expDate, cVV);
			this.myMembCard = new MembershipCard(memb, myCard, 0, false);
			this.myUser = new MusicLovers(name, surName, birthday, myMembCard, myCard);
			System.out.println("\nCustomer has been created! \n");
			System.out.println("Account type: "+myUser.getType());
			System.out.println("Full name: "+myUser.getCustName()+" "+myUser.getCustSurname());
			System.out.println("Date of birth: "+myUser.getBirthday());
			System.out.println("Membership number: "+myUser.getMyMemberCard().getMemberNumb());
		}
		else if (type.equals("2")) {
			
			this.myCard = new DebitCreditCard(cardType, card, nameHolder, expDate, cVV);
			this.myMembCard = new MembershipCard(memb, myCard, 0, false);
			this.myUser = new VideoLovers(name, surName, birthday, myMembCard, myCard);
			System.out.println("Customer has been created! \n");
			System.out.println("Account type: "+myUser.getType());
			System.out.println("Full name: "+myUser.getCustName()+" "+myUser.getCustSurname());
			System.out.println("Date of birth: "+myUser.getBirthday());
			System.out.println("Membership number: "+myUser.getMyMemberCard().getMemberNumb());
		}
		
		else if (type.equals("3")) {
			
			this.myCard = new DebitCreditCard(cardType, card, nameHolder, expDate, cVV);
			this.myMembCard = new MembershipCard(memb, myCard, 0, false);
			this.myUser = new TvLovers(name, surName, birthday, myMembCard, myCard);
			System.out.println("Customer has been created! \n");
			System.out.println("Account type: "+myUser.getType());
			System.out.println("Full name: "+myUser.getCustName()+" "+myUser.getCustSurname());
			System.out.println("Date of birth: "+myUser.getBirthday());
			System.out.println("Membership number: "+myUser.getMyMemberCard().getMemberNumb());
		}
		
		else if (type.equals("4")) {
			
			this.myCard = new DebitCreditCard(cardType, card, nameHolder, expDate, cVV);
			this.myMembCard = new MembershipCard(memb, myCard, 0, false);
			this.myUser = new PremiunLovers(name, surName, birthday, myMembCard, myCard);
			System.out.println("Customer has been created! \n");
			System.out.println("Account type: "+myUser.getType());
			System.out.println("Full name: "+myUser.getCustName()+" "+myUser.getCustSurname());
			System.out.println("Date of birth: "+myUser.getBirthday());
			System.out.println("Membership number: "+myUser.getMyMemberCard().getMemberNumb());
		}
		
					
		}
		
		public void addTitle() {
			
			//MENU
			System.out.println("Welcome to add title!");
			System.out.println("Select a option:");
			System.out.println("(1)Music Title (MusicCD or ConcertVideos)");
			System.out.println("(2)Tv Title (Movie or ConcertVideos)");
			Scanner myScanner = new Scanner(System.in);
			int myOption = myScanner.nextInt();
			
			//OPTION MENU
			if (myOption == 1) {
				//MENU FOR MUSIC OR CONCERT VIDEO
				//OPTION MENU
			}
			else if (myOption == 2) {
				createTitle();
			}
			
			//ADD
			
		}

		private void createTitle() {
			
			boolean isDVD, isBlueRay;
			
			System.out.println("Please, enter type of title: ");
			System.out.println("(1) Movie Title ");
			System.out.println("(2) Box Set Title ");
			Scanner myScan = new Scanner(System.in);
			int myOpt = myScan.nextInt();
			
			//MOVIE - BOXSET - ENTER DETAILS
			System.out.print("Please, enter the title name");
			String title = myScan.nextLine();
			System.out.println("Please, enter year of release");
			String year = myScan.nextLine();
			System.out.println("Please, enter genre");
			String genre = myScan.nextLine();
			System.out.println("Please, enter director name");
			String director = myScan.nextLine();
			System.out.print("Please, enter running time in min");
			String runT = myScan.nextLine();
			System.out.println("Please, enter language(s)");
			String lang = myScan.nextLine();
			System.out.println("Please, enter country");
			String country = myScan.nextLine();
			System.out.print("Is it in DVD format available (Yes/No)?");
			String dvd = myScan.nextLine();
			System.out.print("Is it in BlueRay format available (Yes/No)?");
			String blueRay = myScan.nextLine();
			
			//BOOLEAN FOR DVD AND BLUERAY FORMATS
			if (dvd.equals("Yes")) {
				isDVD = true;
			}else {
				isDVD = false;
			}
			
			if (blueRay.equals("Yes")) {
				isBlueRay = true;
			}else {
				isBlueRay = false;
			}
			
			if (myOpt == 1 ) {
				
				//CREATE AN INSTANCE OF MOVIE 
				this.myTitle = new Movie (title, year, genre, director, runT, lang, country, isBlueRay, isDVD);
				
			}else {
				//CEATE AN INSTANCE OF BOX SET
				this.myTitle = new BoxSet (title, year, genre, director, runT, lang, country, isBlueRay, isDVD);
				
			}
			
			myScan.close();
		
		}
		
	}
	
	


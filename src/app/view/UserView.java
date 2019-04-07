package app.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;
import customers.PremiunLovers;
import customers.TvLovers;
import customers.VideoLovers;
import titles.AudioMusic;
import titles.BoxSet;
import titles.ConcertVideos;
import titles.Movie;
import titles.Title;

public class UserView {

	private Customer myUser;
	private Title myTitle;
	private List<Title> myTitles;
	private DebitCreditCard myCard;
	private MembershipCard myMembCard;
		
	public UserView() {
		
		AudioMusic musicOne = new AudioMusic("Best Salsa", "2019", "Salsa", "Mixed", "Los latinos mixed");
		ConcertVideos concertOne = new ConcertVideos("Clasic's Rock", "2008", "Rock", "Heavy", "Mixed", true, false);
		Movie movieOne = new Movie("Harry Potter and the Chamber of Secrets", "Fantacy", "2002", "Chris Columbus", 
		    	"161 min", "English", "United Kingdom", true, true);
		BoxSet bosexOne = new BoxSet("Breaking Bad - Season 1", "Crime drama", "2018", "Stewart A.", "43 - 58 min/epi", 
		     	"English, Spanish", "United States", true, true);
		//createUser();
		//createTvTitle();
		this.myTitles = new ArrayList<Title>();
		this.myTitles.add(bosexOne);
		this.myTitles.add(musicOne);
		this.myTitles.add(concertOne);
		this.myTitles.add(movieOne);
		showWelcome();
		selectedMenu(showMenu());
	}
	
	public void showWelcome() {
		System.out.println("Welcome to UltraVision Management System");
	}
	
	public int showMenu() {
		
		System.out.println("Select an option");
		System.out.println("(1) Search Title");
		System.out.println("(2) Search Customer");
		System.out.println("(3) Add new Title");
		System.out.println("(4) Add new Customer");
		System.out.println("(5) Menu for Customer (registered)");
		Scanner myScan = new Scanner(System.in);
		int tempOpt = myScan.nextInt();
		//myScan.close();
		
		return tempOpt;
	}
	
	public void selectedMenu(int option) {
		
		
		if (option == 1) {
			//SEARCH TITLE
			searchTitle();
			
		}
		else if (option == 2) {
			//SEARCH CUSTOMER
			
		}
		else if (option == 3) {
			//ADD TITLE
			addTitle();
		}
		else if (option == 4) {
			//ADD CUSTOMER
			createUser();
		}
		else if (option == 5) {
			menuCustomer();
			
		}
		
	}

	private void searchTitle() {

		System.out.println("Enter title name: ");
		Scanner myScanner = new Scanner(System.in);
		String tempTitle = myScanner.nextLine();
		
		System.out.println("\nSearching...");
		for (Title t : this.myTitles) {
			if(t.getTitle().contains(tempTitle)) {
				System.out.println(t.getTitle()+" "+t.getGenre());
			}
			
		}
		
	}

	private void menuCustomer() {
		
		System.out.println("Please, enter customer membership number: ");
		Scanner myScanner = new Scanner(System.in);
		String membershipNum = myScanner.nextLine();
		
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
		
		myScanner.close();
							
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
				//MUSIC OR CONCERTVIDEOS TITLES
				createMusicTitle();
			}
			else if (myOption == 2) {
				//MOVIE OR BOX SET TITLES
				createTvTitle();
			}
			
			//ADD
			
			myScanner.close();
		}

		public void createMusicTitle() {
			
			boolean isDVD = false;
			boolean isBlueRay = false;
			
			System.out.println("Please, enter type of Music title: ");
			System.out.println("(1) MusicCD Title ");
			System.out.println("(2) Music Concert Videos Title ");
			Scanner myScanInt = new Scanner(System.in);
			Scanner myScanString = new Scanner(System.in);
			int myOpt = myScanInt.nextInt();
			
			//MUSICCD - CONCERTVIDEOS - ENTER DETAILS
			System.out.println("Please, enter the title name");
			String title = myScanString.nextLine();
			System.out.println("Please, enter year of release");
			String year = myScanString.nextLine();
			System.out.println("Please, enter genre");
			String genre = myScanString.nextLine();
			System.out.println("Please, enter album");
			String album = myScanString.nextLine();
			System.out.println("Please, enter band");
			String band = myScanString.nextLine();
			
			if(myOpt == 2) {
				
				System.out.println("Is it in DVD format available (Yes/No)?");
				String dvd = myScanString.nextLine();
				if (dvd.equals("Yes")) {
					isDVD = true;
				}else {
					isDVD = false;
				}
					
				System.out.println("Is it in BlueRay format available (Yes/No)?");
				String blueRay = myScanString.nextLine();
				if (blueRay.equals("Yes")) {
					isBlueRay = true;
				}else {
					isBlueRay = false;
				}
								
			}
			
			if(myOpt == 1) {
				
				this.myTitle = new AudioMusic(title, year, genre, album, band);
				this.myTitles.add(myTitle);
			}
			else {
				
				this.myTitle = new ConcertVideos(title, year, genre, album, band, isDVD, isBlueRay);
				this.myTitles.add(myTitle);
			}
			
			myScanInt.close();
			myScanString.close();
			
		}

		public void createTvTitle() {
			
			boolean isDVD, isBlueRay;
			
			System.out.println("Please, enter type of Tv title: ");
			System.out.println("(1) Movie Title ");
			System.out.println("(2) Box Set Title ");
			Scanner myScanInt = new Scanner(System.in);
			Scanner myScanString = new Scanner(System.in);
			int myOpt = myScanInt.nextInt();
			
			//MOVIE - BOXSET - ENTER DETAILS
			System.out.println("Please, enter the title name");
			String title = myScanString.nextLine();
			System.out.println("Please, enter year of release");
			String year = myScanString.nextLine();
			System.out.println("Please, enter genre");
			String genre = myScanString.nextLine();
			System.out.println("Please, enter director name");
			String director = myScanString.nextLine();
			System.out.println("Please, enter running time in min");
			String runT = myScanString.nextLine();
			System.out.println("Please, enter language(s)");
			String lang = myScanString.nextLine();
			System.out.println("Please, enter country");
			String country = myScanString.nextLine();
			System.out.println("Is it in DVD format available (Yes/No)?");
			String dvd = myScanString.nextLine();
			System.out.println("Is it in BlueRay format available (Yes/No)?");
			String blueRay = myScanString.nextLine();
			
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
				this.myTitles.add(myTitle);
				//TEST
				System.out.println(myTitle);
				
			}else {
				//CEATE AN INSTANCE OF BOX SET
				this.myTitle = new BoxSet (title, year, genre, director, runT, lang, country, isBlueRay, isDVD);
				this.myTitles.add(myTitle);
				//TEST
				System.out.println(myTitle);
			}
			
			myScanInt.close();
			myScanString.close();
			
		}
		
	}
	
	


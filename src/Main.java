import java.util.ArrayList;
import java.util.List;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.MusicLovers;
import titles.AudioMusic;
import titles.BoxSet;
import titles.ConcertVideos;
import titles.Movie;
import titles.Title;

public class Main {

	public static void main(String[] args) {

		
		DebitCreditCard myCard = new DebitCreditCard("Mastercard", "4444444444444444", "RODOLFO CARVAJAL", "02/25", 777);
		MembershipCard myMembCard = new MembershipCard(1000, myCard, 0, false);
		MusicLovers myLover = new MusicLovers("Rodolfo", "Carvajal", "04/06/1987", myMembCard, myCard);
		System.out.println(myLover);
		
		
		AudioMusic musicOne = new AudioMusic("Best Salsa", "2019", "Salsa", "Mixed", "Los latinos mixed");
		System.out.println(musicOne);
		
		ConcertVideos concertOne = new ConcertVideos("Clasic's Rock", "2008", "Rock", "Heavy", "Mixed", true, false);
		System.out.println(concertOne);
		
		Movie movieOne = new Movie("Harry Potter and the Chamber of Secrets", "Fantacy", "2002", "Chris Columbus", 
				"161 min", "English", "United Kingdom", true, true);
		System.out.println(movieOne);
		
		BoxSet bosexOne = new BoxSet("Breaking Bad - Season 1", "Crime drama", "2018", "Stewart A.", "43 - 58 min/epi", 
				"English, Spanish", "United States", true, true);
		System.out.println(bosexOne);
		
		System.out.println("<<<<<<<<<<<=========================>>>>>>>>>>>>>>>");
		//ADDING TITLES
		List<Title> myTitleList = new ArrayList<Title>();
		myTitleList.add(musicOne);
		myTitleList.add(concertOne);
		myTitleList.add(movieOne);
		myTitleList.add(bosexOne);
		
		for (Title e : myTitleList) {
			System.out.println(e);
		}
		
		
		
	}

}

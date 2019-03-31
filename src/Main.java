import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.MusicLovers;
import titles.AudioMusic;

public class Main {

	public static void main(String[] args) {
		
		DebitCreditCard myCard = new DebitCreditCard("Mastercard", "4444444444444444", "RODOLFO CARVAJAL", "02/25", 777);
		MembershipCard myMembCard = new MembershipCard(1000, myCard, 0, false);
		MusicLovers myLover = new MusicLovers("Rodolfo", "Carvajal", "04/06/1987", myMembCard, myCard);

		System.out.println(myLover);
		
		
		AudioMusic musicOne = new AudioMusic("Best Salsa", "2019", "Salsa", "Mixed", "Los latinos mixed");
		System.out.println(musicOne);
		
		
		
	}

}

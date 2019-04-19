package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.BoxSets;
import customer.interfaces.LiveConcert;
import customer.interfaces.Movies;
import customer.interfaces.MusicCds;

public class PremiunLovers extends Customer implements MusicCds, LiveConcert, Movies, BoxSets{

	private final String TYPE_SUB = "Premiun";
	
	//CONSTRUCTOR - FIELDS
	public PremiunLovers(String custName, String custSurname, String birthday, String email, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, email, myMemberCard, myCard);
		
	}

	@Override
	public String getType() {
		return this.TYPE_SUB;
	}

	@Override
	public String[] getTitles() {
		return null;
	}

	

}

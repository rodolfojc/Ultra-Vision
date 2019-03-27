package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.BoxSets;
import customer.interfaces.LiveConcert;
import customer.interfaces.Movies;
import customer.interfaces.MusicCds;

public class PremiunLovers extends Customer implements MusicCds, LiveConcert, Movies, BoxSets{

	public PremiunLovers(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, myMemberCard, myCard);
		
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}

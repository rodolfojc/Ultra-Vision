package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.LiveConcert;
import customer.interfaces.MusicCds;

public class MusicLovers extends Customer implements MusicCds, LiveConcert {

	//CONSTRUCTOR - FIELDS
	public MusicLovers(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, myMemberCard, myCard);
		
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}

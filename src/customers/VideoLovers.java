package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.Movies;

public class VideoLovers extends Customer implements Movies{

	public VideoLovers(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, myMemberCard, myCard);
		
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}

package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.BoxSets;

public class TvLovers extends Customer implements BoxSets{

	public TvLovers(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, myMemberCard, myCard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}

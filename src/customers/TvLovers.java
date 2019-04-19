package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.BoxSets;

public class TvLovers extends Customer implements BoxSets{

	private final String TYPE_SUB = "TvLovers";
	
	//CONSTRUCTOR - FIELDS
	public TvLovers(String custName, String custSurname, String birthday, String email, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, email, myMemberCard, myCard);
		
	}

	@Override
	public String getType() {
		return this.TYPE_SUB;
	}

	@Override
	public String[] getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

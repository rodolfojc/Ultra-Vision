package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.Movies;

public class VideoLovers extends Customer implements Movies{

	private final String TYPE_SUB = "VideoLovers";
	
	//CONSTRUCTOR - FIELDS
	public VideoLovers(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, myMemberCard, myCard);
		
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

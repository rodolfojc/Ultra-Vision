package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.LiveConcert;
import customer.interfaces.MusicCds;

public class MusicLovers extends Customer implements MusicCds, LiveConcert {

	private final String TYPE_SUB = "MusicLovers";
	
	//CONSTRUCTOR
	public MusicLovers(String custName, String custSurname, String birthday, String email, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		super(custName, custSurname, birthday, email, myMemberCard, myCard);
		
	}
	
	//SUPER CLASS METHOD
	@Override
	public String getType() {
		return this.TYPE_SUB;
	}

	//IMPLEMENTATIONS METHODS
	@Override
	public String getTitles() {
		return "get titles for "+this.TYPE_SUB;
	}
	
	//FOR TESTING
	@Override
	public String toString() {
		return "MusicLovers [TYPE_SUB=" + TYPE_SUB + ", getCustName()=" + getCustName() + ", getCustSurname()="
				+ getCustSurname() + ", getBirthday()=" + getBirthday() + ", getMyMemberCard()=" + getMyMemberCard()
				+ ", getMyCard()=" + getMyCard() + ", getNumbRented()=" + getNumbRented() + ", getId()=" + getId()
				+ "]";
	}
	
	
}

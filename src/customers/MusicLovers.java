package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customer.interfaces.LiveConcert;
import customer.interfaces.MusicCds;

public class MusicLovers extends Customer implements MusicCds, LiveConcert {

	final String TYPE_SUB = "MusicLovers";
	
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

	public String getTYPE_SUB() {
		return TYPE_SUB;
	}

	@Override
	public String toString() {
		return "MusicLovers [TYPE_SUB=" + TYPE_SUB + ", getCustName()=" + getCustName() + ", getCustSurname()="
				+ getCustSurname() + ", getBirthday()=" + getBirthday() + ", getMyMemberCard()=" + getMyMemberCard()
				+ ", getMyCard()=" + getMyCard() + ", getNumbRented()=" + getNumbRented() + ", getId()=" + getId()
				+ "]";
	}
	
	
}

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
		return "TvLovers [TYPE_SUB=" + TYPE_SUB + ", getId()=" + getId() + ", getCustName()=" + getCustName()
				+ ", getCustSurname()=" + getCustSurname() + ", getBirthday()=" + getBirthday() + ", getMyMemberCard()="
				+ getMyMemberCard() + ", getMyCard()=" + getMyCard() + ", getNumbRented()=" + getNumbRented()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
}

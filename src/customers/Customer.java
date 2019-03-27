package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;

public abstract class Customer {

	private String custName;
	private String custSurname;
	private String birthday;
	private MembershipCard myMemberCard;
	private DebitCreditCard myCard;
	
	public Customer(String custName, String custSurname, String birthday, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		this.custName = custName;
		this.custSurname = custSurname;
		this.birthday = birthday;
		this.myMemberCard = myMemberCard;
		this.myCard = myCard;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSurname() {
		return custSurname;
	}

	public void setCustSurname(String custSurname) {
		this.custSurname = custSurname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public MembershipCard getMyMemberCard() {
		return myMemberCard;
	}

	public void setMyMemberCard(MembershipCard myMemberCard) {
		this.myMemberCard = myMemberCard;
	}

	public DebitCreditCard getMyCard() {
		return myCard;
	}

	public void setMyCard(DebitCreditCard myCard) {
		this.myCard = myCard;
	}
	
	
	
	
}

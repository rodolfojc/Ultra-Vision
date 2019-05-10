package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import titles.Title;

//SUPER CLASS FOR CUSTOMERS
public abstract class Customer {

	//ATTRIBUTES
	private String custName;
	private String custSurname;
	private String birthday;
	private String email;
	private int numbRented;
	private int id;
	private MembershipCard myMemberCard;
	private DebitCreditCard myCard;
	
	
	//CONSTRUCTOR
	public Customer(String custName, String custSurname, String birthday, String email, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		this.custName = custName;
		this.custSurname = custSurname;
		this.birthday = birthday;
		this.email = email;
		this.myMemberCard = myMemberCard;
		this.myCard = myCard;
		this.numbRented = 0;
	}

	//GETTERS AND SETTERS
	
	//ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//NAME
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	//SURNAME
	public String getCustSurname() {
		return custSurname;
	}

	public void setCustSurname(String custSurname) {
		this.custSurname = custSurname;
	}

	//DAY OF BIRTH
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	//MEMBERSHIPCARD
	public MembershipCard getMyMemberCard() {
		return myMemberCard;
	}

	public void setMyMemberCard(MembershipCard myMemberCard) {
		this.myMemberCard = myMemberCard;
	}

	//DEBIT - CREDIT CARD
	public DebitCreditCard getMyCard() {
		return myCard;
	}

	public void setMyCard(DebitCreditCard myCard) {
		this.myCard = myCard;
	}

	//NUMBER OF TITLES RENTED
	public int getNumbRented() {
		return numbRented;
	}

	public void setNumbRented(int numbRented) {
		this.numbRented = numbRented;
	}

		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//METHODS
	public String getType() {
		return "Customer";
	}
	
	public void addNumbRented(int i) {
		this.numbRented = this.numbRented + i;
		
	}
	


	

	

	
	
	
	
	
}

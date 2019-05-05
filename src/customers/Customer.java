package customers;

import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import titles.Title;

public abstract class Customer {

	//ATTRIBUTES
	private String custName;
	private String custSurname;
	private String birthday;
	private String email;
	private int numbRented;
	private int id;
	private int[] titleRented;
	private MembershipCard myMemberCard;
	private DebitCreditCard myCard;
	
	
	//COSTRUCTOR - FIELDS
	public Customer(String custName, String custSurname, String birthday, String email, MembershipCard myMemberCard,
			DebitCreditCard myCard) {
		this.custName = custName;
		this.custSurname = custSurname;
		this.birthday = birthday;
		this.email = email;
		this.myMemberCard = myMemberCard;
		this.myCard = myCard;
		this.numbRented = 0;
		this.titleRented = new int[4];
	}

	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	//METHOD
	public String getType() {
		return "Customer";
	}

	public int[] getTitleRented() {
		return titleRented;
	}
	
	public int getTitleRentedInt(int a) {
		return titleRented[a];
	}

	public void setTitleRented(int a, int titleRented) {
		this.titleRented[a] = titleRented;
	}

	

	

	
	
	
	
	
}

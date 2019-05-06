package customer.admin;

public class MembershipCard {

	//ATTRIBUTES FOR MEMBERSHIP CLASS
	private int points;
	private boolean freeRentAllowed;
	private int memberNumb;
	private DebitCreditCard myCard;
	
	//COSTRUCTOR - FIELDS   
	public MembershipCard(DebitCreditCard myCard, int points, boolean freeRentAllowed) {
		this.points = points;
		this.freeRentAllowed = freeRentAllowed;
		this.setMyCard(myCard);
	}

	//METHODS
	
	public void addPoints(int points){
			this.points += points;
			setRentAllowed();
	}
	   
	public boolean availFreeRent(){
	
		if(this.isfreeRentAllowed()){
				this.points -= 100;
				setRentAllowed();
				return true;
			} else {
				return false;
			}
	   }
	   
	   public void setRentAllowed(){
			if (this.points >= 100){
				this.freeRentAllowed = true;
			} else {
				this.freeRentAllowed = false;
			}
	   }
	   
	   public int getPoints() {
			return  points;
    }
	   
	   public boolean isfreeRentAllowed(){
			return freeRentAllowed;
	   
	   }

	public DebitCreditCard getMyCard() {
		return myCard;
	}

	public void setMyCard(DebitCreditCard myCard) {
		this.myCard = myCard;
	}

	public int getMemberNumb() {
		return memberNumb;
	}

	public void setMemberNumb(int memberNumb) {
		this.memberNumb = memberNumb;
	}

	@Override
	public String toString() {
		return "MembershipCard [points=" + points + ", freeRentAllowed=" + freeRentAllowed + ", memberNumb="
				+ memberNumb + ", myCard=" + myCard + "]";
	}
	
	
		
}

package customer.admin;

public class MembershipCard {

	//ATTRIBUTES
	private int points;
	private boolean freeRentAllowed;
	private int memberNumb;
	private DebitCreditCard myCard;
	
	//COSTRUCTOR - FIELDS   
	public MembershipCard(int memberNumb, DebitCreditCard myCard, int points, boolean freeRentAllowed) {
		this.points = points;
		this.freeRentAllowed = freeRentAllowed;
		this.memberNumb = memberNumb;
		this.myCard = myCard;
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
	   
	   private void setRentAllowed(){
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
	
		
}

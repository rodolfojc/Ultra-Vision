package customer.admin;

public class DebitCreditCard {

	//ADDING ATTRIBUTES
	private String cardNumber;
	private String cardHolderName;
	private String expDate;
	private int cvvCode;
	
	//CONTRUCTOR - FIELDS
	public DebitCreditCard(String cardNumber, String cardHolderName, String expDate, int cvvCode) {
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expDate = expDate;
		this.cvvCode = cvvCode;
	}

	//GETTERS AND SETTERS
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(int cvvCode) {
		this.cvvCode = cvvCode;
	}
	
	
	
	
	
	
	
}

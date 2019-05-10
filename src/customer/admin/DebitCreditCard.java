package customer.admin;

public class DebitCreditCard {

	// ATTRIBUTES
	private String cardNumber;
	private String cardHolderName;
	private String expDate;
	private String type;
	private String cvvCode;

	// CONTRUCTOR - FIELDS
	public DebitCreditCard(String type, String cardNumber, String cardHolderName, String expDate, String cvvCode) {
		this.setType(type);
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expDate = expDate;
		this.cvvCode = cvvCode;
	}

	// GETTERS AND SETTERS
	public String getCardNumber() {
		return cardNumber;
	}

	// CARD NUMBER
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	// CARDHOLDER NAME
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	// EXPIRED CARD DATE
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	// CVV CARD CODE
	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// FOR TESTING
	@Override
	public String toString() {
		return "DebitCreditCard [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", expDate="
				+ expDate + ", type=" + type + ", cvvCode=" + cvvCode + "]";
	}

}

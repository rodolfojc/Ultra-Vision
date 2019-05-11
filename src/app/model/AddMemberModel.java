package app.model;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import app.database.Database;
import app.view.AddMemberView;
import customers.Customer;

public class AddMemberModel {

	// ATTRINUTES
	private Database myDB;
	private AddMemberView addMemberView;
	private Customer customer;

	// CONSTRUCTOR
	public AddMemberModel(Database myDB, AddMemberView addMemberView, Customer customer) {

		this.myDB = myDB;
		this.addMemberView = addMemberView;
		this.customer = customer;

	}

	// ADD MEMBER METHOD
	public void AddMember() {

		// FLAG FOR JOPTIONPANE MESSAGES
		boolean flag = true;

		try {

			String query = "INSERT INTO customers (mem_type, cust_name, cust_surname, birthday, email, card_type, "
					+ "card_num, card_holder, exp_day, card_cvv)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// PREPARATION
			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.setString(1, this.customer.getType());
			preparedStmt.setString(2, this.customer.getCustName());
			preparedStmt.setString(3, this.customer.getCustSurname());
			preparedStmt.setString(4, this.customer.getBirthday());
			preparedStmt.setString(5, this.customer.getEmail());
			preparedStmt.setString(6, this.customer.getMyCard().getType());
			preparedStmt.setString(7, this.customer.getMyCard().getCardNumber());
			preparedStmt.setString(8, this.customer.getMyCard().getCardHolderName());
			preparedStmt.setString(9, this.customer.getMyCard().getExpDate());
			preparedStmt.setString(10, this.customer.getMyCard().getCvvCode());

			preparedStmt.execute();
			this.myDB.getConn().close();

		} catch (Exception e) {
			// ERROR MESSAGES
			JOptionPane.showMessageDialog(this.addMemberView, "Ups, there is a problem, try again!");
			flag = false;
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		// NO ERRORS
		if (flag == true)
			JOptionPane.showMessageDialog(this.addMemberView, "The Member: " + this.customer.getCustName() + " "
					+ this.customer.getCustSurname() + " has been ADDED SUCCESSFUL");

	}

}

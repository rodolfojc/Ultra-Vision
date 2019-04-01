package app.view;

import java.util.Scanner;

import customers.Customer;

public class UserView {

	private Customer user;
	
	public UserView() {
		createUser();
	}

	public void createUser() {
		
		System.out.println("Please enter Name");
		Scanner myScanner = new Scanner(System.in);
		String name = myScanner.nextLine();
		System.out.println(name);
		
	}
	
	
}

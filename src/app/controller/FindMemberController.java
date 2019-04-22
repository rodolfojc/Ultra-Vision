package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.database.Database;
import app.model.FindMemberModel;
import app.view.FindMemberView;
import app.view.MainView;
import customers.Customer;

public class FindMemberController implements ActionListener {

	private FindMemberView findMemberView;
	private FindMemberModel findMemberModel;
	private Customer customer;
	private MainView mainView;
	private Database myDB;
	
	public FindMemberController(FindMemberView findMemberView, MainView mainView) {
		
		this.findMemberView = findMemberView;
		this.mainView = mainView;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Search")) {
			
			this.myDB = new Database();
			this.findMemberModel = new FindMemberModel(this.myDB);
			int id = Integer.parseInt(this.findMemberView.getFindId().getText());
			
			if(this.findMemberModel.checkId(id)) {
				
				this.customer = this.findMemberModel.findId(id);
				this.findMemberView.setUser(id + ": "+this.customer.getCustName()+" "+this.customer.getCustSurname());
				this.findMemberView.setButtonFlag(false);
				this.findMemberView.UpdateFrame();
				
			}else {
				this.findMemberView.setUser("Member " + id + " is not valid, try again!");
				this.findMemberView.setButtonFlag(true);
				this.findMemberView.UpdateFrame();
			}
			
			
		}
		
		if (e.getActionCommand().equals("Go")) {
			
			
			
			
		}
		
		
		

	}

}

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
			this.customer = this.findMemberModel.findId(Integer.parseInt(this.findMemberView.getFindId().getText()));
			this.findMemberView.setUser(this.customer.getCustName()+" "+this.customer.getCustSurname());
			//this.findMemberView.getGoBtn().setEnabled(true);
			this.findMemberView.setButtonFlag(false);
			this.findMemberView.UpdateFrame();
			
		}

	}

}

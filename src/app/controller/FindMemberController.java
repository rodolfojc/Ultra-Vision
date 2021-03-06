package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.database.Database;
import app.model.FindMemberModel;
import app.view.FindMemberView;
import app.view.MainView;
import app.view.MemberMenuView;
import customers.Customer;

public class FindMemberController implements ActionListener {

	// ATTRIBUTES
	private FindMemberView findMemberView;
	private FindMemberModel findMemberModel;
	private Customer customer;
	private MainView mainView;
	private Database myDB;

	// CONSTRUCOR
	public FindMemberController(FindMemberView findMemberView, MainView mainView) {

		this.findMemberView = findMemberView;
		this.mainView = mainView;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// SEARCH MEMBER
		if (e.getActionCommand().equals("Search")) {

			this.myDB = new Database();
			this.findMemberModel = new FindMemberModel(this.myDB);

			int id = 0;

			boolean flag = false;

			try {
				id = Integer.parseInt(this.findMemberView.getFindId().getText());
			} catch (NumberFormatException e1) {

				JOptionPane.showMessageDialog(this.findMemberView,
						this.findMemberView.addLabelOpt("The entry is not valid, try again"), "ID - Error",
						JOptionPane.ERROR_MESSAGE);
				flag = true;
			}

			if (!flag) {
				if (this.findMemberModel.checkId(id)) {

					this.customer = this.findMemberModel.findId(id);
					this.findMemberView
							.setUser(id + ": " + this.customer.getCustName() + " " + this.customer.getCustSurname());
					this.findMemberView.setButtonFlag(false);
					this.findMemberView.UpdateFrame();

				} else {
					this.findMemberView.setUser("Member " + id + " is not valid, try again!");
					this.findMemberView.setButtonFlag(true);
					this.findMemberView.UpdateFrame();
				}
			}
		}

		// GO AFTER MEMBER IS FOUND
		if (e.getActionCommand().equals("Go")) {

			new MemberMenuView("Member Manager", 1400, 1000, true, this.mainView, this.customer);
			this.findMemberView.dispose();

		}

		// GO BACK TO MAIN MENU
		if (e.getActionCommand().equals("Go back")) {

			this.findMemberView.dispose();
			this.mainView.setVisible(true);

		}

	}

}

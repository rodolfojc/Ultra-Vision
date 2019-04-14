package app.view;

import javax.swing.JPanel;

import app.controller.AddMemberController;

public class AddMemberView extends GuiView {

	AddMemberController myController;
	
	public AddMemberView(String name, int width, int height, boolean Resizable, AddMemberController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		this.setGrid(3, 0,this.panel);
		
		//PERSONAL DETAILS
		JPanel left = new JPanel();
		this.setGrid(1, 0, left);
		this.addLabel("Name", left);
		this.addTextField(20, left);
		this.addLabel("Surname", left);
		this.addTextField(20, left);
		this.addLabel("Birthday", left);
		this.addTextField(20, left);
		
		//PAYMENT
		
	}

}

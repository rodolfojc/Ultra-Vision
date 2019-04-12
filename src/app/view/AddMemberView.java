package app.view;

import app.controller.AddMemberController;

public class AddMemberView extends GuiView {

	AddMemberController myController;
	
	public AddMemberView(String name, int width, int height, boolean Resizable, AddMemberController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		
		
	}

}

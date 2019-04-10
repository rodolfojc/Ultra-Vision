package app.view;

import app.controller.AddTitleController;

public class AddTitleView extends GuiView {

	AddTitleController myController;
	
	public AddTitleView(String name, int width, int height, boolean Resizable, AddTitleController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		
	}

}

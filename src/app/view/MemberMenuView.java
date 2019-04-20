package app.view;

import app.controller.MemberMenuController;

public class MemberMenuView extends GuiView {

	private MemberMenuController myController;
	
	public MemberMenuView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		
		this.myController = new MemberMenuController(this, mainView);
		setFrame();
		
	}

	public void setFrame() {
		
		
	}

}

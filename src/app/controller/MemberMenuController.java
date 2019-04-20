package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;
import app.view.MemberMenuView;

public class MemberMenuController implements ActionListener{

	private MemberMenuView memberMenuView;
	private MainView mainView;
	
	public MemberMenuController(MemberMenuView memberMenuView, MainView mainView) {
		
		this.memberMenuView = memberMenuView;
		this.mainView = mainView;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}

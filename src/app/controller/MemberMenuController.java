package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.view.MainView;
import app.view.MemberMenuView;

public class MemberMenuController implements ActionListener, ListSelectionListener{

	private MemberMenuView memberMenuView;
	private MainView mainView;
	
	public MemberMenuController(MemberMenuView memberMenuView, MainView mainView) {
		
		this.memberMenuView = memberMenuView;
		this.mainView = mainView;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

package app.view;


import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.Controller;
import app.controller.MainViewController;

public class MainView extends GuiView {
	
		MainViewController myController;

	public MainView(String name, int width, int height, boolean Resizable, MainViewController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}
	
	public void setFrame() {
		
		this.setGrid(10, 1, this.panel);
		
		JLabel myLabel = this.addLabel("MAIN MENU", this.panel);
		this.addLabel("", this.panel);
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Serif", Font.BOLD, 45));
		JButton searchTitle = this.addButton("Search Title", this.panel);
		searchTitle.setFont(new Font("Serif", Font.PLAIN, 28));
		searchTitle.setActionCommand("Search Title");
		searchTitle.addActionListener(myController);
		JButton searchMember = this.addButton("Search Member", this.panel);
		searchMember.setFont(new Font("Serif", Font.PLAIN, 28));
		searchMember.setActionCommand("Search Member");
		searchMember.addActionListener(myController);
		JButton addTitle = this.addButton("Add Title", this.panel);
		addTitle.setFont(new Font("Serif", Font.PLAIN, 28));
		addTitle.setActionCommand("Add Title");
		addTitle.addActionListener(myController);
		JButton addMember = this.addButton("Add Member", this.panel);
		addMember.setFont(new Font("Serif", Font.PLAIN, 28));
		addMember.setActionCommand("Add Member");
		addMember.addActionListener(myController);
		JButton menuMember = this.addButton("Menu for Members", this.panel);
		menuMember.setFont(new Font("Serif", Font.PLAIN, 28));
		menuMember.setActionCommand("Menu Members");
		menuMember.addActionListener(myController);
		this.addLabel("", this.panel);
		this.addLabel("", this.panel);
		JButton exit = this.addButton("EXIT", this.panel);
		exit.setFont(new Font("Serif", Font.PLAIN, 28));
		exit.setActionCommand("EXIT");
		exit.addActionListener(myController);
		this.panel.setBorder(new EmptyBorder(new Insets(25, 60, 45, 60)));
		
		this.repaint();
		this.validate();
	}

}

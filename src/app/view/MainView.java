package app.view;


import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.Controller;
import app.controller.MainViewController;

public class MainView extends GuiView {
	
		private MainViewController myController;

	public MainView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		this.myController = new MainViewController(this);
		setFrame();
	}
	
	@Override
	public JButton addButton(String name, JPanel panel) {
		JButton myButton= new JButton(name);
		myButton.setFont(new Font("Serif", Font.PLAIN, 28));
		panel.add(myButton);
		return myButton;
	}


	public void setFrame() {
		
		this.setGrid(15, 1, this.panel);
		
		JLabel myLabel = this.addLabel("MAIN MENU", this.panel);
		this.addLabel("", this.panel);
		this.addLabel("", this.panel);
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Serif", Font.BOLD, 45));
		JButton searchTitle = this.addButton("Search Title", this.panel);
		//JButton searchTitle = this.addButtonAll("Search Title", "Search Title", this.panel, this.myController);
		searchTitle.setActionCommand("Search Title");
		searchTitle.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton searchMember = this.addButton("Search Member", this.panel);
		searchMember.setActionCommand("Search Customer");
		searchMember.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton addTitle = this.addButton("Add Title", this.panel);
		addTitle.setActionCommand("Add Title");
		addTitle.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton addMember = this.addButton("Add Member", this.panel);
		addMember.setActionCommand("Add Member");
		addMember.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton menuMember = this.addButton("Menu for Members", this.panel);
		menuMember.setActionCommand("Menu Members");
		menuMember.addActionListener(myController);
		this.addLabel("", this.panel);
		this.addLabel("", this.panel);
		JButton exit = this.addButton("EXIT", this.panel);
		exit.setActionCommand("EXIT");
		exit.addActionListener(myController);
		this.panel.setBorder(new EmptyBorder(new Insets(25, 200, 100, 200)));
		
		this.repaint();
		this.validate();
	}

}

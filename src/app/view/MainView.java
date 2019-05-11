package app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.MainViewController;

public class MainView extends GuiView {
	
	//CONTROLLER
	private MainViewController myController;

	//CONSTRUCTOR
	public MainView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		this.myController = new MainViewController(this);
		setFrame();
	}
	
	@Override
	public JButton addButton(String name, JPanel panel) {
		JButton myButton= new JButton(name);
		//myButton.setFont(new Font("SERIF", Font.PLAIN, 28));
		myButton.setBackground(new Color(59, 89, 182));
		myButton.setForeground(Color.WHITE);
		myButton.setFocusPainted(false);
		myButton.setFont(new Font("Tahoma", Font.BOLD, 28));
		panel.add(myButton);
		return myButton;
	}

	//SET FRAME
	public void setFrame() {
		
		this.setGrid(17, 1, this.panel);
		
		JLabel mainLabel = this.addLabel("Ultra-Vision", this.panel);
		mainLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.addLabel("", this.panel);
		JLabel myLabel = this.addLabel("MAIN MENU", this.panel);
		this.addLabel("", this.panel);
		this.addLabel("", this.panel);
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		JButton searchTitle = this.addButton("Search - Title", this.panel);
		searchTitle.setActionCommand("Search Title");
		searchTitle.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton searchMember = this.addButton("Search - Member", this.panel);
		searchMember.setActionCommand("Search Customer");
		searchMember.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton addTitle = this.addButton("Add - Title", this.panel);
		addTitle.setActionCommand("Add Title");
		addTitle.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton addMember = this.addButton("Add - Member", this.panel);
		addMember.setActionCommand("Add Member");
		addMember.addActionListener(myController);
		this.addLabel("", this.panel);
		JButton menuMember = this.addButton("Menu - Members", this.panel);
		menuMember.setActionCommand("Menu Members");
		menuMember.addActionListener(myController);
		this.addLabel("", this.panel);
		this.addLabel("", this.panel);
		JButton exit = this.addButton("EXIT", this.panel);
		exit.setActionCommand("EXIT");
		exit.addActionListener(myController);
		this.panel.setBorder(new EmptyBorder(new Insets(50, 200, 100, 200)));
		
		this.repaint();
		this.validate();
	}

}

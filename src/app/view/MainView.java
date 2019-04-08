package app.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainView extends GuiView {

	public MainView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		setFrame();
	}
	
	public void setFrame() {
		
		this.setGrid(6, 1, this.panel);
		
		//JPanel center = new JPanel();
		//this.setBox(center, 1);
		JLabel myLabel = this.addLabel("MAIN MENU", this.panel);
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font("Serif", Font.PLAIN, 45));
		JButton searchTitle = this.addButton("Search Title", this.panel);
		searchTitle.setFont(new Font("Serif", Font.PLAIN, 28));
		JButton searchMember = this.addButton("Search Member", this.panel);
		searchMember.setFont(new Font("Serif", Font.PLAIN, 28));
		JButton addTitle = this.addButton("Add Title", this.panel);
		addTitle.setFont(new Font("Serif", Font.PLAIN, 28));
		JButton addMember = this.addButton("Add Member", this.panel);
		addMember.setFont(new Font("Serif", Font.PLAIN, 28));
		JButton menuMember = this.addButton("Menu for Members", this.panel);
		menuMember.setFont(new Font("Serif", Font.PLAIN, 28));
		this.panel.setBorder(new EmptyBorder(new Insets(25, 25, 25, 25)));
		//this.panel.add(center);
		
	
		this.repaint();
		this.validate();
	}

}
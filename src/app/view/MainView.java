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
		this.addButton("Search Title", this.panel);
		this.addButton("Search Member", this.panel);
		this.addButton("Add title", this.panel);
		this.addButton("Add Member", this.panel);
		this.addButton("Menu for Members", this.panel);
		this.panel.setBorder(new EmptyBorder(new Insets(25, 25, 25, 25)));
		//this.panel.add(center);
		
	
		this.repaint();
		this.validate();
	}

}

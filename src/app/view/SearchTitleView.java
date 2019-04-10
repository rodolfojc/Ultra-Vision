package app.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.Controller;

public class SearchTitleView extends GuiView {

	Controller myController;
	
	public SearchTitleView(String name, int width, int height, boolean Resizable, Controller myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		String[][] data = new String[50][50];
		String[] columns = {"ID", "Title"};
		
		this.setBox(this.panel,1);
		
		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Title Name ", titleTop);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		this.addTextField(20, top);
		this.addButton("Search", top);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));
		
		JPanel center = new JPanel();
		this.addTableS(0, data, columns, center, "Titles");
		
		this.panel.add(titleTop);
		this.panel.add(top);
		this.panel.add(center);
				
		this.repaint();
		this.validate();
		
	}

}

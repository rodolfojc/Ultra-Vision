package app.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import app.controller.Controller;

public class SearchTitle extends GuiView {

	Controller myController;
	
	public SearchTitle(String name, int width, int height, boolean Resizable, Controller myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		String[][] data = new String[50][50];
		String[] columns = {"ID", "Title"};
		
		this.setBox(this.panel,1);
		
		JPanel top = new JPanel();
		this.addLabel("Title name: ", top);
		this.addTextField(20, top);
		this.addButton("Search", top);
		
		JPanel center = new JPanel();
		this.addTableS(0, data, columns, center, "Titles");
		
		this.panel.add(top);
		this.panel.add(center);
		//this.panel.add(top, BorderLayout.LINE_START);
		//this.panel.add(center, BorderLayout.LINE_END);
		
		this.repaint();
		this.validate();
		
	}

}

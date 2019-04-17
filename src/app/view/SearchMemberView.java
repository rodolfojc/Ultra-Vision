package app.view;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.SearchMemberController;

public class SearchMemberView extends GuiView{

	SearchMemberController myController;
	
	public SearchMemberView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		this.myController = new SearchMemberController(this);
		setFrame();
	}

	private void setFrame() {
		
		String[][] data = new String[50][50];
		String[] columns = {"Memberchip", "Customer", "Account Type"};
		
		this.setBox(this.panel,1);
		
		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Customer (by Name)", titleTop);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		this.addTextField(20, top);
		this.addButton("Search", top);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));
		
		JPanel center = new JPanel();
		this.addTableS(0, data, columns, center, "Customers");
		
		this.addButton("Go back", center);
		
		this.panel.add(titleTop);
		this.panel.add(top);
		this.panel.add(center);
		
		this.repaint();
		this.validate();
		
	}
	
	
	
	
}

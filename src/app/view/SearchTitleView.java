package app.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import app.controller.SearchTitleController;
import app.database.Database;
import app.model.SearchMemberModel;
import app.model.SearchTitleModel;

public class SearchTitleView extends GuiView {

	//ATTRIBUTES
	private JButton search;
	private JTextField searchTitle;
	
	//CONTROLLER
	private SearchTitleController myController;
	private SearchTitleModel myModel;
	
	//DATA - DATABASE
	private Database myBD;
	private String[][] data;

	
	
	public SearchTitleView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new SearchTitleController(this, mainView);
		getStartingData();
		setFrame();
	}
	
	public void getStartingData() {
		
	String query = "SELECT id, type, title_name, year_rel FROM titles";
	this.myBD = new Database();
	this.myModel = new SearchTitleModel(this.myBD, this);
	this.myModel.getData(query);
	}
	
	//GETTERS AND SETTERS
	public JTextField getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(JTextField searchTitle) {
		this.searchTitle = searchTitle;
	}
	
	public String getDataStr(int a, int b) {
		return this.data[a][b];
	}

	public void setData(String[][] data) {
		this.data = Arrays.copyOf(data, data.length);;
	}
	
		
	public void setFrame() {
		
		String[] columns = {"ID", "Type", "Title", "Year"};
		
		this.setBox(this.panel,1);
		
		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Title (by name) ", titleTop);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		this.setSearchTitle(this.addTextField(20, top));
		this.search = this.addButtonAll("Search", "Search", top, myController);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));
		
		JPanel center = new JPanel();
		this.addTableS(0, this.data, columns, center, "Titles");
		this.addButtonAll("Go back", "Go back", center, myController);
		
		this.panel.add(titleTop);
		this.panel.add(top);
		this.panel.add(center);
				
		this.repaint();
		this.validate();
		
	}

	public void UpdateFrame() {
		this.panel.removeAll();
		setFrame();
	}

}

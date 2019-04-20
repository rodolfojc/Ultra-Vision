package app.view;

import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import app.controller.SearchMemberController;
import app.database.Database;
import app.model.SearchMemberModel;

public class SearchMemberView extends GuiView{

	//ATTRIBUTES
	private JButton search;
	private JTextField searchName;
	private JButton goBack;
		
	//DATA - DATABASE
	private Database myBD;
	private String[][] data;
	
	//CONTROLLER
	private SearchMemberController myController;
	
	//MODEL
	private SearchMemberModel myModel;
	

	//CONTRUCTOR	
	public SearchMemberView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new SearchMemberController(this, mainView);
		this.data = new String[1000][4];
		getStartingData();
		setFrame();
	}
	
	
	private void getStartingData() {
		
		String query = "SELECT mem_numb, mem_type, cust_name, cust_surname FROM customers";
		this.myBD = new Database();
		this.myModel = new SearchMemberModel(this.myBD, this);
		this.myModel.getData(query);
	}


	//GETTER AND SETTER
	public String[][] getData() {
		return data;
	}
	
	public String getDataStr(int a, int b) {
		return this.data[a][b];
	}

	public void setData(String[][] data) {
		this.data = Arrays.copyOf(data, data.length);;
	}
	
	public JTextField getSearchName() {
		return searchName;
	}


	public void setSearchName(JTextField searchName) {
		this.searchName = searchName;
	}
	
	private void setFrame() {
		
		
		String[] columns = {"Memberchip", "Account Type", "Name", "Surname"};
		
		this.setBox(this.panel,1);
		
		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Customer (by Name)", titleTop);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		this.setSearchName(this.addTextField(20, top));
		this.search = this.addButtonAll("Search","Search", top, myController);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));
		
		JPanel center = new JPanel();
		this.addTableS(0, this.data, columns, center, "Customers");
		//this.myTable[0].setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.myTable[0].getTableHeader().setReorderingAllowed(false);
		this.myTable[0].getTableHeader().setEnabled(false);
		this.myTable[0].getColumnModel().getColumn(0).setPreferredWidth(30);
		this.myTable[0].setEnabled(false);
		
		;		
		this.goBack = this.addButtonAll("Go back", "Go back", center, myController);
		
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

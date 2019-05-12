package app.view;

import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import app.controller.SearchMemberController;
import app.database.Database;
import app.model.SearchMemberModel;

public class SearchMemberView extends GuiView {

	// ATTRIBUTES
	private JButton search;
	private JTextField searchID;
	private JButton goBack;

	// DATA - DATABASE
	private Database myBD;
	private String[][] data;

	// CONTROLLER
	private SearchMemberController myController;

	// MODEL
	private SearchMemberModel myModel;

	// CONTRUCTOR
	public SearchMemberView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new SearchMemberController(this, mainView);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getStartingData();
		setFrame();
	}

	// LOAD DATA
	public void getStartingData() {

		String query = "SELECT mem_numb, mem_type, cust_name, cust_surname FROM customers";
		this.myBD = new Database();
		this.myModel = new SearchMemberModel(this.myBD, this);
		this.myModel.getData(query);
	}

	// GETTER AND SETTER
	public String[][] getData() {
		return data;
	}

	public String getDataStr(int a, int b) {
		return this.data[a][b];
	}

	public void setData(String[][] data) {
		this.data = Arrays.copyOf(data, data.length);
		;
	}

	public JTextField getSearchName() {
		return searchID;
	}

	public void setSearchName(JTextField searchName) {
		this.searchID = searchName;
	}

	// SET FRAME
	public void setFrame() {

		String[] columns = { "Memberchip", "Account Type", "Name", "Surname" };

		this.setBox(this.panel, 1);

		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Members Manager", titleTop);
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		this.addLabel("By Name ", top);
		this.setSearchName(this.addTextField(20, top));
		this.search = this.addButtonAll("Search", "Search", top, myController);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));

		this.panel.add(titleTop);
		this.panel.add(top);

		JPanel tablePanel = new JPanel();
		this.setGrid(1, 0, tablePanel);
		this.addTableS(0, this.data, columns, tablePanel, "Members");
		this.myTable[0].getTableHeader().setReorderingAllowed(false);
		this.myTable[0].getTableHeader().setEnabled(false);
		this.myTable[0].getColumnModel().getColumn(0).setPreferredWidth(30);
		this.myTable[0].setEnabled(false);
		JPanel btnPanel = new JPanel();
		this.goBack = this.addButtonAll("Go back", "Go back", btnPanel, myController);
		this.panel.add(tablePanel);
		this.panel.add(btnPanel);
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 100, 65)));

		this.repaint();
		this.validate();

	}

	public void UpdateFrame() {
		this.panel.removeAll();
		setFrame();
	}

}

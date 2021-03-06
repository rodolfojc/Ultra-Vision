package app.view;

import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import app.controller.SearchTitleController;
import app.database.Database;
import app.model.SearchTitleModel;

public class SearchTitleView extends GuiView {

	// ATTRIBUTES
	private JButton search;
	private JTextField searchTitle;
	private boolean memberFlag = false;
	private JButton rentFreeBtn;

	// CONTROLLER
	private SearchTitleController myController;
	private SearchTitleModel myModel;

	// DATA - DATABASE
	private Database myBD;
	private String[][] data;
	private ListSelectionModel myTableModel;
	private int selectedRow;

	// CONSTRUCTORS
	public SearchTitleView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new SearchTitleController(this, mainView);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getStartingData();
		setFrame();
	}

	public SearchTitleView(String name, int width, int height, boolean resizable, MemberMenuView memberMenuView) {
		super(name, width, height, resizable);
		this.myController = new SearchTitleController(this, memberMenuView);
		this.memberFlag = true;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getStartingData();
		setFrame();
	}

	// LOAD DATE
	public void getStartingData() {

		String query = "SELECT * FROM titles";
		this.myBD = new Database();
		this.myModel = new SearchTitleModel(this.myBD, this);
		this.myModel.getData(query);
	}

	// GETTERS AND SETTERS

	public String getTitlesStr(int a, int b) {
		return this.data[a][b];
	}

	public JButton getRentFreeBtn() {
		return rentFreeBtn;
	}

	public JTextField getSearchTitle() {
		return searchTitle;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public ListSelectionModel getMyTableModel() {
		return myTableModel;
	}

	public void setMyTableModel(ListSelectionModel myTableModel) {
		this.myTableModel = myTableModel;
	}

	public void setSearchTitle(JTextField searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getDataStr(int a, int b) {
		return this.data[a][b];
	}

	public void setData(String[][] data) {
		this.data = Arrays.copyOf(data, data.length);
		;
	}

	// SET FRAME
	public void setFrame() {

		String[] columnsNameTitles = { "Type", "ID", "Title", "Year", "Album", "Band", "Genre", "Director",
				"Running Time", "Languages", "Country", "CD", "DVD", "BlueRay" };

		this.setBox(this.panel, 1);

		JPanel titleTop = new JPanel();
		JPanel top = new JPanel();
		JLabel title = this.addLabel("Titles Manager ", titleTop);
		title.setFont(new Font("Tahoma", Font.BOLD, 45));
		this.addLabel("By name: ", top);
		this.setSearchTitle(this.addTextField(20, top));
		this.search = this.addButtonAll("Search", "Search", top, myController);
		titleTop.setBorder(new EmptyBorder(new Insets(40, 0, 0, 0)));

		this.panel.add(titleTop);
		this.panel.add(top);

		JPanel tablePanel = new JPanel();
		JPanel btnPanel = new JPanel();
		this.setGrid(1, 0, tablePanel);

		if (!this.memberFlag) {
			this.addTableS(0, this.data, columnsNameTitles, tablePanel, "Titles");
			this.myTable[0].getTableHeader().setReorderingAllowed(false);
			this.myTable[0].getColumnModel().getColumn(0).setPreferredWidth(30);
			this.myTable[0].setEnabled(false);
			this.addButtonAll("Go back", "Go back", btnPanel, myController);

		} else {
			this.addTableS(0, this.data, columnsNameTitles, tablePanel, "Titles");
			this.myTableModel = this.myTable[0].getSelectionModel();
			this.myTableModel.addListSelectionListener(this.myController);
			this.rentFreeBtn = this.addButtonAll("Rent", "Rent", btnPanel, myController);
			this.rentFreeBtn.setEnabled(false);
			this.addButtonAll("Go back", "Go back", btnPanel, myController);

		}

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

package app.view;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.FindMemberController;

public class FindMemberView extends GuiView {

	private FindMemberController myController;
	
	private JButton goBtn;
	private JTextField findId;
	private JTextField resultField;
	private boolean buttonFlag = true;
	private String user = "Searching Member...";
	
	public FindMemberView(String name, int width, int height, boolean Resizable, MainView mainView) {
		super(name, width, height, Resizable);
		this.myController = new FindMemberController(this, mainView);
		setFrame();
	}
	
	
	//SETTER AND GETTERS
		
	public JTextField getResultField() {
		return resultField;
	}

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public boolean isButtonFlag() {
		return buttonFlag;
	}


	public void setButtonFlag(boolean buttonFlag) {
		this.buttonFlag = buttonFlag;
	}


	public JButton getGoBtn() {
		return goBtn;
	}


	public void setGoBtn(JButton goBtn) {
		this.goBtn = goBtn;
	}


	public JTextField getFindId() {
		return findId;
	}

	public void setFindId(JTextField findId) {
		this.findId = findId;
	}


	public void setResultField(JTextField resultField) {
		this.resultField = resultField;
	}



	public void setFrame() {
		
		this.setGrid(6, 0, this.panel);
		
		JPanel search = new JPanel();
		this.setGrid(2, 0, search);
		JPanel result = new JPanel();
		this.setGrid(2, 0, result);
		
		JLabel title = this.addLabel("Membership Number", this.panel);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		this.findId = this.addTextField(20, search);
		this.addButtonAll("Search", "Search", search, this.myController);
		this.panel.add(search);
		this.resultField = this.addTextField(20, result);
		this.resultField.setText(this.user);
		this.resultField.setEditable(false);
		this.addLabel("", this.panel);
		this.goBtn = this.addButtonAll("Go", "Go", result, this.myController);
		if (this.buttonFlag) {this.goBtn.setEnabled(false);};
		this.panel.add(result);
		this.addLabel("", this.panel);
		this.addButtonAll("Go back", "Go back", this.panel, this.myController);
		this.panel.setBorder(new EmptyBorder(new Insets(20, 45, 45, 45)));
		
		this.repaint();
		this.validate();
		
		
	}
	
	public void UpdateFrame() {
		this.panel.removeAll();
		setFrame();
	}

}

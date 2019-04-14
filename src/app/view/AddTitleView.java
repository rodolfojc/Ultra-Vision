package app.view;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.controller.AddTitleController;

public class AddTitleView extends GuiView {

	AddTitleController myController;
	
	public AddTitleView(String name, int width, int height, boolean Resizable, AddTitleController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}
	
	

	@Override
	public JLabel addLabel(String text, JPanel panel) {
		JLabel myLabel = new JLabel(text);
		myLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		panel.add(myLabel);
		return myLabel;
	}
	
	@Override
	public JTextField addTextField(int a, JPanel panel) {
		
		JTextField myText = new JTextField(a);
		myText.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(myText);
		return myText;
	}
		

	@Override
	public JComboBox addComboB(String[] options, JPanel panel) {
		
		JComboBox myComboBox = new JComboBox(options);
		myComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(myComboBox);
		return myComboBox;
	}

	private void setFrame() {
		
		this.setGrid(0, 2, this.panel);
		String[] myOpts = {"MusicCD", "Video Concert"};
		String[] myOptsTwo = {"TV/Boxset", "Movie"};
		String[] format = {"CD"};
		String[] yesOrNo = {"Yes","No","N/A"};
		
		JPanel type = new JPanel();
		this.setGrid(20, 0, type);
		JLabel musicTitle = this.addLabel("Music (Type)", type);
		musicTitle.setFont(new Font("Serif", Font.BOLD, 24));
		musicTitle.setHorizontalAlignment(SwingConstants.CENTER);
		JComboBox myBox = this.addComboB(myOpts, type);
		this.addLabel("Title name", type);
		this.addTextField(20, type);
		this.addLabel("Band", type);
		this.addTextField(20, type);
		this.addLabel("Album", type);
		this.addTextField(20, type);
		this.addLabel("Year release", type);
		this.addTextField(20, type);
		this.addLabel("Genre", type);
		this.addTextField(20, type);
		this.addLabel("", type);
		this.addLabel("", type);
		this.addLabel("Format", type);
		JPanel formatPanelOne = new JPanel();
		this.addLabel("CD", formatPanelOne);
		JComboBox myBoxTwo = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("     (for Video Concert) ", formatPanelOne);
		this.addLabel("DVD ", formatPanelOne);
		JComboBox myBoxSix = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("Blue-Ray ", formatPanelOne);
		JComboBox myBoxSeven = this.addComboB(yesOrNo, formatPanelOne);
		type.add(formatPanelOne);
		this.addLabel("", type);
		this.addLabel("", type);
		JButton addTitle = this.addButton("Add", type);
		this.addLabel("", type);
		type.setBorder(new EmptyBorder(new Insets(0, 0, 0, 25)));
		
		
		JPanel typeTwo = new JPanel();
		this.setGrid(20, 0, typeTwo);
		JLabel tvType = this.addLabel("TV (Type)", typeTwo);
		tvType.setFont(new Font("Serif", Font.BOLD, 24));
		tvType.setHorizontalAlignment(SwingConstants.CENTER);
		JComboBox myBoxThree = this.addComboB(myOptsTwo, typeTwo);
		this.addLabel("Title name", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Year release", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Genre", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Director", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Running time", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Country", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Format", typeTwo);
		JPanel formatPanelTwo = new JPanel();
		this.addLabel("DVD ", formatPanelTwo);
		JComboBox myBoxFour = this.addComboB(yesOrNo, formatPanelTwo);
		this.addLabel("Blue-Ray ", formatPanelTwo);
		JComboBox myBoxFive = this.addComboB(yesOrNo, formatPanelTwo);
		typeTwo.add(formatPanelTwo);
		this.addLabel("", typeTwo);
		this.addLabel("", typeTwo);
		JButton addTitleTwo = this.addButton("Add", typeTwo);
		this.addLabel("", typeTwo);
		typeTwo.setBorder(new EmptyBorder(new Insets(0, 25, 0, 0)));
		
		this.panel.add(type);
		this.panel.add(typeTwo);
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 45, 65)));
		
		this.validate();
		this.repaint();
		
		
		
	}

}

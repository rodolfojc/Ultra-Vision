package app.view;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.AddTitleController;

public class AddTitleView extends GuiView {

	AddTitleController myController;
	
	public AddTitleView(String name, int width, int height, boolean Resizable, AddTitleController myController) {
		super(name, width, height, Resizable);
		this.myController = myController;
		setFrame();
	}

	private void setFrame() {
		
		this.setGrid(0, 2, this.panel);
		String[] myOpts = {"MusicCD", "Video Concert"};
		String[] myOptsTwo = {"TV/Boxset", "Movie"};
		String[] format = {"CD"};
		String[] yesOrNo = {"Yes","No","N/A"};
		
		JPanel type = new JPanel();
		this.setGrid(16, 0, type);
		
		this.addLabel("Select Type", type);
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
		this.addLabel("Format", type);
		JPanel formatPanelOne = new JPanel();
		this.addLabel("CD", formatPanelOne);
		JComboBox myBoxTwo = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("(for Video Concert, )", formatPanelOne);
		this.addLabel("DVD", formatPanelOne);
		JComboBox myBoxSix = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("Blue-Ray", formatPanelOne);
		JComboBox myBoxSeven = this.addComboB(yesOrNo, formatPanelOne);
		type.add(formatPanelOne);
		
		JPanel typeTwo = new JPanel();
		this.setGrid(16, 0, typeTwo);
		
		this.addLabel("Select Type", typeTwo);
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
		this.addLabel("DVD", formatPanelTwo);
		JComboBox myBoxFour = this.addComboB(yesOrNo, formatPanelTwo);
		this.addLabel("Blue-Ray", formatPanelTwo);
		JComboBox myBoxFive = this.addComboB(yesOrNo, formatPanelTwo);
		typeTwo.add(formatPanelTwo);
		
		this.panel.add(type);
		this.panel.add(typeTwo);
		this.panel.setBorder(new EmptyBorder(new Insets(25, 60, 45, 60)));
		
		this.validate();
		this.repaint();
		
		
		
	}

}

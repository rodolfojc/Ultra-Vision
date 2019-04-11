package app.view;

import javax.swing.JComboBox;
import javax.swing.JPanel;

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
		String[] yesOrNo = {"Yes","No"};
		
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
		JComboBox myBoxTwo = this.addComboB(format, type);
		
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
		JPanel formatPanel = new JPanel();
		this.addLabel("DVD", formatPanel);
		JComboBox myBoxFour = this.addComboB(yesOrNo, formatPanel);
		this.addLabel("Blue-Ray", formatPanel);
		JComboBox myBoxFive = this.addComboB(yesOrNo, formatPanel);
		typeTwo.add(formatPanel);
		
		this.panel.add(type);
		this.panel.add(typeTwo);
		
		this.validate();
		this.repaint();
		
		
		
	}

}

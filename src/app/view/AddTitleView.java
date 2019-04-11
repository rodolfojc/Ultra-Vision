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
		
		JPanel type = new JPanel();
		this.setGrid(12, 0, type);
		
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
		
		JPanel typeTwo = new JPanel();
		this.setGrid(12, 0, typeTwo);
		
		this.addLabel("Select Type", typeTwo);
		JComboBox myBoxTwo = this.addComboB(myOpts, typeTwo);
		
		this.addLabel("Title name", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Band", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Album", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Year release", typeTwo);
		this.addTextField(20, typeTwo);
		this.addLabel("Genre", typeTwo);
		this.addTextField(20, typeTwo);
		
		
		this.panel.add(type);
		this.panel.add(typeTwo);
		
		this.validate();
		this.repaint();
		
		
		
	}

}

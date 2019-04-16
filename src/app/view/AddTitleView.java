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

	//MUSIC ATTRIBUTES
	private JTextField musicTitleName;
	private JTextField musicBand;
	private JTextField musicAlbum;
	private JTextField musicYearRelease;
	private JTextField musicGenre;
	private JComboBox isDVDMusic;
	private JComboBox isBlueMusic;
	private JComboBox musicType;
	private JComboBox tvType;
	
	//TV ATTRIBUTES
	private JTextField tvTitleName;
	private JTextField tvYearRelease;
	private JTextField tvGenre;
	private JTextField tvDirector;
	private JTextField tvRunningTime;
	private JTextField country;
	private JTextField language;
	private JComboBox isDVDTv;
	private JComboBox isBlueTv;
	
	//OPTIONS
	private String[] myOpts = {"MusicCD", "Video Concert"};
	private String[] myOptsTwo = {"TV/Boxset", "Movie"};
	private String[] yesOrNo = {"Yes","No","N/A"};
	
	AddTitleController myController;
	
	
	public AddTitleView(String name, int width, int height, boolean Resizable) {
		super(name, width, height, Resizable);
		this.myController = new AddTitleController(this);
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
	
	

	public JTextField getMusicTitleName() {
		return musicTitleName;
	}



	public void setMusicTitleName(JTextField musicTitleName) {
		this.musicTitleName = musicTitleName;
	}



	public JTextField getMusicBand() {
		return musicBand;
	}



	public void setMusicBand(JTextField musicBand) {
		this.musicBand = musicBand;
	}



	public JTextField getMusicAlbum() {
		return musicAlbum;
	}



	public void setMusicAlbum(JTextField musicAlbum) {
		this.musicAlbum = musicAlbum;
	}



	public JTextField getMusicYearRelease() {
		return musicYearRelease;
	}



	public void setMusicYearRelease(JTextField musicYearRelease) {
		this.musicYearRelease = musicYearRelease;
	}



	public JTextField getMusicGenre() {
		return musicGenre;
	}



	public void setMusicGenre(JTextField musicGenre) {
		this.musicGenre = musicGenre;
	}



	public String getIsDVDMusic() {
		return this.yesOrNo[isDVDMusic.getSelectedIndex()];
	}



	public void setIsDVDMusic(JComboBox isDVDMusic) {
		this.isDVDMusic = isDVDMusic;
	}



	public String getIsBlueMusic() {
		return this.yesOrNo[isBlueMusic.getSelectedIndex()];
	}



	public void setIsBlueMusic(JComboBox isBlueMusic) {
		this.isBlueMusic = isBlueMusic;
	}



	public String getMusicType() {
		return this.myOpts[musicType.getSelectedIndex()];
	}



	public void setMusicType(JComboBox musicType) {
		this.musicType = musicType;
	}



	public JComboBox getTvType() {
		return tvType;
	}



	public void setTvType(JComboBox tvType) {
		this.tvType = tvType;
	}



	public JTextField getTvTitleName() {
		return tvTitleName;
	}



	public void setTvTitleName(JTextField tvTitleName) {
		this.tvTitleName = tvTitleName;
	}



	public JTextField getTvYearRelease() {
		return tvYearRelease;
	}



	public void setTvYearRelease(JTextField tvYearRelease) {
		this.tvYearRelease = tvYearRelease;
	}



	public JTextField getTvGenre() {
		return tvGenre;
	}



	public void setTvGenre(JTextField tvGenre) {
		this.tvGenre = tvGenre;
	}



	public JTextField getTvDirector() {
		return tvDirector;
	}



	public void setTvDirector(JTextField tvDirector) {
		this.tvDirector = tvDirector;
	}



	public JTextField getTvRunningTime() {
		return tvRunningTime;
	}



	public void setTvRunningTime(JTextField tvRunningTime) {
		this.tvRunningTime = tvRunningTime;
	}



	public JTextField getCountry() {
		return country;
	}



	public void setCountry(JTextField country) {
		this.country = country;
	}



	public JTextField getLanguage() {
		return language;
	}



	public void setLanguage(JTextField language) {
		this.language = language;
	}



	public JComboBox getIsDVDTv() {
		return isDVDTv;
	}



	public void setIsDVDTv(JComboBox isDVDTv) {
		this.isDVDTv = isDVDTv;
	}



	public JComboBox getIsBlueTv() {
		return isBlueTv;
	}



	public void setIsBlueTv(JComboBox isBlueTv) {
		this.isBlueTv = isBlueTv;
	}



	private void setFrame() {
		
		this.setGrid(0, 2, this.panel);
				
		JPanel type = new JPanel();
		this.setGrid(20, 0, type);
		JLabel musicTitle = this.addLabel("Music (Type)", type);
		musicTitle.setFont(new Font("Serif", Font.BOLD, 24));
		musicTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.musicType = this.addComboB(myOpts, type);
		this.addLabel("Title name", type);
		this.musicTitleName = this.addTextField(20, type);
		this.addLabel("Band", type);
		this.musicBand = this.addTextField(20, type);
		this.addLabel("Album", type);
		this.musicAlbum = this.addTextField(20, type);
		this.addLabel("Year release", type);
		this.musicYearRelease = this.addTextField(20, type);
		this.addLabel("Genre", type);
		this.musicGenre = this.addTextField(20, type);
		this.addLabel("", type);
		this.addLabel("", type);
		this.addLabel("Format", type);
		JPanel formatPanelOne = new JPanel();
		//this.addLabel("CD", formatPanelOne);
		//JComboBox myBoxTwo = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("     (for Video Concert) ", formatPanelOne);
		this.addLabel("DVD ", formatPanelOne);
		this.isDVDMusic = this.addComboB(yesOrNo, formatPanelOne);
		this.addLabel("Blue-Ray ", formatPanelOne);
		this.isBlueMusic = this.addComboB(yesOrNo, formatPanelOne);
		type.add(formatPanelOne);
		this.addLabel("", type);
		this.addLabel("", type);
		JButton addMusicTitle = this.addButton("Add Music", type);
		addMusicTitle.setActionCommand("Add Music");
		addMusicTitle.addActionListener(myController);
		this.addLabel("", type);
		type.setBorder(new EmptyBorder(new Insets(0, 0, 0, 25)));
		
		
		JPanel typeTwo = new JPanel();
		this.setGrid(22, 0, typeTwo);
		JLabel tvTypeTitle = this.addLabel("TV (Type)", typeTwo);
		tvTypeTitle.setFont(new Font("Serif", Font.BOLD, 24));
		tvTypeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.tvType = this.addComboB(myOptsTwo, typeTwo);
		this.addLabel("Title name", typeTwo);
		this.tvTitleName = this.addTextField(20, typeTwo);
		this.addLabel("Year release", typeTwo);
		this.tvYearRelease = this.addTextField(20, typeTwo);
		this.addLabel("Genre", typeTwo);
		this.tvGenre = this.addTextField(20, typeTwo);
		this.addLabel("Director", typeTwo);
		this.tvDirector = this.addTextField(20, typeTwo);
		this.addLabel("Running time", typeTwo);
		this.tvRunningTime = this.addTextField(20, typeTwo);
		this.addLabel("Country", typeTwo);
		this.country = this.addTextField(20, typeTwo);
		this.addLabel("Language", typeTwo);
		this.language = this.addTextField(20, typeTwo);
		this.addLabel("Format", typeTwo);
		JPanel formatPanelTwo = new JPanel();
		this.addLabel("DVD ", formatPanelTwo);
		this.isDVDTv = this.addComboB(yesOrNo, formatPanelTwo);
		this.addLabel("Blue-Ray ", formatPanelTwo);
		this.isBlueTv = this.addComboB(yesOrNo, formatPanelTwo);
		typeTwo.add(formatPanelTwo);
		this.addLabel("", typeTwo);
		this.addLabel("", typeTwo);
		JButton addTvTitle = this.addButton("Add Tv", typeTwo);
		this.addLabel("", typeTwo);
		typeTwo.setBorder(new EmptyBorder(new Insets(0, 25, 0, 0)));
		
		this.panel.add(type);
		this.panel.add(typeTwo);
		this.panel.setBorder(new EmptyBorder(new Insets(35, 65, 45, 65)));
		
		this.validate();
		this.repaint();
		
		
		
	}

}

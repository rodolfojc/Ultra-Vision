package app.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.DarkStar;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.jgoodies.looks.plastic.theme.DesertRed;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import com.jgoodies.looks.plastic.theme.SkyYellow;

public class Main {

	public static void main(String[] args) {

		  try {
	            // Set cross-platform Java L&F (also called "Metal")
			  Plastic3DLookAndFeel.setPlasticTheme(new DarkStar());
			  UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       System.out.println(e.getStackTrace());
	    }
	    catch (ClassNotFoundException e) {
	    	System.out.println(e.getStackTrace());
	    }
	    catch (InstantiationException e) {
	    	System.out.println(e.getStackTrace());
	    }
	    catch (IllegalAccessException e) {
	    	System.out.println(e.getStackTrace());
	    }
	        
	    // MAIN CONTROLLER
		new Controller();

	}

}

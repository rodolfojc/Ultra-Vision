package app.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import app.database.Database;
import app.view.MemberMenuView;
import app.view.SearchTitleView;

public class MemberMenuModel {

	// ATTRIBUTES
	private Database myDB;
	private MemberMenuView memberMenuView;
	private SearchTitleView searchTitleView;

	// CONSTRUCTORS
	public MemberMenuModel(Database myDB, MemberMenuView memberMenuView) {

		this.myDB = myDB;
		this.memberMenuView = memberMenuView;

	}

	public MemberMenuModel(Database myDB, SearchTitleView searchTitleView, MemberMenuView memberMenuView) {

		this.myDB = myDB;
		this.searchTitleView = searchTitleView;
		this.memberMenuView = memberMenuView;
	}

	// SEARCH A TITLE BY QUERY
	public void getData(String type, String Query) {

		if (type.equals("MusicLovers")) {
			this.getDataMusicLovers("AND title_name LIKE '%" + Query + "%'");

		} else if (type.equals("VideoLovers") || type.equals("TvLovers")) {
			this.getDataVideoOrTVLovers(type, "AND title_name LIKE '%" + Query + "%'");

		} else {
			this.getDataPremiunLovers("WHERE title_name LIKE '%" + Query + "%'");
		}

	}

	// GET DATA FOR MUSICLOVERS
	public void getDataMusicLovers(String Query) {

		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][9];
		String[][] tempDataRented = new String[4][10];

		// GET TITLES
		String query = "SELECT id, title_name, year_rel, album, band, genre, cd, dvd, blue_ray " + "FROM titles "
				+ "WHERE (type = 'AudioMusic' OR type = 'ConcertVideo') " + Query + ";";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int i = 0;

			while (this.myDB.getRs().next()) {

				tempData[i][0] = this.myDB.getRs().getString("id");
				tempData[i][1] = this.myDB.getRs().getString("title_name");
				tempData[i][2] = this.myDB.getRs().getString("year_rel");
				tempData[i][3] = this.myDB.getRs().getString("album");
				tempData[i][4] = this.myDB.getRs().getString("band");
				tempData[i][5] = this.myDB.getRs().getString("genre");
				tempData[i][6] = this.myDB.getRs().getString("cd");
				tempData[i][7] = this.myDB.getRs().getString("dvd");
				tempData[i][8] = this.myDB.getRs().getString("blue_ray");
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// GET TITLES THAT HAVE BEEN RENTED BY MEMBER
		String queryTwo = "SELECT id, title_name, year_rel, album, band, genre, cd, dvd, blue_ray, ref "
				+ "FROM titles ti " + "INNER JOIN rented re ON re.title_id = ti.id "
				+ "INNER JOIN customers cu ON cu.mem_numb = re.mem_numb " + "WHERE cu.mem_numb = "
				+ this.memberMenuView.getMyCustomer().getId() + " " + "AND re.status = 'Rented';";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

			int j = 0;

			while (this.myDB.getRs().next()) {

				tempDataRented[j][0] = this.myDB.getRs().getString("id");
				tempDataRented[j][1] = this.myDB.getRs().getString("title_name");
				tempDataRented[j][2] = this.myDB.getRs().getString("year_rel");
				tempDataRented[j][3] = this.myDB.getRs().getString("album");
				tempDataRented[j][4] = this.myDB.getRs().getString("band");
				tempDataRented[j][5] = this.myDB.getRs().getString("genre");
				tempDataRented[j][6] = this.myDB.getRs().getString("cd");
				tempDataRented[j][7] = this.myDB.getRs().getString("dvd");
				tempDataRented[j][8] = this.myDB.getRs().getString("blue_ray");
				tempDataRented[j][9] = this.myDB.getRs().getString("ref");
				j++;
			}

			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();

			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
			this.memberMenuView.setTitles(tempData);
			this.memberMenuView.setTitlesRentedData(tempDataRented);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// GET DATA FOR VIDEO OR TV LOVERS
	public void getDataVideoOrTVLovers(String type, String Query) {

		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][10];
		String[][] tempDataRented = new String[4][11];
		String typeQuery;

		if (type.equals("VideoLovers")) {
			typeQuery = "Movie";
		} else {
			typeQuery = "BoxSet";
		}

		// GET TITLES
		String query = "SELECT id, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray "
				+ "FROM titles " + "WHERE type = '" + typeQuery + "' " + Query + ";";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int j = 0;

			while (this.myDB.getRs().next()) {

				tempData[j][0] = this.myDB.getRs().getString("id");
				tempData[j][1] = this.myDB.getRs().getString("title_name");
				tempData[j][2] = this.myDB.getRs().getString("year_rel");
				tempData[j][3] = this.myDB.getRs().getString("genre");
				tempData[j][4] = this.myDB.getRs().getString("director");
				tempData[j][5] = this.myDB.getRs().getString("runn_time");
				tempData[j][6] = this.myDB.getRs().getString("lang");
				tempData[j][7] = this.myDB.getRs().getString("country");
				tempData[j][8] = this.myDB.getRs().getString("dvd");
				tempData[j][9] = this.myDB.getRs().getString("blue_ray");
				j++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// GET TITLES THAT HAVE BEEN RENTED BY MEMBER
		String queryTwo = "SELECT id, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray, ref "
				+ "FROM titles ti " + "INNER JOIN rented re ON re.title_id = ti.id "
				+ "INNER JOIN customers cu ON cu.mem_numb = re.mem_numb " + "WHERE cu.mem_numb = "
				+ this.memberMenuView.getMyCustomer().getId() + " " + "AND re.status = 'Rented';";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

			int i = 0;

			while (this.myDB.getRs().next()) {

				tempDataRented[i][0] = this.myDB.getRs().getString("id");
				tempDataRented[i][1] = this.myDB.getRs().getString("title_name");
				tempDataRented[i][2] = this.myDB.getRs().getString("year_rel");
				tempDataRented[i][3] = this.myDB.getRs().getString("genre");
				tempDataRented[i][4] = this.myDB.getRs().getString("director");
				tempDataRented[i][5] = this.myDB.getRs().getString("runn_time");
				tempDataRented[i][6] = this.myDB.getRs().getString("lang");
				tempDataRented[i][7] = this.myDB.getRs().getString("country");
				tempDataRented[i][8] = this.myDB.getRs().getString("dvd");
				tempDataRented[i][9] = this.myDB.getRs().getString("blue_ray");
				tempDataRented[i][10] = this.myDB.getRs().getString("ref");
				i++;
			}

			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();

			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
			this.memberMenuView.setTitles(tempData);
			this.memberMenuView.setTitlesRentedData(tempDataRented);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// GET DATA FOR PREMIUN
	public void getDataPremiunLovers(String Query) {

		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][13];
		String[][] tempDataRented = new String[4][14];

		// GET TITLES
		String query = "SELECT id, title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray "
				+ "FROM titles " + Query + ";";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int i = 0;

			while (this.myDB.getRs().next()) {

				tempData[i][0] = this.myDB.getRs().getString("id");
				tempData[i][1] = this.myDB.getRs().getString("title_name");
				tempData[i][2] = this.myDB.getRs().getString("year_rel");
				tempData[i][3] = this.myDB.getRs().getString("album");
				tempData[i][4] = this.myDB.getRs().getString("band");
				tempData[i][5] = this.myDB.getRs().getString("genre");
				tempData[i][6] = this.myDB.getRs().getString("director");
				tempData[i][7] = this.myDB.getRs().getString("runn_time");
				tempData[i][8] = this.myDB.getRs().getString("lang");
				tempData[i][9] = this.myDB.getRs().getString("country");
				tempData[i][10] = this.myDB.getRs().getString("cd");
				tempData[i][11] = this.myDB.getRs().getString("dvd");
				tempData[i][12] = this.myDB.getRs().getString("blue_ray");
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// GET TITLES THAT HAVE BEEN RENTED BY MEMBER
		String queryTwo = "SELECT id, title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray, ref "
				+ "FROM titles ti " + "INNER JOIN rented re ON re.title_id = ti.id "
				+ "INNER JOIN customers cu ON cu.mem_numb = re.mem_numb " + "WHERE cu.mem_numb = "
				+ this.memberMenuView.getMyCustomer().getId() + " " + "AND re.status = 'Rented';";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

			int j = 0;

			while (this.myDB.getRs().next()) {

				tempDataRented[j][0] = this.myDB.getRs().getString("id");
				tempDataRented[j][1] = this.myDB.getRs().getString("title_name");
				tempDataRented[j][2] = this.myDB.getRs().getString("year_rel");
				tempDataRented[j][3] = this.myDB.getRs().getString("album");
				tempDataRented[j][4] = this.myDB.getRs().getString("band");
				tempDataRented[j][5] = this.myDB.getRs().getString("genre");
				tempDataRented[j][6] = this.myDB.getRs().getString("director");
				tempDataRented[j][7] = this.myDB.getRs().getString("runn_time");
				tempDataRented[j][8] = this.myDB.getRs().getString("lang");
				tempDataRented[j][9] = this.myDB.getRs().getString("country");
				tempDataRented[j][10] = this.myDB.getRs().getString("cd");
				tempDataRented[j][11] = this.myDB.getRs().getString("dvd");
				tempDataRented[j][12] = this.myDB.getRs().getString("blue_ray");
				tempDataRented[j][13] = this.myDB.getRs().getString("ref");
				j++;
			}

			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();

			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
			this.memberMenuView.setTitles(tempData);
			this.memberMenuView.setTitlesRentedData(tempDataRented);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// METHOS TO RENT A TITLE AS RENTED
	public void setRent(String titlesStr, int id, String isFormatDB, boolean freeRent) {

		if (isFormatDB.equals("CD")) {
			isFormatDB = "cd";
		} else if (isFormatDB.equals("DVD")) {
			isFormatDB = "dvd";
		} else if (isFormatDB.equals("BlueRay")) {
			isFormatDB = "blue_ray";
		} else {
			isFormatDB = "No Available";
		}

		if (!isFormatDB.equals("No Available")) {

			int titleInt = Integer.parseInt(titlesStr);

			try {

				String query = "UPDATE titles SET " + isFormatDB + "=" + id + " WHERE id=" + titlesStr + ";";

				PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
				preparedStmt.execute();
				preparedStmt.close();

			} catch (Exception e) {
				// ERROR MESSAGES
				JOptionPane.showMessageDialog(this.memberMenuView, "Ups, there is a problem, try again!");
				System.err.println("Got an exception!");
				System.out.println("I am in sentRent() - query ");
				System.err.println(e.getMessage());
			}

			try {

				String queryTwo = "INSERT INTO rented (mem_numb, title_id, title_format, date, status) "
						+ "VALUES (?, ?, ?, CURDATE(), ?)";

				// PREPARATION
				PreparedStatement preparedStmtTwo = this.myDB.getConn().prepareStatement(queryTwo);
				preparedStmtTwo.setInt(1, id);
				preparedStmtTwo.setInt(2, titleInt);
				preparedStmtTwo.setString(3, isFormatDB);
				preparedStmtTwo.setString(4, "Rented");
				preparedStmtTwo.execute();
				preparedStmtTwo.close();

			} catch (Exception e) {
				// ERROR MESSAGES
				JOptionPane.showMessageDialog(this.memberMenuView, "Ups, there is a problem, try again!");
				System.err.println("Got an exception!");
				System.out.println("I am in sentRent() - queryTwo ");
				System.err.println(e.getMessage());
			}

			try {

				if (freeRent == false) {
					this.memberMenuView.getMyCustomer().getMyMemberCard().addPoints(10);
					String queryThree = "UPDATE customers SET points = (points+10) WHERE mem_numb = " + id + " ";
					PreparedStatement preparedStmtThree = this.myDB.getConn().prepareStatement(queryThree);
					preparedStmtThree.execute();
					preparedStmtThree.close();

				} else if (freeRent == true && this.memberMenuView.isFreeRentalFlag() == true) {
					this.memberMenuView.getMyCustomer().getMyMemberCard().addPoints(-100);
					String queryThree = "UPDATE customers SET points = (points-100) WHERE mem_numb = " + id + " ";
					PreparedStatement preparedStmtThree = this.myDB.getConn().prepareStatement(queryThree);
					preparedStmtThree.execute();
					preparedStmtThree.close();
				}

			} catch (Exception e) {
				// ERROR MESSAGES
				JOptionPane.showMessageDialog(this.memberMenuView, "Ups, there is a problem, try again!");
				System.err.println("Got an exception!");
				System.out.println("I am in sentRent() - queryThree ");
				System.err.println(e.getMessage());
			}

			try {
				this.memberMenuView.getMyCustomer().addNumbRented(1);
				String queryFour = "UPDATE customers SET titles_rented = (titles_rented + 1) WHERE mem_numb = " + id
						+ " ";
				PreparedStatement preparedStmtFour = this.myDB.getConn().prepareStatement(queryFour);
				preparedStmtFour.execute();

				this.myDB.getConn().close();

			} catch (Exception e) {
				// ERROR MESSAGES
				JOptionPane.showMessageDialog(this.memberMenuView, "Ups, there is a problem, try again!");
				System.err.println("Got an exception!");
				System.out.println("I am in sentRent() - queryFour ");
				System.err.println(e.getMessage());
			}

			if (!freeRent) {
				JOptionPane.showMessageDialog(this.memberMenuView,
						"The title have been rented, TOTAL = €2 (Direct debit - Card) ", "Confirm",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.searchTitleView, "The title have been rented for FREE", "Confirm",
						JOptionPane.INFORMATION_MESSAGE);
				this.searchTitleView.dispose();

			}

		} else {
			JOptionPane.showMessageDialog(this.memberMenuView, "The title is not Available ", "Confirm",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	// METHOD TO SET A TITLE AS RETURN
	public void setReturn(String titleID, String format, int custID, String ref, int paid) {

		try {

			String query = "UPDATE titles SET " + format + "='Yes' WHERE id='" + titleID + "';";

			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.execute();

		} catch (Exception e) {

			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		try {
			String queryTwo = "UPDATE rented SET status = 'Returned', " + "paid_eur = (paid_eur + " + paid + ") "
					+ "WHERE ref = " + ref + ";";

			PreparedStatement preparedStmtTwo = this.myDB.getConn().prepareStatement(queryTwo);
			preparedStmtTwo.execute();

		} catch (Exception e) {

			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		try {
			this.memberMenuView.getMyCustomer().addNumbRented(-1);
			String queryThree = "UPDATE customers SET titles_rented = (titles_rented - 1) WHERE mem_numb = " + custID
					+ ";";
			PreparedStatement preparedStmtThree = this.myDB.getConn().prepareStatement(queryThree);
			preparedStmtThree.execute();

			this.myDB.getConn().close();

		} catch (Exception e) {

			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		JOptionPane.showMessageDialog(this.memberMenuView, "The title have been set Returned ", "Confirm",
				JOptionPane.INFORMATION_MESSAGE);

	}

	// METHOD TO GET DATE OF RENT BY TITLE REFERENCE - RENTED TABLE
	public Date getTitleDate(String refTitle) {

		Date myDate = new Date();

		String query = "SELECT date FROM rented WHERE ref = " + refTitle + ";";

		try {

			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			while (this.myDB.getRs().next()) {

				myDate = this.myDB.getRs().getDate("date");

			}

			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myDate;
	}

}

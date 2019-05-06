package app.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import app.database.Database;
import app.view.MemberMenuView;

public class MemberMenuModel {

	private Database myDB;
	private MemberMenuView memberMenuView;
	
	public MemberMenuModel(Database myDB, MemberMenuView memberMenuView) {
		
		this.myDB = myDB;
		this.memberMenuView = memberMenuView;
		
	}

	public void getData(String type, String Query) {
		
		if (type.equals("MusicLovers")) {
			this.getDataMusicLovers(this.memberMenuView.getMyCustomer().getTitleRentedInt(0),
									this.memberMenuView.getMyCustomer().getTitleRentedInt(1), 
									this.memberMenuView.getMyCustomer().getTitleRentedInt(2),
									this.memberMenuView.getMyCustomer().getTitleRentedInt(3),
									"AND title_name LIKE '%"+Query+"%'");
			
		}else if (type.equals("VideoLovers") || type.equals("TvLovers") ) {
			this.getDataVideoOrTVLovers(type, 
										this.memberMenuView.getMyCustomer().getTitleRentedInt(0),
										this.memberMenuView.getMyCustomer().getTitleRentedInt(1), 
										this.memberMenuView.getMyCustomer().getTitleRentedInt(2),
										this.memberMenuView.getMyCustomer().getTitleRentedInt(3),
										"AND title_name LIKE '%"+Query+"%'");
		
		}else {
			this.getDataPremiunLovers(this.memberMenuView.getMyCustomer().getTitleRentedInt(0),
									  this.memberMenuView.getMyCustomer().getTitleRentedInt(1), 
									  this.memberMenuView.getMyCustomer().getTitleRentedInt(2),
									  this.memberMenuView.getMyCustomer().getTitleRentedInt(3),
									  "WHERE title_name LIKE '%"+Query+"%'");
		}
		
		
	}
	
	public void getDataMusicLovers(int idOne, int idTwo, int idThree, int idFour, String Query ) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][9];
		String[][] tempDataRented = new String[4][9];
		Date[] dates = new Date[4];
				
		String query = "SELECT id, title_name, year_rel, album, band, genre, cd, dvd, blue_ray "
				 + "FROM titles "
				 + "WHERE (type = 'AudioMusic' OR type = 'ConcertVideo') "+Query+";";
		
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
			
		String queryTwo = "SELECT id, title_name, year_rel, album, band, genre, cd, dvd, blue_ray "
						+ "FROM titles "
						+ "WHERE id = "+idOne+" "
						+ "OR id = "+idTwo+" "
						+ "OR id = "+idThree+" "
						+ "OR id = "+idFour+";";
		
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
				j++;
			}
			

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		//QUERY THREE
		String queryThree = "SELECT one_date, two_date, three_date, four_date "
						  + "FROM customers WHERE mem_numb = "+this.memberMenuView.getMyCustomer().getId()+";";
						
		
		try {
			
			this.myDB.setRs(this.myDB.getStmt().executeQuery(queryThree));

			int j = 0;

			while (this.myDB.getRs().next()) {
				
				dates[0] = this.myDB.getRs().getDate("one_date");
				dates[1] = this.myDB.getRs().getDate("two_date");
				dates[2] = this.myDB.getRs().getDate("three_date");
				dates[3] = this.myDB.getRs().getDate("four_date");
			
			}
			
			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();
		
			
			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
			this.memberMenuView.setTitles(tempData);
			this.memberMenuView.setTitlesRentedData(tempDataRented);
			this.memberMenuView.setDates(dates);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

	}
	
	public void getDataVideoOrTVLovers(String type, int idOne, int idTwo, int idThree, int idFour, String Query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][10];
		String[][] tempDataRented = new String[4][10];
		String typeQuery;
		Date[] dates = new Date[4];
			
		if (type.equals("VideoLovers")) {
			typeQuery = "Movie";
		}else {
			typeQuery = "BoxSet";
		}
		
		//QUERY
		String query = "SELECT id, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray "
					 + "FROM titles "
					 + "WHERE type = '"+typeQuery+"' "+Query+";";
					
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
		
		String queryTwo = "SELECT id, title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray "
						+ "FROM titles "
						+ "WHERE id = "+idOne+" "
						+ "OR id = "+idTwo+" "
						+ "OR id = "+idThree+" "
						+ "OR id = "+idFour+";";
				
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
						i++;
					}


				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				//QUERY THREE
				String queryThree = "SELECT one_date, two_date, three_date, four_date "
								  + "FROM customers WHERE mem_numb = "+this.memberMenuView.getMyCustomer().getId()+";";
								
				
				try {
					
					this.myDB.setRs(this.myDB.getStmt().executeQuery(queryThree));

					int j = 0;

					while (this.myDB.getRs().next()) {
						
						dates[0] = this.myDB.getRs().getDate("one_date");
						dates[1] = this.myDB.getRs().getDate("two_date");
						dates[2] = this.myDB.getRs().getDate("three_date");
						dates[3] = this.myDB.getRs().getDate("four_date");
					
					}
					
					this.myDB.getRs().close();
					this.myDB.getStmt().close();
					this.myDB.getConn().close();
				
					
					// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
					this.memberMenuView.setTitles(tempData);
					this.memberMenuView.setTitlesRentedData(tempDataRented);
					this.memberMenuView.setDates(dates);
					
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		
	}
	
		
	public void getDataPremiunLovers(int idOne, int idTwo, int idThree, int idFour, String Query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][13];
		String[][] tempDataRented = new String[4][13];
		Date[] dates = new Date[4];
		
		//Query		
		String query = "SELECT id, title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray "
					 + "FROM titles "+Query+";";
		
				
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
		
				//QUERY TWO
				String queryTwo = "SELECT id, title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray "
								+ "FROM titles "
								+ "WHERE id = "+idOne+" "
								+ "OR id = "+idTwo+" " 
								+ "OR id = "+idThree+" "
								+ "OR id = "+idFour+";";
				
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
						j++;
					}

					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//QUERY THREE
				String queryThree = "SELECT one_date, two_date, three_date, four_date "
								  + "FROM customers WHERE mem_numb = "+this.memberMenuView.getMyCustomer().getId()+";";
								
				
				try {
					
					this.myDB.setRs(this.myDB.getStmt().executeQuery(queryThree));

					int j = 0;

					while (this.myDB.getRs().next()) {
						
						dates[0] = this.myDB.getRs().getDate("one_date");
						dates[1] = this.myDB.getRs().getDate("two_date");
						dates[2] = this.myDB.getRs().getDate("three_date");
						dates[3] = this.myDB.getRs().getDate("four_date");
					
					}
					
					this.myDB.getRs().close();
					this.myDB.getStmt().close();
					this.myDB.getConn().close();
				
					
					// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
					this.memberMenuView.setTitles(tempData);
					this.memberMenuView.setTitlesRentedData(tempDataRented);
					this.memberMenuView.setDates(dates);
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
						
				
		
		}


	public void setRent(String titlesStr, int id, int slotForRented, String isFormatDB) {
		
		String titleSlot;
		String titleRefDate;
		
		if (isFormatDB.equals("CD")) {
			isFormatDB = "cd";
		}else if(isFormatDB.equals("DVD")) {
			isFormatDB = "dvd";
		}else if(isFormatDB.equals("BlueRay")){
			isFormatDB = "blue_ray";
		}else {
			isFormatDB = "No Available";
		}
		
		if (!isFormatDB.equals("No Available")) {
		
		if (slotForRented == 0) {
			titleSlot = "title_one";
			titleRefDate = "one_date";
		} else if (slotForRented == 1) {
			titleSlot = "title_two";
			titleRefDate = "two_date";
		} else if (slotForRented == 2) {
			titleSlot = "title_three";
			titleRefDate = "three_date";
		} else {
			titleSlot = "title_four";
			titleRefDate = "four_date";
		} 
		
		String custIDStr = Integer.toString(id);
		int titleInt = Integer.parseInt(titlesStr);
		
		try {

			String query = "UPDATE titles SET "+isFormatDB+"='"+custIDStr+"' WHERE id='"+titlesStr+"';";

			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.execute();
			
			String queryTwo= "UPDATE customers SET "+titleSlot+" = "+titleInt+", "+titleRefDate+" = CURDATE() WHERE mem_numb = "+id+" ";
			PreparedStatement preparedStmtTwo = this.myDB.getConn().prepareStatement(queryTwo);
			preparedStmtTwo.execute();
			
			String queryThree= "UPDATE customers SET points = (points+10) WHERE mem_numb = "+id+" ";
			PreparedStatement preparedStmtThree = this.myDB.getConn().prepareStatement(queryThree);
			preparedStmtThree.execute();
			
			this.memberMenuView.getMyCustomer().setTitleRented(slotForRented, titleInt);
			this.memberMenuView.getMyCustomer().getMyMemberCard().addPoints(10);
			
			this.myDB.getConn().close();

		} catch (Exception e) {

			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	
		JOptionPane.showMessageDialog(this.memberMenuView, 
									  "The title have been rented, TOTAL = €2.50 (Direct debit - Card) ", 
									  "Confirm", 
									  JOptionPane.INFORMATION_MESSAGE);
		
		}else {
			JOptionPane.showMessageDialog(this.memberMenuView, 
					  "The title is not Available ", 
					  "Confirm", 
					  JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public void setReturn(String titleID, String format, int custID, int selectedRow) {
		
		String slotRented;
		String titleRefDate;
		
		if(selectedRow == 0) {
			slotRented = "title_one";
			titleRefDate = "one_date";
		} else if (selectedRow == 1) {
			slotRented = "title_two";
			titleRefDate = "two_date";
		} else if (selectedRow == 2) {
			slotRented = "title_three";
			titleRefDate = "three_date";
		} else {
			slotRented = "title_four";
			titleRefDate = "four_date";
		}
		
		
		try {

			String query = "UPDATE titles SET "+format+"='Yes' WHERE id='"+titleID+"';";

			PreparedStatement preparedStmt = this.myDB.getConn().prepareStatement(query);
			preparedStmt.execute();
			
			String queryTwo= "UPDATE customers SET "+slotRented+" = 0 , "+titleRefDate+" = NULL WHERE mem_numb = "+custID+" ";
			PreparedStatement preparedStmtTwo = this.myDB.getConn().prepareStatement(queryTwo);
			preparedStmtTwo.execute();
			
			this.memberMenuView.getMyCustomer().setTitleRented(selectedRow, 0);
			
			this.myDB.getConn().close();

		} catch (Exception e) {

			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	
		JOptionPane.showMessageDialog(this.memberMenuView, 
									  "The title have been set Returned) ", 
									  "Confirm", 
									  JOptionPane.INFORMATION_MESSAGE);
		
	}
	
		
}

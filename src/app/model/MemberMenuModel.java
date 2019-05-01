package app.model;

import java.sql.SQLException;

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
		String[][] tempData = new String[1000][8];
		String[][] tempDataRented = new String[4][8];
				
		String query = "SELECT title_name, year_rel, album, band, genre, cd, dvd, blue_ray "
				 + "FROM titles "
				 + "WHERE type = 'AudioMusic' OR type = 'ConcertVideo' "+Query+";";
		
		try {
			
			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int i = 0;

			while (this.myDB.getRs().next()) {

				tempData[i][0] = this.myDB.getRs().getString("title_name");
				tempData[i][1] = this.myDB.getRs().getString("year_rel");
				tempData[i][2] = this.myDB.getRs().getString("album");
				tempData[i][3] = this.myDB.getRs().getString("band");
				tempData[i][4] = this.myDB.getRs().getString("genre");
				tempData[i][5] = this.myDB.getRs().getString("cd");
				tempData[i][6] = this.myDB.getRs().getString("dvd");
				tempData[i][7] = this.myDB.getRs().getString("blue_ray");
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		String queryTwo = "SELECT title_name, year_rel, album, band, genre, cd, dvd, blue_ray "
						+ "FROM titles "
						+ "WHERE id = "+idOne+" "
						+ "OR id = "+idTwo+" "
						+ "OR id = "+idThree+" "
						+ "OR id = "+idFour+";";
		
		try {
			
			this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

			int j = 0;

			while (this.myDB.getRs().next()) {

				tempDataRented[j][0] = this.myDB.getRs().getString("title_name");
				tempDataRented[j][1] = this.myDB.getRs().getString("year_rel");
				tempDataRented[j][2] = this.myDB.getRs().getString("album");
				tempDataRented[j][3] = this.myDB.getRs().getString("band");
				tempDataRented[j][4] = this.myDB.getRs().getString("genre");
				tempDataRented[j][5] = this.myDB.getRs().getString("cd");
				tempDataRented[j][6] = this.myDB.getRs().getString("dvd");
				tempDataRented[j][7] = this.myDB.getRs().getString("blue_ray");
				j++;
			}
			
			this.myDB.getRs().close();
			this.myDB.getStmt().close();
			this.myDB.getConn().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
			this.memberMenuView.setTitles(tempData);
			this.memberMenuView.setTitlesRentedData(tempDataRented);	
	}
	
	public void getDataVideoOrTVLovers(String type, int idOne, int idTwo, int idThree, int idFour, String Query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][9];
		String[][] tempDataRented = new String[4][9];
		String typeQuery;
			
		if (type.equals("VideoLovers")) {
			typeQuery = "Movie";
		}else {
			typeQuery = "BoxSet";
		}
		
		//QUERY
		String query = "SELECT title_name, year_rel, genre, director, runn_time, lang, country, dvd, blue_ray "
					 + "FROM titles "
					 + "WHERE type = '"+typeQuery+"' "+Query+";";
					
		try {
			
			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int j = 0;

			while (this.myDB.getRs().next()) {

				tempData[j][0] = this.myDB.getRs().getString("title_name");
				tempData[j][1] = this.myDB.getRs().getString("year_rel");
				tempData[j][2] = this.myDB.getRs().getString("genre");
				tempData[j][3] = this.myDB.getRs().getString("director");
				tempData[j][4] = this.myDB.getRs().getString("runn_time");
				tempData[j][5] = this.myDB.getRs().getString("lang");
				tempData[j][6] = this.myDB.getRs().getString("country");
				tempData[j][7] = this.myDB.getRs().getString("dvd");
				tempData[j][8] = this.myDB.getRs().getString("blue_ray");
				j++;
			}

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String queryTwo = "SELECT title_name, year_rel, album, band, genre, cd, dvd, blue_ray "
						+ "FROM titles "
						+ "WHERE id = "+idOne+" "
						+ "OR id = "+idTwo+" "
						+ "OR id = "+idThree+" "
						+ "OR id = "+idFour+";";
				
				try {
					
					this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

					int i = 0;

					while (this.myDB.getRs().next()) {

						tempDataRented[i][0] = this.myDB.getRs().getString("title_name");
						tempDataRented[i][1] = this.myDB.getRs().getString("year_rel");
						tempDataRented[i][2] = this.myDB.getRs().getString("genre");
						tempDataRented[i][3] = this.myDB.getRs().getString("director");
						tempDataRented[i][4] = this.myDB.getRs().getString("runn_time");
						tempDataRented[i][5] = this.myDB.getRs().getString("lang");
						tempDataRented[i][6] = this.myDB.getRs().getString("country");
						tempDataRented[i][7] = this.myDB.getRs().getString("dvd");
						tempDataRented[i][8] = this.myDB.getRs().getString("blue_ray");
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
	
		
	public void getDataPremiunLovers(int idOne, int idTwo, int idThree, int idFour, String Query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][12];
		String[][] tempDataRented = new String[4][12];
		
		//Query		
		String query = "SELECT title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray "
					 + "FROM titles "+Query+";";
		
				
		try {
			
			this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

			int i = 0;

			while (this.myDB.getRs().next()) {

				tempData[i][0] = this.myDB.getRs().getString("title_name");
				tempData[i][1] = this.myDB.getRs().getString("year_rel");
				tempData[i][2] = this.myDB.getRs().getString("album");
				tempData[i][3] = this.myDB.getRs().getString("band");
				tempData[i][4] = this.myDB.getRs().getString("genre");
				tempData[i][5] = this.myDB.getRs().getString("director");
				tempData[i][6] = this.myDB.getRs().getString("runn_time");
				tempData[i][7] = this.myDB.getRs().getString("lang");
				tempData[i][8] = this.myDB.getRs().getString("country");
				tempData[i][9] = this.myDB.getRs().getString("cd");
				tempData[i][10] = this.myDB.getRs().getString("dvd");
				tempData[i][11] = this.myDB.getRs().getString("blue_ray");
				i++;
			}

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				//QUERY TWO
				String queryTwo = "SELECT title_name, year_rel, album, band, genre, director, runn_time, lang, country, cd, dvd, blue_ray "
								+ "FROM titles "
								+ "WHERE id = "+idOne+" "
								+ "OR id = "+idTwo+" " 
								+ "OR id = "+idThree+" "
								+ "OR id = "+idFour+";";
				
				try {
					
					this.myDB.setRs(this.myDB.getStmt().executeQuery(queryTwo));

					int j = 0;

					while (this.myDB.getRs().next()) {

						tempDataRented[j][0] = this.myDB.getRs().getString("title_name");
						tempDataRented[j][1] = this.myDB.getRs().getString("year_rel");
						tempDataRented[j][2] = this.myDB.getRs().getString("album");
						tempDataRented[j][3] = this.myDB.getRs().getString("band");
						tempDataRented[j][4] = this.myDB.getRs().getString("genre");
						tempDataRented[j][5] = this.myDB.getRs().getString("director");
						tempDataRented[j][6] = this.myDB.getRs().getString("runn_time");
						tempDataRented[j][7] = this.myDB.getRs().getString("lang");
						tempDataRented[j][8] = this.myDB.getRs().getString("country");
						tempDataRented[j][9] = this.myDB.getRs().getString("cd");
						tempDataRented[j][10] = this.myDB.getRs().getString("dvd");
						tempDataRented[j][11] = this.myDB.getRs().getString("blue_ray");
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
	
		
}

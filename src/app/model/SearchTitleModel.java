package app.model;

import java.sql.SQLException;

import app.database.Database;
import app.view.SearchTitleView;

public class SearchTitleModel {

	//ATTRIBUTES
	private SearchTitleView searchTitleView;
	private Database myDB;
	
	public SearchTitleModel(Database myBD, SearchTitleView searchTitleView) {
		
		this.searchTitleView = searchTitleView;
		this.myDB = myBD;
		
	}

	public void getData(String query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][14];

				try {
					
						this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

					int i = 0;

					while (this.myDB.getRs().next()) {
						
						tempData[i][0] = this.myDB.getRs().getString("id");
						tempData[i][1] = this.myDB.getRs().getString("Type");
						tempData[i][2] = this.myDB.getRs().getString("title_name");
						tempData[i][3] = this.myDB.getRs().getString("year_rel");
						tempData[i][4] = this.myDB.getRs().getString("album");
						tempData[i][5] = this.myDB.getRs().getString("band");
						tempData[i][6] = this.myDB.getRs().getString("genre");
						tempData[i][7] = this.myDB.getRs().getString("director");
						tempData[i][8] = this.myDB.getRs().getString("runn_time");
						tempData[i][9] = this.myDB.getRs().getString("lang");
						tempData[i][10] = this.myDB.getRs().getString("country");
						tempData[i][11] = this.myDB.getRs().getString("cd");
						tempData[i][12] = this.myDB.getRs().getString("dvd");
						tempData[i][13] = this.myDB.getRs().getString("blue_ray");
						i++;
					}

					this.myDB.getRs().close();
					this.myDB.getStmt().close();
					this.myDB.getConn().close();

					// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER
					// TABLES
					this.searchTitleView.setData(tempData);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}

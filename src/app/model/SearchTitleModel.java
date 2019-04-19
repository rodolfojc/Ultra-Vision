package app.model;

import java.sql.SQLException;

import app.database.Database;
import app.view.SearchTitleView;

public class SearchTitleModel {

	//ATTRIBUTES
	private SearchTitleView searchTitleView;
	private Database myBD;
	
	public SearchTitleModel(Database myBD, SearchTitleView searchTitleView) {
		
		this.searchTitleView = searchTitleView;
		this.myBD = myBD;
		
	}

	public void getData(String query) {
		
		// LOCAL DATA STORAGE
				String[][] tempData = new String[1000][4];

				try {
					
						this.myBD.setRs(this.myBD.getStmt().executeQuery(query));

					int i = 0;

					while (this.myBD.getRs().next()) {

						tempData[i][0] = this.myBD.getRs().getString("id");
						tempData[i][1] = this.myBD.getRs().getString("type");
						tempData[i][2] = this.myBD.getRs().getString("title_name");
						tempData[i][3] = this.myBD.getRs().getString("year_rel");
						i++;
					}

					this.myBD.getRs().close();
					this.myBD.getStmt().close();
					this.myBD.getConn().close();

					// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER
					// TABLES
					this.searchTitleView.setData(tempData);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}

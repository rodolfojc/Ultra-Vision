package app.model;

import java.sql.SQLException;

import app.database.Database;
import app.view.SearchMemberView;

public class SearchMemberModel {

	private SearchMemberView searchMemberView;
	private Database myBD;
	
	public SearchMemberModel(Database myBD, SearchMemberView searchMemberView) {
		
		this.searchMemberView = searchMemberView;
		this.myBD = myBD;
		
	}

	public void getData(String query) {
		
		// LOCAL DATA STORAGE
		String[][] tempData = new String[1000][4];

		try {
			
				this.myBD.setRs(this.myBD.getStmt().executeQuery(query));

			int i = 0;

			while (this.myBD.getRs().next()) {

				tempData[i][0] = this.myBD.getRs().getString("mem_numb");
				tempData[i][1] = this.myBD.getRs().getString("mem_type");
				tempData[i][2] = this.myBD.getRs().getString("cust_name");
				tempData[i][3] = this.myBD.getRs().getString("cust_surname");
				i++;
			}

			this.myBD.getRs().close();
			this.myBD.getStmt().close();
			this.myBD.getConn().close();

			// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER
			// TABLES
			this.searchMemberView.setData(tempData);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
}

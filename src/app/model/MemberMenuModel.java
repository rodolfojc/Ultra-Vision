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

	public void getData(String query) {
		
				// LOCAL DATA STORAGE
				String[][] tempData = new String[1000][4];

				try {
					
					this.myDB.setRs(this.myDB.getStmt().executeQuery(query));

					int i = 0;

					while (this.myDB.getRs().next()) {

						tempData[i][0] = this.myDB.getRs().getString("mem_numb");
						tempData[i][1] = this.myDB.getRs().getString("mem_type");
						tempData[i][2] = this.myDB.getRs().getString("cust_name");
						tempData[i][3] = this.myDB.getRs().getString("cust_surname");
						i++;
					}

					this.myDB.getRs().close();
					this.myDB.getStmt().close();
					this.myDB.getConn().close();

					// THIS CREATE A COPY OF THE LOCAL DATA TO THE ARRAY[][] SETTER IN MEMBER MENU
					
					this.memberMenuView.setTitles(tempData);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}

}

package app.model;

import java.sql.SQLException;

import app.database.Database;
import app.view.FindMemberView;
import customer.admin.DebitCreditCard;
import customer.admin.MembershipCard;
import customers.Customer;
import customers.MusicLovers;
import customers.PremiunLovers;
import customers.TvLovers;
import customers.VideoLovers;

public class FindMemberModel {

	private Database myBD;
	private Customer tempMember;
	
	public FindMemberModel(Database myBd) {
		
		this.myBD = myBd;
		
	}
	
	public boolean checkId(int id) {
		
			String query = "SELECT * FROM customers WHERE mem_numb = "+id+";";

			try {
				this.myBD.setRs(this.myBD.getStmt().executeQuery(query));

				if (this.myBD.getRs().isBeforeFirst()) {
					return true;
				}

				this.myBD.getRs().close();
				this.myBD.getStmt().close();
				this.myBD.getConn().close();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return false;
		
	}
	
	
	
	
	public Customer findId(int id) {
		
				// LOCAL DATA STORAGE
				String[] dataStr = new String[10];
				int[] dataInt = new int[2];
				
				String query = "SELECT * FROM customers WHERE mem_numb = "+id+";";
				
				try {
					
						this.myBD.setRs(this.myBD.getStmt().executeQuery(query));
						
						while (this.myBD.getRs().next()) {
						
						dataStr[0] = this.myBD.getRs().getString("mem_type");
						dataStr[1] = this.myBD.getRs().getString("cust_name");
						dataStr[2] = this.myBD.getRs().getString("cust_surname");
						dataStr[3] = this.myBD.getRs().getString("birthday");
						dataStr[4] = this.myBD.getRs().getString("email");
						dataStr[5] = this.myBD.getRs().getString("card_type");
						dataStr[6] = this.myBD.getRs().getString("card_num");
						dataStr[7] = this.myBD.getRs().getString("card_holder");
						dataStr[8] = this.myBD.getRs().getString("exp_day");
						dataStr[9] = this.myBD.getRs().getString("card_cvv");
						dataInt[0] = this.myBD.getRs().getInt("points");
						dataInt[1] = this.myBD.getRs().getInt("titles_rented");
						
						
						}
					
					DebitCreditCard tempCard = new DebitCreditCard(dataStr[5],
																   dataStr[6],
																   dataStr[7],
																   dataStr[8],
																   dataStr[9]);
					
					MembershipCard tempMemb = new MembershipCard(tempCard, dataInt[0], false);
										
					if (dataStr[0].equals("MusicLovers")) {
						
						this.tempMember = new MusicLovers(dataStr[1],
														dataStr[2],
														dataStr[3],
														dataStr[4],
														tempMemb,
														tempCard);
						
					} else if (dataStr[0].equals("VideoLovers")) {
						
						this.tempMember = new VideoLovers(dataStr[1],
														dataStr[2],
														dataStr[3],
														dataStr[4],
														tempMemb,
														tempCard);
						
					}else if (dataStr[0].equals("TvLovers")) {
						
						this.tempMember = new TvLovers(dataStr[1],
													 dataStr[2],
													 dataStr[3],
													 dataStr[4],
													 tempMemb,
													 tempCard);
										
					}else {
						
						this.tempMember = new PremiunLovers(dataStr[1],
								 						  dataStr[2],
								 						  dataStr[3],
								 						  dataStr[4],
								 						  tempMemb,
								 						  tempCard);
						
					}
					
					this.tempMember.setId(id);
					this.tempMember.setNumbRented(dataInt[0]);
					
					this.myBD.getRs().close();
					this.myBD.getStmt().close();
					this.myBD.getConn().close();

					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				return this.tempMember;
		
		
		
	}
}

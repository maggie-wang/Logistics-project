package prjX.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import prjX.entities.ShipDAO;
import prjX.entities.TruckDAO;

public class DBMethods extends Database {
	public static DBMethods methods = new DBMethods();
	
	public Integer getDockByVolumeType(String volType){ 
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM TypeTable WHERE VolumeType='" + volType + "'";
				stm = con.createStatement();
				   rs = stm.executeQuery(sql);
				   while(rs.next()){
					   return rs.getInt("DockID");
				   }
			   }catch(SQLException sqle){
				   System.err.println(sqle.getMessage());
			   }finally{
				   try {
					rs.close();
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return null;
	}
	

	public String getShipVol1(String Name, int ID){
		if(hasConnection()){
			String sql = "SELECT VolumeType FROM Ships WHERE Name='" + Name + "' AND ID='" + ID + "';";
			Statement stm = null;
			ResultSet rs = null;
			try{
				stm = con.createStatement(); 
				rs = stm.executeQuery(sql);
				while(rs.next()){
						String VolT = rs.getString("VolumeType");
						return VolT;
						//System.out.println(rs.getString("VolumeType"); //getDockByVolumeType(rs.getString("VolymType");
				   }
				
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public List<String> getOKTrucks(String shipVolume){ 		
		String  truck = getTruckVol(shipVolume);
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Trucks WHERE Type='" + truck + "' AND Status='OK'";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				List<String> array = new ArrayList<String>();
				while(rs.next()){
					int id = rs.getInt("ID");
					String type = rs.getString("Type");
					String status = rs.getString("Status");
					String line = "ID:" + id + " Type:" + type + " Status:" + status;
					array.add(line);
				}
				return array;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	//YUWA
	public ResultSet getRep(String firstDate, String secondDate){ 
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			
				String sql = "SELECT * FROM Ship_Booked WHERE Date BETWEEN '" + firstDate + "' AND '" + secondDate + "';";
				try {
					stm = con.createStatement();
					rs = stm.executeQuery(sql);
					return rs;
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}

		return rs;	

	}

	
	public List<String> getReport(String firstDate, String secondDate){ //ny pga uppdatering /mr

		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Ship_Booked WHERE Date BETWEEN '" + firstDate + "' AND '" + secondDate + "';";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				List<String> array = new ArrayList<String>();
				while(rs.next()){
					String date = rs.getString("Date");
					String ship = rs.getString("ShipName");
					int shipId = rs.getInt("ShipID");					
					int dock = rs.getInt("DockID_00");
					String time = "00-08";
					if(rs.wasNull()){
						dock = rs.getInt("DockID_08");
						time = "08-16";
						if(rs.wasNull()){
							dock = rs.getInt("DockID_16");
							time = "16-00";
						}

					}//gjorde som Kim hade gjort f�rst (med return), men d� kan man bara f� f�rsta posten, kan man returnera n�got b�ttre?
					//System.out.println("Date: " + date + " Time: " + time + " Dock: " + dock + " ShipID: " + shipId + " ShipName: " + ship);
					String test = "Date: " + date + " Time: " + time + " Dock: " + dock + " ShipID: " + shipId + " ShipName: " + ship;
					array.add(test);
				}
				return array;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

		return null;	

	}
	
	//mr: public void bookDock(String dock_0, String date, String time, String sName, int SID, int PID, String lastName, int PP, String TID, int TP){
	public void bookDock(int dockId, String date, String time, String sName, int SID){ //uppdaterad mr
		if(hasConnection()){
			Statement stm = null;
			//mr: ResultSet rs = null;
			String sql = null;
			try{
				//mr:String sql = "INSERT INTO " + dock_0 + " (Date, TimeInterval, ShipName, ShipID, PersonID, Lastname, PersonPrice, TruckID, TruckPrice)" + 
				//"VALUES ('"+ date +"', '"+ time +"', '" + sName + "', "+ SID +", "+ PID +", '"+ lastName +"', "+ PP +", '"+ TID +"', "+ TP+");";
				if(time.equals("00-07")){
					sql = "INSERT INTO Ship_Booked" + " (Date, DockID_00, ShipName, ShipID)" + 
							"VALUES ('"+ date +"', '"+ dockId +"', '" + sName + "', "+ SID +");";
				}
				else if(time.equals("08-16")){
					sql = "INSERT INTO Ship_Booked" + " (Date, DockID_08, ShipName, ShipID)" + 
							"VALUES ('"+ date +"', '"+ dockId +"', '" + sName + "', "+ SID +");";
				}
				else{
					sql = "INSERT INTO Ship_Booked" + " (Date, DockID_16, ShipName, ShipID)" + 
							"VALUES ('"+ date +"', '"+ dockId +"', '" + sName + "', "+ SID +");";
				}
				
				stm = con.createStatement();
				stm.executeUpdate(sql); //�ndrad inget resultset eller Query vid INSERT /mr
				
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	
//YUWA
	public ResultSet getDock(){ 
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;			
			try{
				String sql = "SELECT Date, DockID_00, DockID_08, DockID_16 from Ship_Booked";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				return rs;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}
			
		}
		return rs;
	}
	
	public void clearTestBookDock(int dockId, String date, String time, String sName, int SID){ // bara f�r att kunna �terst�lla efter test av INSERT /mr
		String sql = "DELETE FROM Ship_Booked WHERE ShipID = '" + SID + "'";
		Statement stm = null;
		try{
			stm = con.createStatement();
			stm.executeUpdate(sql);
			}catch(Exception e){
			System.err.println(e.getMessage());
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}
	/*
	public void addPeps(String name, String lastName, String license, String schedule, String status){
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "INSERT INTO Staff (Name, LastName, License, Schedule, Status)"
						   + "VALUES ('"+ name +"', '"+ lastName  +"', '"+ license +"', '"+ schedule +"', '"+ status +"');";
			stm = con.createStatement();
			stm.executeUpdate(sql);
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	*/
	public void removePeps(){
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = " "; //DO more shit here kim you lazy ball
			stm = con.createStatement();
			stm.executeUpdate(sql);
			}catch(SQLException sqle){
				
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<String> getPeps(String LastName){
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Staff WHERE Lastname='"+ LastName + "';";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				List<String> array = new ArrayList<String>();
				while(rs.next()){
					String PID = rs.getString("ID");
					String Name = rs.getString("Name");
					String LName = rs.getString("LastName");
					String License = rs.getString("License");
					String Schedule = rs.getString("Schedule");
					String Status = rs.getString("Status");	
					String line = "ID: " + PID + " Name: " + Name + " LastName: " + LName + " License: " + License + " Schedule: " + Schedule + " Status: " + Status;	
					array.add(line);
				}
				return array;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	//YUWA
	public ResultSet getAllPeps(){
		
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Staff";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				return rs; 
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}
		}
		return null;
	}
	//YUWA
	public ResultSet showAllShips(){
		
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Ships";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				return rs; 
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}
		}
		return null;
	}

	//YUWA
	public ResultSet showAllTrucks(){
		
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Trucks";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				return rs; 
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}
		}
		return null;
	}
	
	public int addPeps(String name, String lastName, String license, String schedule, String status) throws ForeignKeyException {
		int rows = -1;
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "INSERT INTO Staff (Name, LastName, License, Schedule, Status)"
						   + "VALUES ('"+ name +"', '"+ lastName  +"', '"+ license +"', '"+ schedule +"', '"+ status +"');";
			stm = con.createStatement();
			rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				//System.err.println(sqle.getMessage()); kan f�rvirra anv�ndare
				throw new ForeignKeyException();
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}	
	
	public int removePeps(String ID, String lastName){
		int rows = -1;
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "DELETE FROM Staff WHERE ID='"+ ID +"' AND LastName='"+ lastName +"';";
			stm = con.createStatement();
			rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}	
	
	public List<String> getShip(String Name){ //�ndrade till s�kning p� bara namn och returnerar lista /mr
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Ships WHERE Name='"+ Name + "';";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				List<String> array = new ArrayList<String>();
				while(rs.next()){
					String PID = rs.getString("ID");
					String SName = rs.getString("Name");
					String SCompany = rs.getString("Company");
					String line = "ID: " + PID + " Name: " + SName + " Company: " + SCompany; 
					array.add(line);
				}
				return array;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public List<ShipDAO> getAllShips(){
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			ShipDAO ship = null;
			List<ShipDAO> ships = new ArrayList<ShipDAO>();
			try{
				String sql = "SELECT * FROM Ships";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				
				while(rs.next()){
					
					ship.setId(rs.getInt("ID"));
					ship.setName(rs.getString("Name"));
					ship.setCompany(rs.getString("Company"));
					ship.setVolumeType(rs.getString("VolumeType")); 
					ships.add(ship);
				}
				return ships;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public List<TruckDAO> getAllTrucks(){
		if(hasConnection()){
			Statement stm = null;
			ResultSet rs = null;
			try{
				String sql = "SELECT * FROM Trucks";
				stm = con.createStatement();
				rs = stm.executeQuery(sql);
				TruckDAO truck = new TruckDAO();
				List<TruckDAO> trucks = new ArrayList<TruckDAO>();
				while(rs.next()){
					truck.setId(rs.getInt("ID"));
					truck.setType(rs.getString("Type"));
					truck.setStatus(rs.getString("Status")); 
					trucks.add(truck);
				}
				return trucks;
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					rs.close();
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public int addTrucks(String type, String status) throws ForeignKeyException{
		int rows = -1;
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "INSERT INTO Trucks (Type, Status) VALUES ('"+ type +"', '"+ status +"');"; 
			stm = con.createStatement();
			rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				//System.err.println(sqle.getMessage()); kan f�rvirra anv�ndare
				throw new ForeignKeyException();
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}	
	
	public int removeTrucks(String ID, String Type){
		int rows = -1; 
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "DELETE FROM Trucks WHERE ID='"+ ID +"' AND Type='"+ Type +"';";
				stm = con.createStatement();
				rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}
	
	public int removeShip(String ID, String name){
		int rows = -1;
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "DELETE FROM Ships WHERE ID='"+ ID +"' AND Name='"+ name +"';";
				stm = con.createStatement();
				rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				System.err.println(sqle.getMessage());
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}
	
	public int addShip(String name, String comp, String volType) throws ForeignKeyException{
		int rows = -1;
		if(hasConnection()){
			Statement stm = null;
			try{
				String sql = "INSERT INTO Ships (Name, Company, VolumeType) VALUES ('"+ name +"', '"+ comp +"', '"+ volType +"');";
				stm = con.createStatement();
				rows = stm.executeUpdate(sql);
			}catch(SQLException sqle){
				//System.err.println(sqle.getMessage()); kan f�rvirra anv�ndare
				throw new ForeignKeyException();
			}finally{
				try{
					stm.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return rows;
	}
	public String getTruckVol(String volume){ //n�e... varf�r? Finns i TypeTable /mr
		
		switch(volume){
			case "A005":
				return "A001";
			case "AA07":
				return "AA01";
			case "B005":
				return "B001";
			case "BB07":
				return "BB01";
			case "C005":
				return "C001";
			case "CC07":
				return "CC01";
			case "CCC5":
				return "CCC1";
			case "K007":
				return "K001";
		}
		return null;
	}
}

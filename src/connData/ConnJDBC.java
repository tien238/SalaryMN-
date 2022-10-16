package connData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import login.ChangePass;
import model.People;

public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3306/sararymanager";
	static String user="root";
	static String password="";
	public static Connection getConnection() {// connection function
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		}catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
}
	public static HashMap<String,String> findAllAccount(){
		HashMap<String,String> logininfo = new HashMap<String,String>();
		String query="select*from login";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				
				 String userName = rs.getString("userName");
				 String passWord = rs.getString("passWord");
				 logininfo.put(userName, passWord);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return logininfo;
	}
	
	public static List<People>findAll(){
		List<People>peoplesList= new ArrayList<>();
		String query="select*from people";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				 People people = new People(rs.getInt("id"),rs.getString("ten"),rs.getInt("tuoi"),rs.getInt("gioitinh"),
						rs.getFloat("luong"),rs.getFloat("thuong"),rs.getFloat("phat"),rs.getFloat("tong"));
				peoplesList.add(people);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return peoplesList;
	}
	public static List<People>getTopExellent(){
		List<People>peoplesList= new ArrayList<>();
		List<People> getTop = new ArrayList<>();
		String query="select*from people";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			Float top10 = 0f;
			while(rs.next()) {
				 People people = new People(rs.getInt("id"),rs.getString("ten"),rs.getInt("tuoi"),rs.getInt("gioitinh"),
						rs.getFloat("luong"),rs.getFloat("thuong"),rs.getFloat("phat"),rs.getFloat("tong"));
				
				peoplesList.add(people);
			}
			Collections.sort(peoplesList, new Comparator<People>() {
	            @Override
	            public int compare(People o1, People o2) {
	            	Float a = o1.getThuong() - o1.getPhat();
	            	Float b = o2.getThuong() - o2.getPhat();
	                return b.compareTo(a);
	            }

	           
	        });
			 if(peoplesList.size() >= 10) {
				 top10 = peoplesList.get(9).getThuong()-peoplesList.get(9).getPhat();
				 System.out.println(top10);
			 }else {
				top10 = peoplesList.get(peoplesList.size()-1).getThuong()-peoplesList.get(peoplesList.size()-1).getPhat();
			}
			 for(People p:peoplesList) {
				 if(p.getThuong()-p.getPhat() >= top10) {
					 getTop.add(p);
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return getTop;
	}
	public static void insert(People people) {
		String query="insert into people(ten, tuoi,gioitinh, luong, thuong, phat , tong) values(?,?,?,?,?,?,?)";
		try {
                    
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, people.getTen());
			pstmt.setInt(2, people.getTuoi());
			pstmt.setInt(3, people.getGioitinh());
			pstmt.setFloat(4, people.getLuong());
			pstmt.setFloat(5, people.getThuong());
                        pstmt.setFloat(6, people.getPhat());
                        pstmt.setFloat(7, people.getTong());

			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(People p) {
		String query="delete from people where id='"+p.getId()+"'";
		try {
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<People>findByName(People p) {
		List<People>peoplesl= new ArrayList<>();
		String query="select*from people where ten like '%"+p.getTen()+"%'";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				People people = new People(rs.getInt("id"),rs.getString("ten"),rs.getInt("tuoi"),rs.getInt("gioitinh"),
						rs.getFloat("luong"),rs.getFloat("thuong"),rs.getFloat("phat"),rs.getFloat("tong"));
				
				peoplesl.add(people);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return peoplesl;
        }
	public static void update(People p) {
		
		
		String query="Update people set ten=?,tuoi=?,gioitinh=?,luong=?,thuong=?,phat= ?,tong= ? where id='"+p.getId()+"'";
		try {
			Connection connection=getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, p.getTen());
			pstmt.setInt(2, p.getTuoi());
			pstmt.setInt(3, p.getGioitinh());
			pstmt.setFloat(4, p.getLuong());
			pstmt.setFloat(5, p.getThuong());
                        pstmt.setFloat(6, p.getPhat());
                        pstmt.setFloat(7, p.getTong());

            pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void ChangePass(String username, String password) {
		String query="Update login set passWord=? where userName='"+username+"'";
		try {
			System.out.println(query);
			Connection connection=getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1,password);
			System.out.println(query);
            pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}


	
}
package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class userdao {

    private String dbUrl = "jdbc:postgresql://icovid_db_user:IeCDe94K0MwPo1SLAENBaKSdgkOKDvrI@dpg-cu7skld6l47c73frnl20-a/icovid_db?ssl=true";
    private String dbUname = "icovid_db_user";
    private String dbPassword = "IeCDe94K0MwPo1SLAENBaKSdgkOKDvrI"; 
    private String dbDriver = "org.postgresql.Driver";



	
	public void loadDriver(String dbDriver){
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Connection getConnection(){
		Connection con = null ;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			System.out.println("Database connection established successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to establish database connection.");
			e.printStackTrace();
		}
		return con;
	}
	
	//for register user
	public boolean insert(user user)
	{
		boolean res=false;
		loadDriver(dbDriver);
		Connection con = getConnection();
		String sql = "INSERT INTO users  (name, email, lat, lng, res) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setFloat(3, user.getLat());
		ps.setFloat(4, user.getLng());
		ps.setFloat(5, user.getRes());
		ps.executeUpdate();
		res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	public boolean validate(user user)
	{
		boolean status=false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT * FROM users WHERE email= ? ";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1,user.getEmail());
		
		ResultSet rs = ps.executeQuery();
		status= rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public  ArrayList<Float> getCoords()
	{
		ArrayList<Float> coords=new ArrayList<Float>();
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "SELECT lat,lng,res FROM users";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				coords.add(rs.getFloat("lat"));
				coords.add(rs.getFloat("lng"));
				coords.add(rs.getFloat("res"));
			}
			 //System.out.println(coords);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return coords;
	}
	
	public void insertRes(Float res, user user) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql="UPDATE users SET res=? WHERE email=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setFloat(1, res);
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

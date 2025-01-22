package register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userdao {
    private static final String DB_URL = "jdbc:postgresql://dpg-cu7skld6l47c73frnl20-a.frankfurt-postgres.render.com:5432/icovid_db?ssl=true";
    private static final String DB_USERNAME = "icovid_db_user";
    private static final String DB_PASSWORD = "IeCDe94K0MwPo1SLAENBaKSdgkOKDvrI";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load PostgreSQL driver: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public boolean insert(user user) {
        String sql = "INSERT INTO users (name, email, lat, lng, res) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setFloat(3, user.getLat());
            ps.setFloat(4, user.getLng());
            ps.setFloat(5, user.getRes());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean validate(user user) {
        String sql = "SELECT 1 FROM users WHERE email = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user.getEmail());
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error validating user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Float> getCoords() {
        ArrayList<Float> coords = new ArrayList<>();
        String sql = "SELECT lat, lng, res FROM users";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                coords.add(rs.getFloat("lat"));
                coords.add(rs.getFloat("lng"));
                coords.add(rs.getFloat("res"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving coordinates: " + e.getMessage());
            e.printStackTrace();
        }
        return coords;
    }

    public boolean insertRes(Float res, user user) {
        String sql = "UPDATE users SET res = ? WHERE email = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setFloat(1, res);
            ps.setString(2, user.getEmail());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating user result: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

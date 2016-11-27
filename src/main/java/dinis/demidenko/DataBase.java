package dinis.demidenko;

import java.sql.*;



public class DataBase {

    public Connection getDBConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/finance";
        String password = "0000";
        String username = "root";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }


    public void addBD(String str){
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            String query = str;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int up(String table){
        int sum = 0;
        try {
            PreparedStatement ps = getDBConnection().prepareStatement("SELECT * FROM " + table);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                sum = sum + rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("eeeeeee");
        }
        return sum;
    }
}

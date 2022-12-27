import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:8889/test","root","root");
            /*PreparedStatement ps=con.prepareStatement("select * from test.dao.entities.Client");
            ResultSet rs=ps.executeQuery();
            ArrayList<String> data=new ArrayList<String>();*/
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO Client (name, adresse) VALUES ('test', 'test')");
            //from result to array
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
    }

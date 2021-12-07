package connector;

import javafx.collections.ObservableList;
import support_class.User;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {
    public DatabaseConnector() {
        DatabaseData conData = new DatabaseData();
        try (
                Connection con = DriverManager.getConnection(
                        DatabaseData.getURL(),
                        DatabaseData.getUSER(),
                        DatabaseData.getPASSWORD())
        ) {
            //System.out.println("Connection OK");
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection NOK");
            e.printStackTrace();
        }
    }

    public void InsertData(String firstname, String lastname, int age, double height, double weight){
        try (Connection con = DriverManager.getConnection(
                DatabaseData.getURL(),
                DatabaseData.getUSER(),
                DatabaseData.getPASSWORD())
        ){
            System.out.println("Connection OK");
            String insertData = "INSERT INTO user_data"+
                    "(firstname,lastname,age,height,weight)" +
                    "VALUES" +
                    "(?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(insertData);
            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.setInt(3,age);
            ps.setDouble(4,height);
            ps.setDouble(5,weight);
            ps.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Connection NOK");
            e.printStackTrace();
        }
    }

    public ArrayList<User> GetUser(){
        ArrayList<User> userList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                DatabaseData.getURL(),
                DatabaseData.getUSER(),
                DatabaseData.getPASSWORD())
        ) {
            String query = "SELECT * FROM user_data;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                //String user = rs.getInt("id") + " "+ rs.getString("firstname") + " " + rs.getString("lastname");
                userList.add(new User(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("age"),
                        rs.getDouble("height"),
                        rs.getDouble("weight")));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection NOK");
            e.printStackTrace();
        }
        return userList;
    }
}

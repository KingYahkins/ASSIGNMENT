package org.yltech.logindb.DAO;

import org.yltech.logindb.db.Database;
import org.yltech.logindb.models.User;

import java.sql.*;

public class UserDao {

    private final Database db =new Database();
    // create tables in the database
    // insert data to tables
    // authentication(get)

    public void Create(){
        String sql = "CREATE TABLE IF NOT EXISTS USER(" +
                "id int primary key auto_increment," +
                "username varchar(50) not null," +
                "password varchar(50) not null unique)";

        try{
            Connection conn = db.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("created");
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }


    public void insert(String username,String password){
        String sql = "INSERT INTO USER(username,password)" +
                "VALUES(?,?)";
        try{
            Connection conn = db.getConnection();
            PreparedStatement prep = conn.prepareStatement(sql);

            prep.setString(1,username);
            prep.setString(2,password);
            prep.executeUpdate();
            System.out.println("inserted ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User authenticate(String username,String password){
        String sql = "SELECT username,password from user where username =? and password=?";

        User users = null;

        try(Connection conn = db.getConnection())
        {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1,username);
            prep.setString(2,password);

            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()){
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");

                users = new User(user,pass);

            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

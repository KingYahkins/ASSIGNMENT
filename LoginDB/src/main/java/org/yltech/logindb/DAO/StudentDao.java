package org.yltech.logindb.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.yltech.logindb.db.Database;
import org.yltech.logindb.models.Student;

import javax.xml.transform.Result;
import java.sql.*;

public class StudentDao {

    private Database db = new Database();

    // insert data to the student table

    public void insert(String firstname,String lastname, String course,String index,int age, long phone){
        String sql ="insert into students (firstname,lastname,course,indexNo,age,phone)" +
                "values(?,?,?,?,?,?)";

        try(Connection conn = db.getConnection()) {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1,firstname);
            prep.setString(2,lastname);
            prep.setString(3,course);
            prep.setString(4,index);
            prep.setInt(5,age);
            prep.setLong(6,phone);
            prep.executeUpdate();
            System.out.println("value inserted");
        } catch (SQLException e) {
            System.out.println("error " +e.getMessage());
        }
    }

    public ObservableList<Student> students = FXCollections.observableArrayList();

    public ObservableList<Student> getDetails(){
        String sql = "Select firstname,lastname,course,indexNo,age,phone from students";
        students.clear();
        Student student = null;
        try(Connection conn= db.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()){
                String fname = result.getString("firstname");
                String lname = result.getString("lastname");
                String course = result.getString("course");
                String index = result.getString("indexNo");
                int age = result.getInt("age");
                long phone = result.getLong("phone");

                student = new Student(fname,lname,course,index,age,phone);
                students.add(student);
            }


        } catch (SQLException e) {

            System.out.println("error " +e.getMessage());
        }
        return students;
    }

}

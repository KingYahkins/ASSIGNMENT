package org.example.logindb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.yltech.logindb.DAO.StudentDao;
import org.yltech.logindb.models.Student;

import java.io.IOException;

public class MainController {

    @FXML
    private TextField firstname,lastname,index,age,phone,course;

    @FXML
    private Button saveBtn,Clear,showBtn;

    public void save(){
        StudentDao dao = new StudentDao();
        String fname = firstname.getText()==null ?"": firstname.getText();
        String lname = lastname.getText()==null ?"": lastname.getText();
        String ind = index.getText() == null ? "": index.getText();
        String Age = age.getText() ==null ?"": age.getText();
        String num = phone.getText()==null ? "" : phone.getText();
        String cour = course.getText()== null ? "": course.getText();


        if (fname.isEmpty() || lname.isEmpty() || ind.isEmpty() || cour.isEmpty() || Age.isEmpty() || num.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("enter valid values");
            alert.showAndWait();
            clear();
            return;
        }

        int age1 = Integer.parseInt(Age);
        long num1 = Long.parseLong(num);
        dao.insert(fname,lname,cour,ind,age1,num1);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("value status");
        alert.setContentText("value inserted");
        alert.showAndWait();
        clear();

    }

    public void clear(){
        firstname.clear();
        lastname.clear();
        index.clear();
        age.clear();
        phone.clear();
        course.clear();
    }

    public void show() throws IOException {

        Stage stage = (Stage) showBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("show.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 450);
//        scene.getStylesheets().add(getClass().getResource("/org/yltech/logindb/style.css").toExternalForm());
        stage.setTitle("Details");
        stage.setScene(scene);
        stage.show();
    }
}

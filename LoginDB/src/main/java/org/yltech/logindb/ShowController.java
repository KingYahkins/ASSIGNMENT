package org.example.logindb;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.yltech.logindb.DAO.StudentDao;
import org.yltech.logindb.models.Student;

public class ShowController {
    @FXML
    private TableView<Student> tableview;
    @FXML
    private TableColumn<Student,String> fnameCol,lnameCol,courseCol,indexCol,ageCol,phoneCol;


    public void initialize(){
        ObservableList<Student> student = new StudentDao().getDetails();

        fnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableview.setItems(student);

    }
}

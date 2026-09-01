package org.yltech.logindb;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.yltech.logindb.DAO.UserDao;
import org.yltech.logindb.models.User;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField username,password;
        @FXML
    private Button signIn;

    private final UserDao dao = new UserDao();

    // sign-in function
    @FXML
    public void signIn(){
        String username = this.username.getText()==null ? "" : this.username.getText();
        String password = this.password.getText()==null ? "" : this.password.getText();

        if (username.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("invalid input");
            alert.showAndWait();
            return;
        }

        signIn.setDisable(true);
        signIn.setText("authenticating");

//        new Thread(()-> Platform.runLater(()->{
            User user = dao.authenticate(username,password);
            if (user != null){
                try {
                    showMain();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("invalid input");
                alert.showAndWait();
                signIn.setDisable(false);
                signIn.setText("Sign in");
            }


//        })).start();
    }

    private void showMain() throws IOException {
        Stage stage = (Stage) signIn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 824, 450);
//        scene.getStylesheets().add(getClass().getResource("/org/yltech/logindb/style.css").toExternalForm());
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }
}

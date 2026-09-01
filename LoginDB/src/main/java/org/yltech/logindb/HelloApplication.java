package org.yltech.logindb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 687, 400);
        scene.getStylesheets().add(getClass().getResource("/org/yltech/logindb/style.css").toExternalForm());
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
    }
}

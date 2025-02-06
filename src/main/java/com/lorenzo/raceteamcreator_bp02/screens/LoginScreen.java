package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.sql.Connection;

public class LoginScreen {

    private StackPane container = new StackPane();
    private Scene LoginScene;
    private VBox root = new VBox();
    private Label title = new Label("Login");
    private TextField username = new TextField();
    private TextField password = new TextField();
    private Button login = new Button("Login");
    private Button register = new Button("Register");
    private Database db = new Database();
    private Connection conn = db.getConn();
    private UserController uc = new UserController(db);

    public LoginScreen(Stage LoginStage) {
        title.setId("title");
        username.setId("username");
        password.setId("password");
        login.setId("login");
        register.setId("register");

        Scene scene = new Scene(container, 800, 600);
        LoginScene = scene;

        root.setMaxSize(300, 300);
        root.setMinSize(200, 300);

        container.getChildren().add(root);

        root.getChildren().add(title);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(login);
        root.getChildren().add(register);

        String css = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/LoginScreen.css").toExternalForm();
        scene.getStylesheets().add(css);

        login.setOnAction(e -> {
            if (uc.loginUser()){
                System.out.println("Logged in");
            } else {
                System.out.println("Not logged in");
            }
//            new HomeScreen(LoginStage);
        });

        register.setOnAction(e -> {
            uc.registerUser();
        });


        LoginStage.setResizable(false);
        LoginStage.setTitle("Login");
        LoginStage.setScene(scene);
        LoginStage.show();
    }

    public Scene getLoginScene() {
        return LoginScene;
    }

    public void setLoginScene(Scene loginScene) {
        LoginScene = loginScene;
    }
}

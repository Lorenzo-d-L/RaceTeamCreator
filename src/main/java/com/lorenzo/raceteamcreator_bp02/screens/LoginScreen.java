package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.sql.Connection;

public class LoginScreen {

    private StackPane container = new StackPane();
    private Scene LoginScene;
    private VBox root = new VBox();
    private Label title = new Label("Login");
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private Object User;
    private Button login = new Button("Login");
    private Button register = new Button("Register");
    private Database db = new Database();
    private Connection conn = db.getConn();
    private UserController uc = new UserController(db);
    private ImageView backgroundImage;

    public LoginScreen(Stage LoginStage) {
        title.setId("title");
        username.setId("username");
        password.setId("password");
        login.setId("login");
        register.setId("register");
        container.setId("container");

        Scene scene = new Scene(container, 800, 600);
        LoginScene = scene;

        backgroundImage = new ImageView(
                new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm())
        );

        Rectangle darkOverlay = new Rectangle(800, 600);
        darkOverlay.setId("darkOverlay");

        StackPane backgroundPane = new StackPane();
        backgroundPane.getChildren().addAll(backgroundImage, darkOverlay);



        root.setMaxSize(300, 300);
        root.setMinSize(200, 300);

        container.getChildren().add(backgroundPane);
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
            new HomeScreen(LoginStage);
        });

//        register.setOnAction(e -> {
//            uc.registerUser(this);
//        });


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

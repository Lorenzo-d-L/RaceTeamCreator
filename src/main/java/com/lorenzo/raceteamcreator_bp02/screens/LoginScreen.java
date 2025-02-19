package com.lorenzo.raceteamcreator_bp02.screens;

import com.lorenzo.raceteamcreator_bp02.classes.Database;
import com.lorenzo.raceteamcreator_bp02.classes.UserController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.sql.Connection;

public class LoginScreen {

    private StackPane container;
    private StackPane backgroundPane;
    private Scene LoginScene;
    private VBox root;
    private Label title;
    private TextField username;
    private PasswordField password;
    private Button login;
    private Button register;
    private Database db;
    private UserController uc;
    private ImageView backgroundImage;

    // Create the login screen
    public LoginScreen(Stage LoginStage) {
        // Create the layout
        container = new StackPane();
        root = new VBox();
        title = new Label("Login");
        username = new TextField();
        password = new PasswordField();
        login = new Button("Login");
        register = new Button("Register");
        db = new Database();
        uc = new UserController(db);

        title.setId("title");
        username.setId("username");
        password.setId("password");
        login.setId("login");
        register.setId("register");
        container.setId("container");

        // Add the css file and create the scene
        String styleLogin = this.getClass().getResource("/com/lorenzo/raceteamcreator_bp02/stylesheet/LoginScreen.css").toExternalForm();
        Scene scene = new Scene(container, 800, 600);
        scene.getStylesheets().add(styleLogin);

        // Add the background image
        backgroundImage = new ImageView(
                new Image(getClass().getResource("/com/lorenzo/raceteamcreator_bp02/icons/HoofdLogo.png").toExternalForm())
        );

        // Add the dark overlay to make the text more readable
        Rectangle darkOverlay = new Rectangle(800, 600);
        darkOverlay.setId("darkOverlay");

        // Add the background image and the dark overlay to the background pane
        backgroundPane = new StackPane();
        backgroundPane.getChildren().addAll(backgroundImage, darkOverlay);

        root.setMaxSize(300, 300);
        root.setMinSize(200, 300);

        // Add the items to the container
        container.getChildren().add(backgroundPane);
        container.getChildren().add(root);

        // Add the items to the layout
        root.getChildren().add(title);
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(login);
        root.getChildren().add(register);

        // If the user is logged in, go to the home screen
        // Else show an alert that shows what went wrong
        login.setOnAction(e -> {
            uc.setEmail(username.getText());
            uc.setPassword(password.getText());
            if (uc.loginUser()) {
                System.out.println("User logged in");
                new HomeScreen(LoginStage);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Login");
                alert.setHeaderText("Login failed");
                alert.setContentText("username or password incorrect, please try again");
                alert.showAndWait();
                System.out.println("User not logged in");
            }
        });

        // If the user is registered, show an alert that the user is registered
        // Else show an alert that shows what went wrong and what the user should do
        register.setOnAction(e -> {
           uc.registerUser(username.getText(), password.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register");
            alert.setHeaderText("User registered");
            alert.setContentText("User has been registered");
        });

        // Set the stage
        LoginStage.setResizable(false);
        LoginStage.setTitle("Login");
        LoginStage.setScene(scene);
        LoginStage.show();
    }
}

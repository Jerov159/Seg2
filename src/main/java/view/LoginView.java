package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginView() {
        // Establecer los márgenes y el espacio entre elementos
        this.setPadding(new Insets(20));
        this.setVgap(10);
        this.setHgap(10);

        // Crear los controles
        Label usernameLabel = new Label("Usuario:");
        usernameField = new TextField();

        Label passwordLabel = new Label("Contraseña:");
        passwordField = new PasswordField();

        loginButton = new Button("Iniciar Sesión");

        // Añadir los controles al GridPane
        this.add(usernameLabel, 0, 0);
        this.add(usernameField, 1, 0);
        this.add(passwordLabel, 0, 1);
        this.add(passwordField, 1, 1);
        this.add(loginButton, 1, 2);

        // Cargar la imagen de fondo
        Image backgroundImage = new Image(getClass().getResource("/images/Aesthetic.jpg").toExternalForm());
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );
        this.setBackground(new Background(background));
    }

    // Getters para los controles
    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}


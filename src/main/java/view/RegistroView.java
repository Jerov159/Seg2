package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegistroView extends VBox {
    private TextField nombreField;
    private TextField fechaNacimientoField;
    private Button registerButton;
    private Button backButton; // Añadido para el botón "Atrás"

    public RegistroView() {
        inicializarComponentes();
        configurarEstilos();
        organizarComponentes();
    }

    private void inicializarComponentes() {
        nombreField = new TextField();
        fechaNacimientoField = new TextField();
        registerButton = new Button("REGISTRARSE");
        backButton = new Button("ATRÁS"); // Inicializar el botón "Atrás"
    }

    private void configurarEstilos() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #2c3e50, #3498db);");

        String fieldStyle = "-fx-background-color: rgba(255, 255, 255, 0.8); -fx-border-color: transparent; " +
                "-fx-border-width: 0 0 2 0; -fx-text-fill: black; " +
                "-fx-prompt-text-fill: #666666;";
        nombreField.setStyle(fieldStyle);
        fechaNacimientoField.setStyle(fieldStyle);
        nombreField.setPromptText("Ingrese su Nombre");
        fechaNacimientoField.setPromptText("Ingrese su Fecha de Nacimiento (YYYY-MM-DD)");

        registerButton.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");

        backButton.setStyle("-fx-background-color: #2c3e50; -fx-text-fill: white; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");

        nombreField.setPrefHeight(40);
        fechaNacimientoField.setPrefHeight(40);
        registerButton.setPrefHeight(50);
        backButton.setPrefHeight(50);

        nombreField.setMaxWidth(300);
        fechaNacimientoField.setMaxWidth(300);
        registerButton.setMaxWidth(300);
        backButton.setMaxWidth(300);
    }

    private void organizarComponentes() {
        Label titleLabel = new Label("REGISTRARSE");
        titleLabel.setStyle("-fx-font-size: 32px; -fx-text-fill: white;");

        VBox formBox = new VBox(20);
        formBox.setAlignment(Pos.CENTER);
        formBox.getChildren().addAll(nombreField, fechaNacimientoField, registerButton, backButton);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20));
        container.setStyle("-fx-background-color: rgba(255, 255, 255, 0.2); -fx-background-radius: 10;");
        container.getChildren().addAll(titleLabel, formBox);

        this.getChildren().add(container);
    }

    // Getters
    public TextField getNombreField() { return nombreField; }
    public TextField getFechaNacimientoField() { return fechaNacimientoField; }
    public Button getRegisterButton() { return registerButton; }
    public Button getBackButton() { return backButton; } // Getter para el botón "Atrás"
}

package controller;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import util.DatabaseConnection;
import view.LoginView;
import view.RegistroView;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Registro {
    private RegistroView registroView;
    private Stage primaryStage; // Guardar la instancia de Stage

    // Constructor actualizado para aceptar RegistroView y Stage
    public Registro(RegistroView registroView, Stage primaryStage) {
        this.registroView = registroView;
        this.primaryStage = primaryStage; // Guardar la instancia de Stage
        initializeListeners();
    }

    private void initializeListeners() {
        registroView.getRegisterButton().setOnAction(e -> handleRegister());
        registroView.getBackButton().setOnAction(e -> openLoginWindow()); // Configurar el botón "Atrás"
    }

    private void handleRegister() {
        try {
            registerCliente();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Error al conectar con la base de datos", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void registerCliente() throws Exception {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String nombre = registroView.getNombreField().getText().trim();
        String fechaNacimientoStr = registroView.getFechaNacimientoField().getText().trim();

        // Validar que el nombre no esté vacío y sea un nombre propio
        if (nombre.isEmpty()) {
            showAlert("Error", "El nombre no puede estar vacío", Alert.AlertType.ERROR);
            return;
        }

        // Validar la fecha de nacimiento y verificar que el cliente sea mayor de edad
        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            showAlert("Error", "La fecha de nacimiento debe estar en formato YYYY-MM-DD", Alert.AlertType.ERROR);
            return;
        }

        // Calcular la edad del cliente
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);

        if (edad.getYears() < 18) {
            showAlert("Error", "Debe ser mayor de edad para registrarse", Alert.AlertType.ERROR);
            return;
        }

        // Comprobar si el cliente ya está registrado
        String checkCliente = "SELECT COUNT(*) FROM clientes WHERE nombre = ? AND fecha_nacimiento = ?";
        try (PreparedStatement checkStmt = connectDB.prepareStatement(checkCliente)) {
            checkStmt.setString(1, nombre);
            checkStmt.setDate(2, java.sql.Date.valueOf(fechaNacimiento)); // Convertir LocalDate a java.sql.Date

            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    showAlert("Error", "El cliente ya está registrado", Alert.AlertType.ERROR);
                    return;
                }
            }
        }

        // Insertar el nuevo cliente en la base de datos
        String insertCliente = "INSERT INTO clientes (nombre, fecha_nacimiento) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connectDB.prepareStatement(insertCliente)) {
            insertStmt.setString(1, nombre);
            insertStmt.setDate(2, java.sql.Date.valueOf(fechaNacimiento)); // Convertir LocalDate a java.sql.Date
            insertStmt.executeUpdate();
            showAlert("Éxito", "Cliente registrado exitosamente", Alert.AlertType.INFORMATION);
        } finally {
            connectDB.close();
        }
    }

    // Abre la ventana de inicio de sesión y cierra la ventana de registro
    private void openLoginWindow() {
        // Crear y mostrar la ventana de inicio de sesión
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        Scene loginScene = new Scene(loginView, 600, 400);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Inicio de Sesión");
    }
}


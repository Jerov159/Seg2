package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
public class Producto {
    private final SimpleIntegerProperty idProducto;
    private final SimpleStringProperty nombre;
    private final SimpleDoubleProperty precio;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty ubicacion;
    // Constructor
    public Producto(int idProducto, String nombre, double precio, String tipo, String ubicacion) {
        this.idProducto = new SimpleIntegerProperty(idProducto);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.tipo = new SimpleStringProperty(tipo);
        this.ubicacion = new SimpleStringProperty(ubicacion);
        System.out.println("Producto creado: ID=" + idProducto + ", Nombre=" + nombre + ", Precio=" + precio);
    }
    // Getters y setters
    public int getIdProducto() { return idProducto.get(); }
    public void setIdProducto(int idProducto) { this.idProducto.set(idProducto); }
    public SimpleIntegerProperty idProductoProperty() { return idProducto; }
    public String getNombre() { return nombre.get(); }
    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public SimpleStringProperty nombreProperty() { return nombre; }
    public double getPrecio() { return precio.get(); }
    public void setPrecio(double precio) { this.precio.set(precio); }
    public SimpleDoubleProperty precioProperty() { return precio; }
    public String getTipo() { return tipo.get(); }
    public void setTipo(String tipo) { this.tipo.set(tipo); }
    public SimpleStringProperty tipoProperty() { return tipo; }
    public String getUbicacion() { return ubicacion.get(); }
    public void setUbicacion(String ubicacion) { this.ubicacion.set(ubicacion); }
    public SimpleStringProperty ubicacionProperty() { return ubicacion; }
}

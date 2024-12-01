package PracticaExamen.Ejercicio2Chatgpt;

// Producto.java
public class Producto {
    private String nombre, codigo, categoria;
    private boolean disponible;

    public Producto(String nombre, String codigo, String categoria, boolean disponible) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
package co.edu.uniquindio.subasta.subastasuq.model;

public class Usuario {
    private String nombreUsuario;

    private String contrasena;

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsauario) {
        this.nombreUsuario = nombreUsauario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

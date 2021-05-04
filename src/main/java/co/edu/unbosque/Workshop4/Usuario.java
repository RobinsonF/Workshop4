package co.edu.unbosque.Workshop4;

import java.io.File;
import com.google.gson.annotations.Expose;
import java.io.InputStream;
import java.util.Date;


public class Usuario {
    @Expose
    private String nombre = "";
    @Expose
    private String descripcion = "";
    @Expose
    private String fecha = "";
    @Expose
    private String foto = "";

    public Usuario(){

    }

    public Usuario(String nombre, String descripcion, String fecha, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

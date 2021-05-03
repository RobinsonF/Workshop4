package co.edu.unbosque.Workshop4;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Usuario {

    private String nombre = "";

    private String descripcion = "";

    private Date fecha;
    private InputStream foto;

    public Usuario(){

    }
    public Usuario(String nombre, String descripcion, Date fecha, InputStream foto) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
}

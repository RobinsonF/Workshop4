/**
 * Bosque university Workshop4 package
 */
package co.edu.unbosque.Workshop4;

import java.io.File;
import com.google.gson.annotations.Expose;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Usuario {
    Random aleatorio = new Random();
    String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
    @Expose
    private String nombreUsuarion = "";
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

    public Usuario(String nombreUsuarion, String nombre, String descripcion, String fecha, String foto) {
        this.nombreUsuarion = nombreUsuarion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.foto = foto;
    }

    public boolean verificarNombreFoto(ArrayList<Usuario> listaUsuario, String nombreFoto){
        boolean verificar = false;
        for (int i = 0; i < listaUsuario.size(); i++) {
            if(listaUsuario.get(i).getFoto().equals(nombreFoto)){
                verificar = true;
                break;
            }
        }
        return verificar;
    }

    public String secuenciaAlfanumerica(){
        String cadena = "";
        int numero = 0;
        int forma = 0;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena;
    }

    public String getNombreUsuarion() {
        return nombreUsuarion;
    }

    public void setNombreUsuarion(String nombreUsuarion) {
        this.nombreUsuarion = nombreUsuarion;
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

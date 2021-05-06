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

/**
 * User Class
 * In this class we find the variables and methods necessary for the creation of the user and the registration of the pets
 */
public class Usuario {
    /**
     * random of random name, allows us to generate a random number
     */
    Random aleatorio = new Random();
    /**
     * variable of type string that contains the 26 letters of the alphabet, called alpha
     */
    String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
    @Expose
    /**
     * variable of type string that contains the user's name, its name is username
     */
    private String nombreUsuarion = "";
    /**
     * variable of type string that contains the name of the pet, its name is name
     */
    @Expose
    private String nombre = "";
    /**
     * variable of type string that contains the description of the pet, its name is name description
     */
    @Expose
    private String descripcion = "";
    /**
     * variable of type string that contains the date. his name is date
     */
    @Expose
    private String fecha = "";
    /**
     * variable of type string that contains the photo of the pet. his name is photo
     */
    @Expose
    private String foto = "";

    /**
     * The constructor of the user class is generated
     */
    public Usuario(){

    }

    /**
     * It refers to the attributes that were requested by the program, with this the constructor with the Username
     * parameters is generated. name, description, date and photo
     * @param nombreUsuarion
     * @param nombre
     * @param descripcion
     * @param fecha
     * @param foto
     */
    public Usuario(String nombreUsuarion, String nombre, String descripcion, String fecha, String foto) {
        this.nombreUsuarion = nombreUsuarion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.foto = foto;
    }

    /**
     * This method allows us to verify the name and the photo using the information stored in the arraylist.
     * @param listaUsuario
     * @param nombreFoto
     * @return boolean named verify
     */
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

    /**
     * The alphanumeric sequence method is of type string and allows us to create or generate an alphanumeric string in
     * case the name is repeated when registering
     * @return string name chain
     */
    public String secuenciaAlfanumerica(){
        String cadena = "";
        int numero = 0;
        int forma = 0;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena;
    }

    /**
     * Gets the value of the username attribute of type string
     * @return
     */
    public String getNombreUsuarion() {
        return nombreUsuarion;
    }

    /**
     * Update or modify the attribute username
     * @param nombreUsuarion
     */
    public void setNombreUsuarion(String nombreUsuarion) {
        this.nombreUsuarion = nombreUsuarion;
    }

    /**
     * Gets the value of the name attribute of type string
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Update or modify the attribute name
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the value of the description attribute of type string
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Update or modify the attribute description
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets the value of the date attribute of type string
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Update or modify the attribute date
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Gets the value of the picture attribute of type string
     * @return
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Update or modify the attribute picture
     * @param foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
}

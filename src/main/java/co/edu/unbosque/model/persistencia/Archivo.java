/**
 * Bosque university model-persistence package
 */
package co.edu.unbosque.model.persistencia;

import co.edu.unbosque.Workshop4.Usuario;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Persistence class
 * Data persistence is a means by which the application can retrieve information from a non-volatile storage system
 */
public class Archivo {
    public Archivo() {

    }

    /**
     * Write file method, this method allows us to write inside the ArrayList that we call User through the list
     * parameter
     * @param lista
     */
    public void escribirArchivo(ArrayList<Usuario> lista) {
        System.out.println("Entro al escribir");
        String DELIMITADOR = ",";
        String SALTO = "\n";
        FileWriter bw;
        try {
            bw = new FileWriter("C:\\Users\\Robinson\\Workshop4\\src\\main\\java\\Data\\pets.csv");

            for (Usuario pet : lista) {
                bw.append(SALTO);
                bw.append(pet.getNombreUsuarion());
                bw.append(DELIMITADOR);
                bw.append(pet.getNombre());
                bw.append(DELIMITADOR);
                bw.append(pet.getDescripcion());
                bw.append(DELIMITADOR);
                bw.append(String.valueOf(pet.getFecha()));
                bw.append(DELIMITADOR);
                bw.append(String.valueOf(pet.getFoto()));
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);

        }
    }

    /**
     * Read file method, this method allows us to read a file or files from the CSV using Java, the information stored
     * by the User ArrayList is read
     * @return
     */
    public ArrayList<Usuario> leerArchivo() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader("C:\\Users\\Robinson\\Workshop4\\src\\main\\java\\Data\\pets.csv"));
            String linea = bufferLectura.readLine();

            while (linea != null) {
                Usuario pet = new Usuario();
                String[] campos = linea.split(",");
                if (campos.length == 5) {
                    try {
                        pet.setNombreUsuarion(campos[0]);
                        pet.setNombre(campos[1]);
                        pet.setDescripcion(campos[2]);
                        pet.setFecha(campos[3]);
                        pet.setFoto(campos[4]);
                        lista.add(pet);
                    } catch (NumberFormatException e) {
                        System.out.println(e);

                    }
                }
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    System.out.println(e);

                    e.printStackTrace();
                }
            }
        }
        return lista;
    }
}

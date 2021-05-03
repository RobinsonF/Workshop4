package co.edu.unbosque.model.persistencia;

import co.edu.unbosque.Workshop4.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    private final String SAMPLE_CSV_FILE = "Data\\pets.csv";

    public Archivo() {

    }

    public void escribirArchivo(ArrayList<Usuario> lista) {
        System.out.println("Entro al escribir");
        String DELIMITADOR = ",";
        String SALTO = "\n";
        FileWriter bw;
        try {
            bw = new FileWriter(SAMPLE_CSV_FILE);

            for (Usuario pet : lista) {
                bw.append(SALTO);
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

}

/**
 * Bosque university Workshop4 package
 */
package co.edu.unbosque.Workshop4;

import co.edu.unbosque.model.persistencia.Archivo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "json", value = "/json")
/**
 * JsonServlet class
 * This class allows us to give a response to a JSON of the information stored in the application's servlet
 */
public class JsonServlet extends HttpServlet {
    ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    Archivo archivo = new Archivo();
    @Override
    /**
     * The deGet method allows us to return a JSON response from a servlet, it contains the parameters request and
     * response of the HttpServlet
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        listaUsuario = archivo.leerArchivo();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String jsonUsuarios = gson.toJson(listaUsuario);
        System.out.println(jsonUsuarios);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonUsuarios);
        out.flush();
    }
}

package co.edu.unbosque.Workshop4;


import co.edu.unbosque.model.persistencia.Archivo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

@WebServlet(name = "informacion", value = "/informacion")
@MultipartConfig
public class InformacionServlet extends HttpServlet {
    ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    Archivo archivo = new Archivo();
    public InformacionServlet(){
        listaUsuario = archivo.leerArchivo();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String nombreMascota = request.getParameter("nombreMascota");
        String descripcion = request.getParameter("descripcion");
        Part foto = request.getPart("foto");
        String fileName = Paths.get(foto.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = foto.getInputStream();
        request.getSession().setAttribute("nombreMascota", nombreMascota);
        request.getSession().setAttribute("descripcion", descripcion);
        request.getSession().setAttribute("foto", fileContent);
        Usuario usuario = new Usuario(nombreMascota, descripcion, null, fileContent);
        listaUsuario.add(usuario);
        archivo.escribirArchivo(listaUsuario);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String gson2 = gson.toJson(listaUsuario);
        System.out.println(gson2);
        request.getSession().setAttribute("json", gson2);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/welcome.jsp");
        dis.forward(request,response);
    }

}

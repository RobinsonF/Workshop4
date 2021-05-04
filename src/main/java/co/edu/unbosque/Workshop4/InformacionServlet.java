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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "informacion", value = "/informacion")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
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
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaHoy3 = new Date();
        Usuario usuario = new Usuario(nombreMascota, descripcion, String.valueOf(formatter3.format(fechaHoy3)), String.valueOf(fileName));
        listaUsuario.add(usuario);
        archivo.escribirArchivo(listaUsuario);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/welcome.jsp");
        dis.forward(request,response);
    }

}

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
import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "informacion", value = "/informacion")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class InformacionServlet extends HttpServlet {
    ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    Archivo archivo = new Archivo();
    private static final long serialVersionUID = 1L;

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "default.file";
    }
    public InformacionServlet(){
        listaUsuario = archivo.leerArchivo();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String nombreMascota = request.getParameter("nombreMascota");
        String descripcion = request.getParameter("descripcion");
        Part part = request.getPart("foto");
        String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";
        File uploadDir = new File(uploadPath);
        System.out.println(uploadPath + "\n" + uploadDir);
        String fileName = "";
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
                System.out.println(fileName);
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaHoy3 = new Date();
        Usuario usuario = new Usuario(nombreMascota, descripcion, String.valueOf(formatter3.format(fechaHoy3)), fileName);
        listaUsuario.add(usuario);
        archivo.escribirArchivo(listaUsuario);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/welcome.jsp");
        dis.forward(request,response);
    }

}

/**
 * Bosque university Workshop4 package
 */
package co.edu.unbosque.Workshop4;


import co.edu.unbosque.model.persistencia.Archivo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
/**
 * InformacionServlet class
 * The InformacionServlet class allows us to store the information of the downloads that the servlet allows us to do
 * inside an arraylist that has the user name, in addition to extending the httpServlet class
 */
public class InformacionServlet extends HttpServlet {
    ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    Archivo archivo = new Archivo();
    Usuario user = new Usuario();
    private static final long serialVersionUID = 1L;

    /**
     * class of type string of name get file name, this method is in charge of obtaining the photo entered in the data
     * requested by the program
     * @param part
     * @return default.file
     */
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "default.file";
    }

    /**
     * Servlet information method, this is responsible for saving or storing the information registered within the data
     * requested in the user arraylist within the userlist parameter, also allows us to save it in the file
     */
    public InformacionServlet(){
        listaUsuario = archivo.leerArchivo();
    }

    /**
     * DoPost method, this method is responsible for storing all the pet information to make the proper registration,
     * it contains the request and response parameters, which are derived from the HttpServlet
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        Cookie cookies2 = buscaCookie("user", cookies);
        String nombreUsuario = cookies2.getValue();
        request.getSession().setAttribute("usuarioCookie", nombreUsuario);
        System.out.println(nombreUsuario);
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
                String name = fileName.substring(fileName.indexOf("."),fileName.length());
                if(user.verificarNombreFoto(listaUsuario, fileName)){
                    fileName = user.secuenciaAlfanumerica() + name;
                }
                part.write(uploadPath + File.separator + fileName);
                System.out.println(fileName);
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaHoy3 = new Date();
        Usuario usuario = new Usuario(nombreUsuario, nombreMascota, descripcion, String.valueOf(formatter3.format(fechaHoy3)), fileName);
        listaUsuario.add(usuario);
        archivo.escribirArchivo(listaUsuario);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/welcome.jsp");
        dis.forward(request,response);
    }

    /**
     * SearchCookie method, this method is in charge of saving the cookies of the user who has registered, of
     * parameters it contains a user string and an arrangement called cookie
     * @param nombre
     * @param cookies
     * @return null
     */
    private Cookie buscaCookie(String nombre, Cookie[] cookies) {
        if (cookies == null)
            return null;

        for (int i = 0; i < cookies.length; i++)
            if (cookies[i].getName().equals(nombre))
                return cookies[i];
        return null;
    }
}


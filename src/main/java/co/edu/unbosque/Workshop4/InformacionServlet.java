package co.edu.unbosque.Workshop4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "informacion", value = "/informacion")
public class InformacionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String nombreMascota = request.getParameter("nombreMascota");
        String descripcion = request.getParameter("descripcion");
        String foto = request.getParameter("foto");
        PrintWriter out = response.getWriter();
        out.println("Nombre " + nombreMascota + "<br/>");
        out.println("Descripcion " + descripcion + "<br/>");
        out.println("Foto " +  foto);
        out.close();
    }

}

package co.edu.unbosque.Workshop4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookies", value = "/cookies")
public class Myservlet1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        String nombre = request.getParameter("user");
        try{
            PrintWriter out = response.getWriter();
            Cookie c1 = new Cookie("user",nombre);
            response.addCookie(c1);
            out.println("Bienvenido" + nombre);
            out.println("<br />");
            out.println("<a href='welcome'> View details</a>");
            out.close();

        } catch(Exception b){

        }
    }
}

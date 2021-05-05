package co.edu.unbosque.Workshop4;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookies", value = "/cookies")
public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        String nombre = request.getParameter("user");
        try{
            PrintWriter out = response.getWriter();
            Cookie c1 = new Cookie("user",nombre);
            response.addCookie(c1);
            System.out.println(nombre);
            RequestDispatcher dis = getServletContext().getRequestDispatcher("/welcome.jsp");
            dis.forward(request,response);
        } catch(Exception b){

        }
    }
}

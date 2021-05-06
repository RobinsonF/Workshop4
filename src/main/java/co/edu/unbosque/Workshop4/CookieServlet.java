/**
 * Bosque university Workshop4 package
 */
package co.edu.unbosque.Workshop4;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CookieServlet class
 * This class is used to declare a servlet, a servlet is a class in the Java programming language, used to extend the
 * capabilities of a server, it also extends an httpServlet which is a class that implements the Servlet interface, also
 * incorporating specific methods for web servers
 */
@WebServlet(name = "cookies", value = "/cookies")
public class CookieServlet extends HttpServlet {
    /**
     * The deGet method allows us to create user cookies, a cookie is a small piece of information that is saved between
     * multiple customer requests.
     * A cookie has a name, a unique value, and optional attributes such as a comment, path and domain qualifiers, a
     * maximum age, and a version number.
     * @param request
     * @param response
     */
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

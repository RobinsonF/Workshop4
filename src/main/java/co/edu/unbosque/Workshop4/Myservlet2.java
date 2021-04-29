package co.edu.unbosque.Workshop4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "welcome", value = "/welcome")
public class Myservlet2 {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

        try{
            Cookie[] cookies = request.getCookies();
            PrintWriter out = response.getWriter();
          for(int i = 0; i < cookies.length; i++){
              out.println("<br />");
              out.println(cookies[i].getName());
          }
            out.close();
        } catch(Exception b){

        }
    }
}


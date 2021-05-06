package co.edu.unbosque.Workshop4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "descarga", value = "/descarga")
public class DescargarServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=sample.txt");

        try (InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
             OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

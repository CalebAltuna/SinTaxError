
package controlador;

import java.io.IOException;
import modelo.erabiltzaileakDAO;
import modelo.erabiltzaileak;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/erabiltzaileakServlet")
public class erabiltzaileakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(erabiltzaileakServlet.class.getName());

    public boolean recogerDatos(erabiltzaileak erabiltzailea) {
        boolean vuelta = false;
        try {
            String nombreBD = erabiltzaileakDAO.devolverNombreBaseDeDatos(erabiltzailea.getIzena());
            String passwordBD = erabiltzaileakDAO.devolverPasswordBaseDeDatos(erabiltzailea.getPassword());

            if (erabiltzailea.getIzena().equals(nombreBD) && erabiltzailea.getPassword().equals(passwordBD)) {
                vuelta = true;
            }
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "NullPointerException: {0}", e.getMessage());
            vuelta = false;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: {0}", e.getMessage());
            vuelta = false;
        }
        return vuelta;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("username");
        String password = request.getParameter("password");

        erabiltzaileak erabiltzailea = new erabiltzaileak(nombreUsuario, password);

        if (recogerDatos(erabiltzailea)) {
            response.sendRedirect("AdminDB.jsp");
        } else {
            response.sendRedirect("try.jsp");
        }
    }
}

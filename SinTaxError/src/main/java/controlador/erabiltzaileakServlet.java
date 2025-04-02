
package controlador;

import java.io.IOException;

import modelo.ErabiltzaileakDAO;
import modelo.erabiltzaileak;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class erabiltzaileakServlet {
    private static final Logger logger = Logger.getLogger(erabiltzaileakServlet.class.getName());

    public boolean recogerDatos(erabiltzaileak erabiltzailea) {
        boolean vuelta = false;
        try {
            String nombreBD = ErabiltzaileakDAO.devolverNombreBaseDeDatos(erabiltzailea.getIzena());
            String passwordBD = erabiltzaileakDAO.devolverPasswordBaseDeDatos(erabiltzailea.getIzena());

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
        String nombreUsuario = request.getParameter("name");
        String password = request.getParameter("password");

        logger.log(Level.INFO, "Attempting login for user: {0}", nombreUsuario);

        erabiltzaileak erabiltzailea = new erabiltzaileak(nombreUsuario, password);

        if (recogerDatos(erabiltzailea)) {
            logger.log(Level.INFO, "Login successful for user: {0}", nombreUsuario);
            response.sendRedirect("login.jsp");
        } else {
            logger.log(Level.WARNING, "Login failed for user: {0}", nombreUsuario);
            response.sendRedirect("try.jsp");
        }
    }
}

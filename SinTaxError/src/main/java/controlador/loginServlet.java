package controlador;

import java.io.IOException;
import modelo.erabiltzaileaDAO;
import modelo.erabiltzailea;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/Start/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(erabiltzaileaServlet.class.getName());
    
    public boolean compararDatos(erabiltzailea erab) {
        boolean vuelta = false;
        try {
            String nombreBD = erabiltzaileaDAO.izenaBai(erab.getIzena());
            String passwordBD = erabiltzaileaDAO.pasahitzaBai(erab.getIzena());

            logger.log(Level.INFO, "NombreBD: {1}, PasswordBD: {2}", new Object[]{nombreBD, passwordBD});
            logger.log(Level.INFO, "NombreUsuario: {1}, PasswordUsuario: {2}", new Object[]{erab.getIzena(), erab.getPasahitza()});

            if (nombreBD != null && passwordBD != null && erab.getIzena().equals(nombreBD) && erab.getPasahitza().equals(passwordBD)) {
                vuelta = true;
            }
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, "NullPointerException: {1}", e.getMessage());
            vuelta = false;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: {1}", e.getMessage());
            vuelta = false;
        }
        return vuelta;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the login page if a GET request is made
        response.sendRedirect("login.jsp");
    }

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String izena = request.getParameter("izena");
	    String pasahitza = request.getParameter("pasahitza");
	    String rola = request.getParameter("rola");
	    String id = request.getParameter("id");
	    int idErabiltzailea = Integer.parseInt(id);
	
	    erabiltzailea erab = new erabiltzailea(idErabiltzailea, izena, pasahitza, rola);
	
	    if (compararDatos(erab)) {
	        response.sendRedirect("AdminDB1.jsp");
	    } else {
	        request.setAttribute("error", "Invalid username or password");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Start/Login.jsp");
	        dispatcher.forward(request, response);
	    }
	}
}//end

package controlador;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Start/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String izena = request.getParameter("izena");
        String pasahitza = request.getParameter("pasahitza");

        // Validate input
        if (izena == null || izena.isEmpty() || pasahitza == null || pasahitza.isEmpty()) {
            request.setAttribute("error", "Username and password are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Start/Login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // Compare credentials
        if (validarCredenciales(izena, pasahitza)) {
            // Successful login
            response.sendRedirect(request.getContextPath() + "/Start/AdminDB1.jsp");
        } else {
            // Failed login
            request.setAttribute("error", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Start/Login.jsp");
            dispatcher.forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to login page
        response.sendRedirect("Login.jsp");
    }
    // Method to validate credentials
    private boolean validarCredenciales(String izena, String pasahitza) {
        // Replace this logic with database validation if needed
        return "User".equals(izena) && "password".equals(pasahitza);
    }
}
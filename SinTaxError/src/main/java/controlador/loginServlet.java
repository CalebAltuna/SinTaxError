package controlador;

import java.io.IOException;
import modelo.erabiltzaileaDAO;
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
	        String izena = request.getParameter("izena");
	        String pasahitza = request.getParameter("pasahitza");
	        String rola = request.getParameter("rola");
	
	        if (izena == null || izena.isEmpty() || pasahitza == null || pasahitza.isEmpty()) {
	            request.setAttribute("error", "Erabiltzaile izena eta pasahitza beharrezkoak dira.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/Start/Login.jsp");
	            dispatcher.forward(request, response);
	            return;
	        }
	
	        if (validarCredenciales(izena, pasahitza)) {
	        	if (rola.equals("admin")) {
	        		response.sendRedirect(request.getContextPath() +"/AdminDB1.jsp");
	        	}
				else if (rola.equals("user")) {
					response.sendRedirect(request.getContextPath() + "/UserDB1.jsp");
				} else {
					response.sendRedirect(request.getContextPath() + "/UserDB1.jsp");
				}
	            
	        } else {
	            request.setAttribute("error", "Erabiltzaile izena edo pasahitza ez da zuzena.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/Start/Login.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.sendRedirect("Login.jsp");
	    }
	    private boolean validarCredenciales(String izena, String pasahitza) {
	        return erabiltzaileaDAO.validar(izena, pasahitza);
	    }
	}
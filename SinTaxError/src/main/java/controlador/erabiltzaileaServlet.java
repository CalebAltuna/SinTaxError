package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.erabiltzaileaDAO;
import modelo.erabiltzailea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/erabiltzaileaServlet")
public class erabiltzaileaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final erabiltzaileaDAO erabDAO = new erabiltzaileaDAO();

    // **doGet()**: Para leer los datos de un usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los usuarios desde el DAO
        List<erabiltzailea> lista = erabDAO.getAll();
        
        // Establecer los usuarios en el request
        request.setAttribute("erabiltzaileak", lista);
        
        // Redirigir a la vista JSP que mostrará los usuarios
        RequestDispatcher dispatcher = request.getRequestDispatcher("/erabiltzaileaView.jsp");
        dispatcher.forward(request, response);
    }

    // **doPost()**: Para crear un nuevo usuario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener parámetros de la solicitud
        int id = Integer.parseInt(request.getParameter("id"));
        String pasahitza = request.getParameter("pasahitza");
        String rola = request.getParameter("rola");
        String izena = request.getParameter("izena");

        // Crear un nuevo objeto de tipo "erabiltzailea"
        erabiltzailea erab = new erabiltzailea(id, pasahitza, rola, izena);

        // Llamada al método del DAO para crear el usuario
        erabDAO.sortuErab(erab);

        // Responder con un mensaje
        response.getWriter().println("User created successfully.");
    }
    
    public class erabiltzaileaViewServlet extends HttpServlet {

    }

 }// End of class

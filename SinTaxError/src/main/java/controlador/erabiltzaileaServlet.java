package controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.erabiltzaileaDAO;
import modelo.erabiltzailea;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/erabiltzaileaServlet")
public class erabiltzaileaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final erabiltzaileaDAO erabDAO = new erabiltzaileaDAO();

    // **doGet()**: Para leer los datos de un usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id != null) {
            // Lógica para obtener un usuario por ID
            // Aquí deberías llamar a la función correspondiente de la clase DAO (por ejemplo, irakurriErab())
            // y devolver los resultados como JSON o HTML.
            // Para este ejemplo, simplemente devolveremos un mensaje de que se ha recibido la solicitud.
            PrintWriter out = response.getWriter();
            out.println("GET request received for user with ID: " + id);
        } else {
            // Aquí puedes manejar la lectura de todos los usuarios si fuera necesario.
            PrintWriter out = response.getWriter();
            out.println("GET request received for all users.");
        }
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

    // **doPut()**: Para actualizar un usuario existente
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener parámetros de la solicitud
        int id = Integer.parseInt(request.getParameter("id"));
        String pasahitza = request.getParameter("pasahitza");
        String rola = request.getParameter("rola");
        String izena = request.getParameter("izena");

        // Crear un objeto de tipo "erabiltzailea" con los datos actualizados
        erabiltzailea erab = new erabiltzailea(id, pasahitza, rola, izena);

        // Llamada al método del DAO para actualizar el usuario
        erabDAO.eguneratuErab(erab);

        // Responder con un mensaje
        response.getWriter().println("User updated successfully.");
    }

    // **doDelete()**: Para eliminar un usuario
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener el ID del usuario a eliminar
        int id = Integer.parseInt(request.getParameter("id"));

        // Llamada al método del DAO para eliminar el usuario
        erabDAO.kenduErab(id);

        // Responder con un mensaje
        response.getWriter().println("User deleted successfully.");
    }
}

package org.biblioteca.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.biblioteca.Libro;
import org.biblioteca.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet("/eliminarLibro")
public class EliminadorLibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del libro desde el formulario
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));

        // Crear sesión de Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Buscar el libro en la base de datos
            Libro libro = session.get(Libro.class, idLibro);
            if (libro != null) {
                // Si el libro existe, eliminarlo
                session.delete(libro);
                transaction.commit();
                System.out.println("Libro con ID " + idLibro + " eliminado con éxito.");
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204: OK sin contenido
            } else {
                // Si el libro no se encuentra
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Libro no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el libro");
        }
    }
}

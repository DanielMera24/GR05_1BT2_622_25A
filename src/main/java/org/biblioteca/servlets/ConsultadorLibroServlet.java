package org.biblioteca.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.biblioteca.Libro;
import org.biblioteca.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

@WebServlet("/consultarLibros")
public class ConsultadorLibroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener libros desde Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Libro> libros = session.createQuery("from Libro", Libro.class).list();
        session.close();

        // Pasar la lista como atributo a la JSP
        request.setAttribute("libros", libros);

        // Redirigir a la página JSP
        request.getRequestDispatcher("/mostrarLibros.jsp").forward(request, response);
    }
}
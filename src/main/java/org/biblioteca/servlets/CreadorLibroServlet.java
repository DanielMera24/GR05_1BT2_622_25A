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

@WebServlet("/agregarLibro")
public class CreadorLibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int numPaginas = Integer.parseInt(request.getParameter("num-paginas"));
        double precio = Double.parseDouble(request.getParameter("precio"));


        System.out.println("TITULO: " + request.getParameter("titulo"));
        System.out.println("AUTOR: " + request.getParameter("autor"));
        System.out.println("PAGINAS: " + request.getParameter("num-paginas"));
        System.out.println("PRECIO: " + request.getParameter("precio"));



        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setNumPaginas(numPaginas);
        libro.setPrecio(precio);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(libro);
        tx.commit();
        session.close();

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
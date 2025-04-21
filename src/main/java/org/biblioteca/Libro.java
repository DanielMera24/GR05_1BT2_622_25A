package org.biblioteca;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int idLibro;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "num_paginas", nullable = false)
    private int numPaginas;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private double precio;

    public Libro() {} // Constructor vacío requerido por Hibernate

    public Libro(int idLibro, String titulo, int numPaginas, String autor, double precio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.precio = precio;
    }

    // Getters y Setters
    public int getIdLibro() { return idLibro; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getNumPaginas() { return numPaginas; }
    public void setNumPaginas(int numPaginas) { this.numPaginas = numPaginas; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

}
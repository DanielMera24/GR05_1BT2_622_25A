<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Biblioteca Online</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/mostrarLibros.css">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
<div class="container">
    <header class="encabezado">
        <div class="logo-nombreEMC">
            <div class="logo">
                <img src="img/img_libro.png" alt="Logo libro">
            </div>
        </div>
        <p>BIBLIOTECA ONLINE</p>
    </header>

    <div class="side-main">
        <aside class="sidebar">
            <nav class="menu">
                <ul>
                    <li><a href="consultarLibros">Mostrar libros</a></li>
                    <li><a href="agregarLibro.html">Agregar nuevo libro</a></li>
                    <li><a href="eliminarLibro.html">Eliminar libro</a></li>
                </ul>
            </nav>
        </aside>

        <main class="mainContent">
            <div class="table-container">
                <h2>Libros</h2>
                <table>
                    <thead>
                    <tr>
                        <th>id del Libro</th>
                        <th>Título</th>
                        <th>autor</th>
                        <th>cantidad de páginas</th>
                        <th>precio</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="libro" items="${libros}" varStatus="loop">
                        <tr class="${loop.index % 2 == 0 ? 'even-row' : 'odd-row'}">
                            <td>${libro.idLibro}</td>
                            <td>${libro.titulo}</td>
                            <td>${libro.autor}</td>
                            <td>${libro.numPaginas}</td>
                            <td>${libro.precio}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
</body>
</html>

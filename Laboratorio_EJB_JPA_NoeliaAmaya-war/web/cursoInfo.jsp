<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información del Curso</title>
    </head>
    <body>
        <h1>Información del Curso</h1>
        <form action="./CursoServlet" method="POST">
            <table>
                <tr>
                    <td>Código del curso</td>
                    <td><input type="text" name="cursoId" value="${curso.cursoId}" /></td>
                </tr>
                <tr>
                    <td>Nombre del curso</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombrecurso}" /></td>
                </tr>
                <tr>
                    <td>Número de créditos</td>
                    <td><input type="text" name="numCreditos" value="${curso.numcreditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                 <tr>
                    <td>Número de estudiantes admitidos</td>
                    <td><input type="text" name="numEstudAdm" value="${curso.numestudianteadmitido}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Código curso</th>
            <th>Nombre del curso</th>
            <th>Número de créditos</th>
            <th>Semestre</th>
            <th>Número estudiantes admitidos</th>
                <c:forEach items="${allCursos}" var="cur">
                <tr>
                    <td>${cur.cursoId}</td>
                    <td>${cur.nombrecurso}</td>
                    <td>${cur.numcreditos}</td>
                    <td>${cur.semestre}</td>
                    <td>${cur.numestudianteadmitido}</td>
                </tr>
            </c:forEach> 
        </table>
        <a href="index.html"> <button> Volver </button> </a>
    </body>
</html>

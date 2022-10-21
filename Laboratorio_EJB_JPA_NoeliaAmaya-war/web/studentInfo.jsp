<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información del Estudiante</title>
    </head>
    <body>
        <h1>Información del Estudiante</h1>
        <form action="./EstudianteServlet" method="POST">
            <table>
                <tr>
                    <td>Id Estudiante</td>
                    <td><input type="text" name="studentId" value="${estudiante.estudianteId}" /></td>                    
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="firstName" value="${estudiante.firstname}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="lastName" value="${estudiante.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${estudiante.yearlevel}" /></td>
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
            <th>ID Estudiante</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.estudianteId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach> 
        </table>
        <a href="index.html"> <button> Volver </button> </a>
    </body>
</html>

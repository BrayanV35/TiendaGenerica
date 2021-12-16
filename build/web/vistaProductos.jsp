<%@page import="Modelo.Conexion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Tienda Generica</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="Trabajo viviana" content="Tienda Generica"/> 
    <meta name="Brayan Estiven Velasquez Fontecha" content="Estudainte Sena">
    <meta name="keywords" content="Tienda">
    <link rel="stylesheet" href="css/Stilo.css">
    </head>
    
    <body>

        <form class="formul" action="Productos" method="post" enctype="multipart/form-data">

                        <label>Nombre Archivo</label><input class="control" type="file" name="archivo" >
                        <input type="submit" name="cargar" class="boton" value="Cargar">
                        
                        <p><a href="index.jsp"> Volver</a> </p>		

        </form>


    </body>
</html>

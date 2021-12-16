<%@page import="Modelo.Conexion"%>
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
    
    <%!
        String nit = "", ciudad = "", nombre = "", telefono = "";
    %>
    <body>

        <%
            if (request.getParameter("men") != null) {
                String mensaje = request.getParameter("men");
                out.print("<script>alert('" + mensaje + "')</script>");
                nit = "";
                ciudad = "";
                nombre = "";
                telefono = "";
            }

            if (request.getParameter("nit") != null) {
                nit = request.getParameter("nit");
                ciudad = request.getParameter("ciudad");
                nombre = request.getParameter("nombre");
                telefono = request.getParameter("telefono");
            }
        %>

        <form class="formul" action="Proveedores" method="post">

                        <label>Nit:</label><input class="control" type="text" name="nit" required />
                        <input type="submit" name="consultar" class="boton" value="consultar"/>

        </form>

        <form class="formul" action="Proveedores" method="post">

          
                        <label >Nit:      </label><input class="control" type="text" name="nit" value="<%=nit%>" required readonly />
                        <label >Ciudad:   </label><input class="control" type="text" name="ciudad" value="<%=ciudad%>" required />      
                        <label >Nombre:   </label><input class="control" type="text" name="nombre" value="<%=nombre%>" required />
                        <label >Telefono: </label><input class="control" type="text" name="telefono" value="<%=telefono%>" required />

                        <input type="submit" name="registrar"  class="boton" value="Registrar" required/>
                        <input type="submit" name="actualizar" class="boton" value="Actualizar">
                        <input type="submit" name="borrar"     class="boton" value="Borrar">
                        
                        <p><a href="index.jsp"> Volver</a> </p>	

        </form>

 
    </body>
</html>

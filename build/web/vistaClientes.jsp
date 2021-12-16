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
    
    <%!
        String cedula = "", direccion = "", correo = "", nombre = "", telefono = "";
    %>

    <body>

        <%
            if (request.getParameter("men") != null) {
                String mensaje = request.getParameter("men");
                out.print("<script>alert('" + mensaje + "')</script>");
                cedula = "";
                direccion = "";
                correo = "";
                nombre = "";
                telefono = "";
            }

            if (request.getParameter("ced") != null) {
                cedula = request.getParameter("ced");
                direccion = request.getParameter("direccion");
                correo = request.getParameter("correo");
                nombre = request.getParameter("nombre");
                telefono = request.getParameter("telefono");
            }
        %>

        <form class="formul" action="Cliente" method="post"> 

                       <label>Cédula:</label> <input class="control" type="text" name="cedula" required/>
                       <input type="submit" name="consultar" class="boton" value="Consultar">           

                    </form>

        <form class="formul" action="Cliente" method="post">

           <label>Cédula:            </label><input class="control" type="text" name="cedula" value="<%=cedula%>" />
           <label>Teléfono:          </label><input class="control" type="text" name="telefono" value="<%=telefono%>" /> 
           <label>Nombre:            </label><input class="control" type="text" name="nombre" value="<%=nombre%>" />
           <label>Correo Electronico:</label><input class="control" type="email" name="correo" value="<%=correo%>" /> 
           <label>Dirección:         </label><input class="control" type="text" name="direccion" value="<%=direccion%>" /> 
                         
      
           <input type="submit" name="registrar" class="boton" value="Registrar" required/>
           <input type="submit" name="actualizar" class="boton" value="Actualizar"/>
           <input type="submit" name="borrar" class="boton" value="Borrar"/>   
                                    
           <p><a href="index.jsp"> Volver</a> </p>	

        </form>

    </body>
</html>

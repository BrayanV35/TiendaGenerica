<%@page import="Modelo.usuarioDTO"%>
<%@page import="java.util.ArrayList"%>
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
    
    <body>

        <%
            ArrayList<usuarioDTO> list = (ArrayList<usuarioDTO>) request.getAttribute("Usuario");

            // print the information about every category of the list        
            /*for(usuarioDto cx: ((ArrayList<usuarioDto>)request.getAttribute("Usuario"))) {

            out.println( cx.getCedula());

            out.println(cx.getCorreo());

            out.println(cx.getNombre() );
            }*/
            // print the information about every category of the list
            /*for(usuarioDto category : list) {
                out.println(category.getCedula());
                out.println(category.getNombre());
                out.println(category.getCorreo());
            }*/

        %>

        <form class="formul" action="Usuario" method="post">

                        <input class="control" type="submit" name="usuarios" value="Listado de Usuarios" >
                        <input class="control" type="submit" name="clientes" value="Listado de Clientes" >
                        <input class="control" type="submit" name="ventas"  value="Ventas Por Cliente" >
                        
                        <p><a href="index.jsp"> Volver</a> </p>	

        </form>

                    <table class="formul">
                        <thead>
                            <tr>
                                <th class="control" scope="col">Cedula</th>
                                <th class="control" scope="col">Correo</th>
                                <th class="control" scope="col">Nombre</th>
                                <th class="control" scope="col">Usuario</th>
                            </tr>
                            
                        </thead>
                        
 <tbody>
        <% 
          if (list != null) {
          for (usuarioDTO category : list) {
          usuarioDTO actor = new usuarioDTO(0, null, null, null, null);
          actor = category;
        %>

        <tr class="formul">
            <td><%=actor.getCedula()%></td>
            <td><%=actor.getCorreo()%></td>
            <td><%=actor.getNombre()%></td>
            <td><%=actor.getUsuario()%></td> 
        </tr>
                            
        <%
        }
        };
        %>
        
        </tbody>
     </table>
   </body>
</html>

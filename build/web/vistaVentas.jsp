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
        String codigo, iva = "", total = "", valor = "";
    %>
    <body>
        
<%
if (request.getParameter("men") != null) {
                String mensaje = request.getParameter("men");
                out.print("<script>alert('" + mensaje + "')</script>");
                codigo = "";iva = "";total = "";valor = "";
            }
if (request.getParameter("cod") != null) {
                codigo = request.getParameter("cod");
                iva = request.getParameter("iva");
                total = request.getParameter("total");
                valor = request.getParameter("valor");
            }  
%>

        <form class="formul" action="Ventas" method="post">
           
                    <label>Cedula</label><input class="control" type="text" name="cedula">
                    <input type="submit" name="consultar" class="boton"  value="Consultar">
                    <label>Cliente</label><input class="control" type="text" name="cliente">
                    <label>Consecutivo</label><input class="control" type="text" name="consecutivo">
           

                        <label>Cod. Producto</label><input class="control" type="text" name="codigo" value="<%=codigo%>" >                        
                        <input type="submit" name="consultardos" class="boton" value="Consultar">
                        <label>Iva          </label><input class="control" type="text" name="total" value="<%=iva%>" >
                        <label>Vlr. Total   </label><input class="control" type="text" name="valor"  value="<%=valor%>" >
                        <input type="submit" name="confirmar" class="boton" value="Confirmar">
                        
                        <p><a href="index.jsp"> Volver</a> </p>		
                        
        </form>
    </body>
</html>

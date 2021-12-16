
package controlador;

import Modelo.clienteDAO;
import Modelo.clienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Cliente", urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //insertar
    
    clienteDTO clieDto=null;
    clienteDAO clieDao= new clienteDAO();
    
    if (request.getParameter("registrar")!=null){
    
    long ced;
    String direccion, correo, nombre, telefono;
    ced=Long.parseLong(request.getParameter("cedula"));
    direccion=request.getParameter("direccion");
    correo=request.getParameter("correo");
    nombre=request.getParameter("nombre");
    telefono=request.getParameter("telefono");   
    clieDto=new clienteDTO (ced,direccion,correo,nombre,telefono);
    if(clieDao.insertarCliente(clieDto)){    
    response.sendRedirect("vistaClientes.jsp?men= Cliente registrado exitosamente");
    }else{
    response.sendRedirect("vistaClientes.jsp?men= Cliente no registrado");
    }
   }
    
    //consultar
    if(request.getParameter("consultar")!=null){
    
    long ced=Long.parseLong(request.getParameter("cedula"));
    clieDto=clieDao.buscarCliente(ced);
    if(clieDto!=null){
    String direccion, correo, nombre, telefono;
    direccion=clieDto.getDireccion();
    correo=clieDto.getCorreo();
    nombre=clieDto.getNombre();
    telefono=clieDto.getTelefono();
    response.sendRedirect("vistaClientes.jsp?ced="+ced+"&direccion="+direccion+"&correo="+correo+"&nombre="+nombre+"&telefono="+telefono);    
    }else{
    response.sendRedirect("vistaClientes.jsp?men=Cliente no encontrado");
    }
    }
    //actualizar
    if(request.getParameter("actualizar")!=null){
    
    long ced;
    String direccion, correo, nombre, telefono;
    ced=Long.parseLong(request.getParameter("cedula"));
    direccion=request.getParameter("direccion");
    correo=request.getParameter("correo");
    nombre=request.getParameter("nombre");
    telefono=request.getParameter("telefono");
    clieDto=new clienteDTO(ced,direccion, correo, nombre, telefono);
    if(clieDao.actualizaCliente(clieDto)){
    response.sendRedirect("vistaClientes.jsp?men=Datos actualizados exitosamente");
    }else{
    response.sendRedirect("vistaClientes.jsp?men=Datos no actualizados");    
    }
   }
    //Eliminar
    if (request.getParameter("borrar")!=null){
    
      long ced;
      ced=Long.parseLong(request.getParameter("cedula"));
      if(clieDao.eliminaCliente(ced)){
      response.sendRedirect("vistaClientes.jsp?men=Cliente eliminado");
      }else{
      response.sendRedirect("vistaClientes.jsp?men=El cliente no se pudo eliminar");
      }
    }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

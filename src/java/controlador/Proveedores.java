
package controlador;

import Modelo.ProveedorDTO;
import Modelo.proveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Proveedores", urlPatterns = {"/Proveedores"}) 
public class Proveedores extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    //Insertar
    ProveedorDTO proDto=null;
    proveedorDAO proDao=new proveedorDAO();
    
    if (request.getParameter("registrar")!=null){
    
     String nit, ciudad,nombre,telefono;
     nit=request.getParameter("nit");
     ciudad=request.getParameter("ciudad");
     nombre=request.getParameter("nombre");
     telefono=request.getParameter("telefono");
     proDto=new ProveedorDTO(nit,ciudad,nombre,telefono);
     if(proDao.insertaProveedor(proDto)){
     response.sendRedirect("vistaProveedores.jsp?men=Proveedor registrado exitosamente");
     }else{
     response.sendRedirect("vistaProveedores.jsp?men=Proveedor no registrado");
     }
    }
     
    //consultar
    if(request.getParameter("consultar")!=null){
    
    String nit= request.getParameter("nit");
    proDto=proDao.buscarProveedor(nit);
    if(proDto!=null){
    String ciudad,nombre,telefono;
    ciudad=proDto.getCiudad();
    nombre=proDto.getNombre();
    telefono=proDto.getTelefono();
    response.sendRedirect("vistaProveedores.jsp?nit="+nit+"&ciudad="+ciudad+"&nombre="+nombre+"&telefono="+telefono);
    }else{
    response.sendRedirect("vistaProveedores.jsp?men=Proveedor no encontrado");
    }
    }
    //actualizar
    if (request.getParameter("actualizar")!=null){
    
    String nit, ciudad, nombre, telefono;
    nit=request.getParameter("nit");
    ciudad=request.getParameter("ciudad");
    nombre=request.getParameter("nombre");
    telefono=request.getParameter("telefono");
    proDto=new ProveedorDTO(nit, ciudad, nombre, telefono);
    if(proDao.actualizaProveedor(proDto)){
    response.sendRedirect("vistaProveedores.jsp?men=Datos actualizados exitosamente");
    }else{
    response.sendRedirect("vistaProveedores.jsp?men=Datos no actualizados");
    }
   }
    //eliminar
    if(request.getParameter("borrar")!=null){
    
      String nit;
      nit= request.getParameter("nit");
      if(proDao.eliminarProveedor(nit)){
      response.sendRedirect("vistaProveedores.jsp?men=Proveedor eliminado");
      }else{
      response.sendRedirect("vistaProveedores.jsp?men=El Proveedor no se pudo eliminar");
      }
    }
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

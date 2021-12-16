
package controlador;

import Modelo.UsuarioDAO;
import Modelo.usuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class Usuario extends HttpServlet {

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //insertar 
    usuarioDTO usuDto= null;
    UsuarioDAO usuDao=new UsuarioDAO();    
        
    if (request.getParameter("registrar")!=null) {
    
     long ced;
     String correo,nombre,pass, usuario;
     ced=Long.parseLong(request.getParameter("cedula"));
     correo=request.getParameter("correo");
     nombre=request.getParameter("nombre");
     pass=request.getParameter("pass");
     usuario=request.getParameter("usuario");
    usuDto=new usuarioDTO(ced, correo, nombre, pass, usuario);
    if (usuDao.insertaUsuario(usuDto)){
    response.sendRedirect("vistaUsuario.jsp?men=Usuario registrado exitosamente");        
    }else{
    response.sendRedirect("vistaUsuario.jsp?men=Usuario no registrado");        
    }        
   }
    
    //consultar
    if (request.getParameter("consultar")!=null){
    
    long ced=Long.parseLong(request.getParameter("cedula"));
    usuDto=usuDao.buscarUsuario(ced);
    if(usuDto!=null){
    String correo, nombre, pass, usuario;
    correo=usuDto.getCorreo();
    nombre=usuDto.getNombre();
    pass=usuDto.getPassword();
    usuario=usuDto.getUsuario();
    response.sendRedirect("vistaUsuario.jsp?ced="+ced+"&correo="+correo+"&nom="+nombre+"&pass="+pass+"&usu="+usuario);
    }else{
    response.sendRedirect("vistaUsuario.jsp?men=Usuario no encontrado");
    }
    }
    //actualizar
     if (request.getParameter("actualizar")!=null) {
    
     long ced;
     String correo,nombre,pass, usuario;
     ced=Long.parseLong(request.getParameter("cedula"));
     correo=request.getParameter("correo");
     nombre=request.getParameter("nombre");
     pass=request.getParameter("pass");
     usuario=request.getParameter("usuario");
    usuDto=new usuarioDTO(ced, correo, nombre, pass, usuario);
    if (usuDao.actualizaUsuario(usuDto)){
    response.sendRedirect("vistaUsuario.jsp?men=Datos actuaizados exitosamente");        
    }else{
    response.sendRedirect("vistaUsuario.jsp?men=Datos no actualizados");        
    }        
   }
     
   //eliminar
   if (request.getParameter("borrar")!=null) {
    
     long ced;   
     ced=Long.parseLong(request.getParameter("cedula"));     
    if (usuDao.eliminaUsuario(ced)){
    response.sendRedirect("vistaUsuario.jsp?men=usuario eliminado");        
    }else{
    response.sendRedirect("vistaUsuario.jsp?men=El usuario no se pudo eliminar");        
    }        
   }
   
   //listar usuarios
   if(request.getParameter("usuarios")!=null){   
     ArrayList<usuarioDTO> lusuario =  usuDao.listarUsuarios();
     
     request.setAttribute("Usuario", lusuario); //categorylist is an arraylist      contains object of class category  
     getServletConfig().getServletContext().getRequestDispatcher("/vistaReportes.jsp").forward(request,response);      
   }
   
   
 }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

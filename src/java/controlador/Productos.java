package controlador;

import Modelo.ProductoDTO;
import Modelo.productoDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

@WebServlet(name = "Productos", urlPatterns = {"/Productos"})
@MultipartConfig
public class Productos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductoDTO prodDto = null;
        productoDAO prodDao = new productoDAO();

        if (request.getParameter("cargar") != null) {

            Part archivo = request.getPart("archivo");
            //String Url = "C:\\Users\\User\\Documents\\NetBeansProjects\\Tienda\\web\\Documentos\\";
            String Url = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
            if (archivo.getContentType().equals("application/vnd.ms-excel")) {
                try {
                    InputStream file = archivo.getInputStream();
                    File copia = new File(Url + "prueba.csv");
                    FileOutputStream escribir = new FileOutputStream(copia);
                    int num = file.read();
                    while (num != -1) {
                        escribir.write(num);
                        num = file.read();
                    }
                    file.close();
                    escribir.close();
                    JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
                    if (prodDao.Cargar_Libros(Url + "prueba.csv")) {
                        response.sendRedirect("vistaProductos.jsp?men=Se registro los productos correctamente");
                    } else {
                        response.sendRedirect("vistaProductos.jsp?men=No registro los productos correctamente");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar el archivo" + e);
                    response.sendRedirect("vistaProductos.jsp?men=Error al cargar el archivo");
                }
            } else {
                response.sendRedirect("vistaProductos.jsp?men=Formato de archivo no permitido");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

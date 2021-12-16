package controlador;

import Modelo.VentaDTO;
import Modelo.ventaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ventas", urlPatterns = {"/Ventas"})
public class Ventas extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VentaDTO venDto = null;
        ventaDAO venDao = new ventaDAO();
        
        if (request.getParameter("consultardos") != null) {
            int cod = Integer.parseInt(request.getParameter("codigo"));
            venDto = venDao.buscarVenta(cod);
            if (venDto != null) {
                double iva, total, valor;
                cod = venDto.getCodigo();   
                iva = venDto.getIva();
                total = venDto.getTotal();
                valor = venDto.getValor();
                response.sendRedirect("vistaVentas.jsp?cod=" + cod + "&iva=" + iva + "&total=" + total + "&valor=" + valor);
            } else {
                response.sendRedirect("vistaVentas.jsp?men=venta no encontrada");
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

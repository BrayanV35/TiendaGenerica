package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class productoDAO {

    Conexion cnn = new Conexion();
    PreparedStatement ps = null;
    ResultSet res = null;
    Connection con = null;

    public ArrayList<ProductoDTO> listarProductos() {
        ProductoDTO prod = null;
        ArrayList<ProductoDTO> lista = new ArrayList<>();

        try {
            con = cnn.Conecta();
            String sql = "select * from productos;";
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                prod = new ProductoDTO(res.getInt(1), res.getDouble(2), res.getString(3), res.getString(4), res.getDouble(5), res.getDouble(6));
                lista.add(prod);
            }
        } catch (SQLException ex) {

            System.out.println("Error al consultar los productos");
        }
        return lista;
    }

    public ProductoDTO buscarProducto(int codigo) {
        ProductoDTO prod = null;
        try {

            con = cnn.Conecta();
            String sql = "select * from productos where codigo_producto=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            res = ps.executeQuery();
            while (res.next()) {
                prod = new ProductoDTO(res.getInt(1), res.getDouble(2), res.getString(3), res.getString(4), res.getDouble(5), res.getDouble(6));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar productos: " + ex);
        }
        return prod;
    }

    public boolean insertarProducto(ProductoDTO prod) {

        boolean resultado = false;
        if (buscarProducto(prod.getCodigo()) == null) {

            try {
                con = cnn.Conecta();
                String sql = ("insert into productos value (?,?,?,?,?,?)");
                ps = con.prepareStatement(sql);
                ps.setInt(1, prod.getCodigo());
                ps.setDouble(2, prod.getIva());
                ps.setString(3, prod.getNit());
                ps.setString(4, prod.getNombre());
                ps.setDouble(5, prod.getPreciocompra());
                ps.setDouble(6, prod.getPrecioventa());
                resultado = ps.executeUpdate() > 0;
                con.close();

            } catch (SQLException ex) {

                System.out.println("Error al insertar producto");
            }
        } else {
            resultado = false;
        }
        return resultado;
    }

    //cargar archivo
    public boolean Cargar_Libros(String URL) {

        boolean resul = false;
        try {
            con = cnn.Conecta();
            String sql = "load data infile '" + URL + "' into table productos fields terminated by ',' lines terminated by '\r\n'";
            ps = con.prepareStatement(sql);
            resul = ps.executeUpdate() > 0;
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar libros" + ex);
        }
        return resul;
    }

}


package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class detalleDAO {
    
    Conexion cnn=new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<DetalleDTO> listarDetalles(){
    DetalleDTO det=null;
    ArrayList<DetalleDTO>lista= new ArrayList<>();
    
    try{
    con=cnn.Conecta();
    String sql="select * from detalle_ventas;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    det=new DetalleDTO(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getDouble(5),res.getDouble(6),res.getDouble(7));
    lista.add(det);
    }
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al consultar Detalles de Venta"+ex);
    }
    return lista;
    }
    
    public DetalleDTO buscarDetalle(int codigo){
    DetalleDTO det=null;
    try{
    con=cnn.Conecta();
    String sql="select * from select * from detalle_ventas where codigo_detalle=?;";
    ps=con.prepareStatement(sql);
    ps.setInt(1, codigo);
    res=ps.executeQuery();
    while(res.next()){
    det=new DetalleDTO(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getDouble(5),res.getDouble(6),res.getDouble(7));
    }
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al consultar detalle ");    
    }
    return det;
    }
    
    public boolean insertaDetalle(DetalleDTO det){
    
    boolean resultado=false;
    if(buscarDetalle(det.getCodigo())==null){
    
        try{
        con=cnn.Conecta();
        String sql=("insert into detalle_ventas value (?,?,?,?,?,?,?);");
        ps=con.prepareStatement(sql);
        ps.setInt(1, det.getCodigo());
        ps.setInt(2, det.getCantidad());
        ps.setInt(3, det.getCodigoproducto());
        ps.setInt(4, det.getCodigoventa());
        ps.setDouble(5, det.getValorventa());
        ps.setDouble(6, det.getValoriva());
        ps.setDouble(7, det.getValortotal());
        resultado=ps.executeUpdate()>0;
        con.close();        
        }catch(SQLException ex){
            System.out.println("Error al insetar detalle ");
        }
    }else resultado=false;
    return resultado;
    }
}

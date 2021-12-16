
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ventaDAO {
    
    Conexion cnn= new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con =null;
    
    public ArrayList<VentaDTO> listarVentas(){    
    VentaDTO ven=null;
    ArrayList<VentaDTO> lista=new ArrayList();
    
    try{    
    con= cnn.Conecta();
    String sql="select * from ventas;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    ven=new VentaDTO(res.getInt(1),res.getLong(2),res.getLong(3),res.getDouble(4),res.getDouble(5),res.getDouble(6));
    lista.add(ven);
    }
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al consultar las ventas: "+ex);
    }
    return lista;
    
    }
    
    //public VentaDTO buscarVenta (int codigo){
    
    public VentaDTO buscarVenta (int cod){
    VentaDTO ven= null;
    try{
    con=cnn.Conecta();
    String sql="select iva_venta, total_venta, valor_venta  from ventas where codigo_venta =?;";
    ps=con.prepareStatement(sql);
    ps.setInt(1, cod);
    res=ps.executeQuery();
    while(res.next()){
   ven=new VentaDTO(cod,0,0,res.getDouble(1),res.getDouble(2),res.getDouble(3));
    }
    con.close();
    }catch(SQLException ex){
        System.out.println("Error al consultar venta "+ex);
    }
    return ven;
    }
    
    
    public boolean insertaVenta(VentaDTO ven){
    
    boolean resultado=false;
    if(buscarVenta(ven.getCodigo())==null){
    
    try{
    con=cnn.Conecta();
    String sql=("insert into ventas value(?,?,?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setInt(1,ven.getCodigo());
    ps.setLong(2,ven.getCedulacliente() );
    ps.setLong(3, ven.getCedulausuario());
    ps.setDouble(4,ven.getIva());
    ps.setDouble(5,ven.getTotal());
    ps.setDouble(6,ven.getValor());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al insertar venta"+ex);
    }
    }else resultado=false;
    return resultado;
    }    
       
    
}

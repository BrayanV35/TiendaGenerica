
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class proveedorDAO {
    
    Conexion cnn=new Conexion();
    PreparedStatement ps=null;
    ResultSet res=null;
    Connection con=null;
    
    public ArrayList<ProveedorDTO>listaProveedores(){
    ProveedorDTO pro=null;
    ArrayList<ProveedorDTO> lista=new ArrayList<>();
    
    try{
    con=cnn.Conecta();
    String sql="select * from proveedores;";
    ps=con.prepareStatement(sql);
    res=ps.executeQuery();
    while(res.next()){
    
    pro=new ProveedorDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
    lista.add(pro);
    }
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al consultar proveedores");
    }
    return lista;
    }
    
    public ProveedorDTO buscarProveedor(String nit){    
    ProveedorDTO pro=null;
    try{
    con=cnn.Conecta();
    String sql="select * from proveedores where nit_proveedor=?";
    ps=con.prepareStatement(sql);
    ps.setString(1,nit);
    res=ps.executeQuery();
    while(res.next()){
    pro=new ProveedorDTO(res.getString(1),res.getString(2),res.getString(3),res.getString(4));
    }
    con.close();
    }catch(SQLException ex){
    
        System.out.println("Error al consultar proveedor: "+ex);
    }
    return pro;
    }
    
    public boolean insertaProveedor(ProveedorDTO pro){
    
    boolean resultado=false;
    if (buscarProveedor(pro.getNit())==null){
    
    try{
    con=cnn.Conecta();
    String sql=("insert into proveedores value (?,?,?,?);");
    ps=con.prepareStatement(sql);
    ps.setString(1,pro.getNit());
    ps.setString(2,pro.getCiudad());
    ps.setString(3, pro.getNombre());
    ps.setString(4,pro.getTelefono());
    resultado=ps.executeUpdate()>0;
    con.close(); 
    }catch(SQLException ex){
    
        System.out.println("Error al insertar proveedor"+ex);
    }
    }else resultado=false;
    return resultado;
    }
    
    public boolean actualizaProveedor(ProveedorDTO pro){
        
    boolean resultado=false;
    try{
    con=cnn.Conecta();
    String sql=("update proveedores set ciudad_proveedor=?, nombre_proveedor=?,telefono_proveedor=? where nit_proveedor=?");
    ps=con.prepareStatement(sql);
    ps.setString(1,pro.getCiudad());
    ps.setString(2,pro.getNombre());
    ps.setString(3, pro.getTelefono());
    ps.setString(4, pro.getNit());
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
        
        System.out.println("Error al actualizar el proveedor"+ex);  
    }
    return resultado;
    }
    
    public boolean eliminarProveedor(String nit){
    boolean resultado=false;
    try{
    con=cnn.Conecta();
    String sql="delete from proveedores where proveedores.nit_proveedor=?";
    ps=con.prepareStatement(sql);
    ps.setString(1, nit);
    resultado=ps.executeUpdate()>0;
    con.close();
    }catch(SQLException ex){
        System.out.println("Error al eliminar proveedor");
    }
    return resultado;
    }
}

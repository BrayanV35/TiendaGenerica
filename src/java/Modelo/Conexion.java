
package Modelo;
 
import java.sql.Connection;
import java.sql.DriverManager;;
import javax.swing.JOptionPane;

public class Conexion {
    
    private String bd="tiendagenerica";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="root";
    private String pass="";
    
    Connection conec=null;
    
    public Connection Conecta() { //metodo para realizar conexion a la BD
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conec=DriverManager.getConnection(url,user,pass);
           // JOptionPane.showMessageDialog(null,"Conexion Exitosa");
           // System.out.println("Conexion Exitosa");
        
        }catch(Exception e){
        
           // System.out.println("Error al conectarse: "+e);
           // JOptionPane.showMessageDialog(null,"Conexion Exitosa: "+e);
        
        }
    
        return conec;
    }
    
}


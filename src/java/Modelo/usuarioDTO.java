
package Modelo;


public class usuarioDTO {
    
        private long cedula;
        private String correo;
        private String nombre;
        private String password;
        private String usuario;

    public usuarioDTO(long cedula, String correo, String nombre, String password, String usuario) {
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.usuario = usuario;
    }

    public usuarioDTO(long cedula) {
        this.cedula = cedula;
    }
    
    

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String imprimir(){
    
    String mensaje="\nCedula: "+getCedula()+
                   "\nNombre: "+getNombre()+
                   "\nCorreo:"+getCorreo()+
                   "\nContraseña"+getPassword()+
                   "\nUsuario:"+getUsuario();
    
    
    return mensaje;
    }
    
        
        
    
}

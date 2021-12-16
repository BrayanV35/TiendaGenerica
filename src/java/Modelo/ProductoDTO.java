
package Modelo;

public class ProductoDTO {
    
    private int codigo;
    private double iva;
    private String nit;
    private String nombre;
    private double preciocompra;
    private double precioventa;

    public ProductoDTO(int codigo, double iva, String nit, String nombre, double preciocompra, double precioventa) {
        this.codigo = codigo;
        this.iva = iva;
        this.nit = nit;
        this.nombre = nombre;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
    }

    public ProductoDTO(int codigo) {
        this.codigo = codigo;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }
    
    public String imprimir(){
    
    String mensaje="\ncodido: "+getCodigo()+
                  "\niva: "+getIva()+
                  "\nnit: "+getNit()+
                  "\nnombre: "+getNombre()+
                  "\nprecio de Compra: "+getPreciocompra()+
                  "\nPrecio de Venta: "+getPrecioventa();
    
    return mensaje;
    }
    
}

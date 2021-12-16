
package Modelo;

public class DetalleDTO {
    
    private int codigo;
    private int cantidad;
    private int codigoproducto;
    private int codigoventa;
    private double valorventa;
    private double valoriva;
    private double valortotal;

    public DetalleDTO(int codigo, int cantidad, int codigoproducto, int codigoventa, double valorventa, double valoriva, double valortotal) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.codigoproducto = codigoproducto;
        this.codigoventa = codigoventa;
        this.valorventa = valorventa;
        this.valoriva = valoriva;
        this.valortotal = valortotal;
    }

    public DetalleDTO(int codigo) {
        this.codigo = codigo;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(int codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public int getCodigoventa() {
        return codigoventa;
    }

    public void setCodigoventa(int codigoventa) {
        this.codigoventa = codigoventa;
    }

    public double getValorventa() {
        return valorventa;
    }

    public void setValorventa(double valorventa) {
        this.valorventa = valorventa;
    }

    public double getValoriva() {
        return valoriva;
    }

    public void setValoriva(double valoriva) {
        this.valoriva = valoriva;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
    
    public String imprimir(){
    
    String mensaje="\ncodido: "+getCodigo()+
                   "\ncantidad: "+getCantidad()+
                   "\ncodigo Producto: "+getCodigoproducto()+
                   "\ncodido venta: "+getCodigoventa()+
                   "\nvalor venta: "+getValorventa()+
                   "\nvalor iva: "+getValoriva()+
                   "\nvalor total: "+getValortotal();
    
    return mensaje;
    
    }
    
    
    
}

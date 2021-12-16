
package Modelo;

public class VentaDTO {
    
    private int codigo;
    private long cedulacliente;
    private long cedulausuario;
    private double iva;
    private double total;
    private double valor;

    public VentaDTO(int codigo, long cedulacliente, long cedulausuario, double iva, double total, double valor) {
        this.codigo = codigo;
        this.cedulacliente = cedulacliente;
        this.cedulausuario = cedulausuario;
        this.iva = iva;
        this.total = total;
        this.valor = valor;
    }
    

    public VentaDTO(int codigo) {
        this.codigo = codigo;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(long cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public long getCedulausuario() {
        return cedulausuario;
    }

    public void setCedulausuario(long cedulausuario) {
        this.cedulausuario = cedulausuario;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    public String imprimir(){
        
        String mensaje= "\ncodigo: "+getCodigo() +
                        "\ncedula cliene: " + getCedulacliente()+
                        "\ncedula usuario: " + getCedulausuario()+
                        "\ncedula cliene: " + getCedulacliente()+
                        "\niva: " + getIva()+
                        "\ntotal venta: " + getTotal()+
                        "\nvalor venta: " + getValor();
        
        return mensaje;    
    
    }
    
}

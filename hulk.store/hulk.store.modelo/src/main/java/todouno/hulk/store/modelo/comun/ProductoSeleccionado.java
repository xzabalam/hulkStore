package todouno.hulk.store.modelo.comun;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ProductoSeleccionado extends Auditoria {
    private static final long serialVersionUID = 265459197609289286L;
    
    @Column(name = "SKU")
    private String sku;
    
    @Column(name = "PRECIO")
    private Double precio;
    
    @Column(name = "DESCUENTO")
    private Double descuento;
    
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public Double getDescuento() {
        return descuento;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public String getSku() {
        return sku;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
}

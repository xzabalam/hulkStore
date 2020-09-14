package todouno.hulk.store.to;

import java.io.Serializable;

public class OrdenProducto implements Serializable {

    private static final long serialVersionUID = -7082018293536968030L;

    private Long codigo;
    private ProductoTo producto;
    private OrdenTo orden;
    
    public Long getCodigo() {
        return codigo;
    }
    
    public OrdenTo getOrden() {
        return orden;
    }
    
    public ProductoTo getProducto() {
        return producto;
    }
    
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public void setOrden(OrdenTo orden) {
        this.orden = orden;
    }
    
    public void setProducto(ProductoTo producto) {
        this.producto = producto;
    }

}

package todouno.hulk.store.to;

import java.io.Serializable;

public class CarritoCompraProductoTo implements Serializable {
    private static final long serialVersionUID = 9145375742349366939L;

    private Long codigo;
    private ProductoTo producto;
    private CarritoCompraTo carritoCompra;

    public CarritoCompraTo getCarritoCompra() {
        return carritoCompra;
    }
    
    public Long getCodigo() {
        return codigo;
    }
    
    public ProductoTo getProducto() {
        return producto;
    }

    public void setCarritoCompra(CarritoCompraTo carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
    
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public void setProducto(ProductoTo producto) {
        this.producto = producto;
    }

}

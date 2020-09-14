package todouno.hulk.store.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.ProductoSeleccionado;

@Entity
@Table(name = "CARRITO_COMPRA_PRODUCTO")
@NamedQueries({ @NamedQuery(name = "CarritoCompraProducto.productosPorCodigoProducto",
        query = "select c from CarritoCompraProducto c join fetch c.producto p where p.codigo = :codigoProducto"), })
public class CarritoCompraProducto extends ProductoSeleccionado {
    private static final long serialVersionUID = 9145375742349366939L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_PRODUCTO")
    private Producto producto;
    
    @ManyToOne(targetEntity = CarritoCompra.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_CARRITO_COMPRA")
    private CarritoCompra carritoCompra;
    
    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Producto getProducto() {
        return producto;
    }
    
    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}

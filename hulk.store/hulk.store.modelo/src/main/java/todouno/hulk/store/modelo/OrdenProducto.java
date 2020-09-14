package todouno.hulk.store.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.ProductoSeleccionado;

@Entity
@Table(name = "ORDEN_PRODUCTO")
public class OrdenProducto extends ProductoSeleccionado {

    private static final long serialVersionUID = -7082018293536968030L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @ManyToOne(targetEntity = Producto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_PRODUCTO")
    private Producto producto;
    
    @ManyToOne(targetEntity = Orden.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_ORDEN")
    private Orden orden;
    
    public Long getCodigo() {
        return codigo;
    }
    
    public Orden getOrden() {
        return orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}

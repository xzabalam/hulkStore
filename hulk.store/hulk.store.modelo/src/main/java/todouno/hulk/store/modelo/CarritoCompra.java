package todouno.hulk.store.modelo;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.Auditoria;

@Entity
@Table(name = "CARRITO_COMPRA")
@NamedQueries({ @NamedQuery(name = "CarritoCompra.productosPorUsuarioInvitado",
        query = "select c from CarritoCompra c join c.usuarioDeseaComprar u "
                + " join u.tipoUsuario tu join fetch c.listaProductosCarritoCompra l "
                + "where c.estado = :estado and l.estado = :estado  and tu.tipo = :tipoUsuario"), })
public class CarritoCompra extends Auditoria {

    private static final long serialVersionUID = -4890972331050177091L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @OneToMany(mappedBy = "carritoCompra")
    private List<CarritoCompraProducto> listaProductosCarritoCompra;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_USUARIO")
    private Usuario usuarioDeseaComprar;

    public CarritoCompra() {
        super();
    }

    public CarritoCompra(Long codigo) {
        super();
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public List<CarritoCompraProducto> getListaProductosCarritoCompra() {
        return listaProductosCarritoCompra;
    }

    public Usuario getUsuarioDeseaComprar() {
        return usuarioDeseaComprar;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setListaProductosCarritoCompra(List<CarritoCompraProducto> listaProductosCarritoCompra) {
        this.listaProductosCarritoCompra = listaProductosCarritoCompra;
    }

    public void setUsuarioDeseaComprar(Usuario usuarioDeseaComprar) {
        this.usuarioDeseaComprar = usuarioDeseaComprar;
    }

}

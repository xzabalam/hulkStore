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
import todouno.hulk.store.to.OrdenTo;

@Entity
@Table(name = "ORDEN")
@NamedQueries({ @NamedQuery(name = "Orden.obtenerActivas", query = "select o from Orden o where o.estado = :estado"), })
public class Orden extends Auditoria {
    
    private static final long serialVersionUID = -1841710222939761898L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;
    
    @Column(name = "IMPUESTO")
    private Double impuesto;
    
    @Column(name = "TOTAL")
    private Double total;
    
    @Column(name = "DESCUENTO")
    private Double descuento;
    
    @Column(name = "SUB_TOTAL")
    private Double subtotal;

    @Column(name = "GRAN_TOTAL")
    private Double granTotal;

    @OneToMany(mappedBy = "orden")
    private List<OrdenProducto> listaProductos;

    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_USUARIO")
    private Usuario usuarioSolicita;

    public Orden() {
        super();
    }
    
    public Orden(OrdenTo ordenTo) {
        super();
        impuesto = ordenTo.getImpuesto();
        total = ordenTo.getTotal();
        descuento = ordenTo.getTotal();
        subtotal = ordenTo.getSubtotal();
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public Double getGranTotal() {
        return granTotal;
    }

    public Double getImpuesto() {
        return impuesto;
    }
    
    public List<OrdenProducto> getListaProductos() {
        return listaProductos;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public Usuario getUsuarioSolicita() {
        return usuarioSolicita;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public void setGranTotal(Double granTotal) {
        this.granTotal = granTotal;
    }
    
    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public void setListaProductos(List<OrdenProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setUsuarioSolicita(Usuario usuarioSolicita) {
        this.usuarioSolicita = usuarioSolicita;
    }

}

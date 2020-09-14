package todouno.hulk.store.modelo;

import java.util.Date;
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
import javax.validation.constraints.Size;

import todouno.hulk.store.modelo.comun.ProductoSeleccionado;

@Entity
@Table(name = "PRODUCTO")
@NamedQueries({ @NamedQuery(name = "Producto.obtenerPorCategoria",
        query = "select p from Producto p join fetch p.categoria c where c.codigo = :idCategoria and p.estado = :estado"),
        @NamedQuery(name = "Producto.obtenerActivas",
                query = "select new todouno.hulk.store.to.ProductoTo(p.codigo, p.titulo, p.cantidad, p.categoria.codigo) "
                        + " from Producto p join p.categoria c where p.estado = :estado"), })
public class Producto extends ProductoSeleccionado {

    private static final long serialVersionUID = -4640680300664110435L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;
    
    @Column(name = "TITULO")
    private String titulo;
    
    @Column(name = "SLUG")
    private String slug;

    @Column(name = "RESUMEN")
    private String resumen;

    @Column(name = "URL_IMAGEN")
    @Size(max = 3000)
    private String urlImagen;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "COSTO_COMPRA")
    private Double costoCompra;

    @Column(name = "COSTO_VENTA")
    private Double costoVenta;

    @Column(name = "FECHA_PUBLICACION")
    private Date fechaPublicacion;

    @OneToMany(mappedBy = "producto")
    private List<CarritoCompraProducto> listaProductoCarritoCompra;
    
    @OneToMany(mappedBy = "producto")
    private List<OrdenProducto> listaOrdenes;
    
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_USUARIO")
    private Usuario usuarioCrea;
    
    @ManyToOne(targetEntity = Categoria.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_CATEGORIA")
    private Categoria categoria;
    
    public Producto() {
        super();
    }
    
    public Producto(Long codigo) {
        super();
        this.codigo = codigo;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Double getCostoCompra() {
        return costoCompra;
    }
    
    public Double getCostoVenta() {
        return costoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<OrdenProducto> getListaOrdenes() {
        return listaOrdenes;
    }

    public List<CarritoCompraProducto> getListaProductoCarritoCompra() {
        return listaProductoCarritoCompra;
    }

    public String getResumen() {
        return resumen;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Usuario getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCostoCompra(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public void setCostoVenta(Double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setListaOrdenes(List<OrdenProducto> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public void setListaProductoCarritoCompra(List<CarritoCompraProducto> listaProductoCarritoCompra) {
        this.listaProductoCarritoCompra = listaProductoCarritoCompra;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setUsuarioCrea(Usuario usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

}

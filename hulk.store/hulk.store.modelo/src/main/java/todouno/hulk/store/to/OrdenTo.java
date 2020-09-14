package todouno.hulk.store.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.modelo.Orden;

public class OrdenTo implements Serializable {
    
    private static final long serialVersionUID = -1841710222939761898L;

    private Long codigo;
    private Double impuesto;
    private Double total;
    private Double descuento;
    private Double subtotal;
    private String nombreUsuario;
    private Date fechaCreacion;
    private EstadoEnum estado;
    private List<ProductoTo> listadoProductos;

    public OrdenTo() {
        super();
    }

    public OrdenTo(Orden orden) {
        super();
        codigo = orden.getCodigo();
        impuesto = orden.getImpuesto();
        total = orden.getTotal();
        descuento = orden.getDescuento();
        subtotal = orden.getSubtotal();
        nombreUsuario = orden.getUsuarioSolicita().getNombre() + " " + orden.getUsuarioSolicita().getApellido();
        fechaCreacion = orden.getFechaCreacion();
        estado = orden.getEstado();

        final List<ProductoTo> listaProductosTo = orden.getListaProductos().stream().map(producto -> {
            final ProductoTo productoTo = new ProductoTo(producto.getProducto());
            productoTo.setCantidadSeleccionada(producto.getCantidad());
            return productoTo;
        }).collect(Collectors.toList());

        listadoProductos = listaProductosTo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Double getImpuesto() {
        return impuesto;
    }
    
    public List<ProductoTo> getListadoProductos() {
        return listadoProductos;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public Double getSubtotal() {
        return subtotal;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }
    
    public void setListadoProductos(List<ProductoTo> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
}

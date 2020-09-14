package todouno.hulk.store.to;

import java.io.Serializable;

import todouno.hulk.store.modelo.Producto;

public class ProductoTo implements Serializable {
    
    private static final long serialVersionUID = -4640680300664110435L;

    private Long codigo;
    private String titulo;
    private String resumen;
    private String descripcion;
    private String urlImagen;
    private Integer cantidad;
    private String sku;
    private Double costoVenta;
    private Long codigoCategoria;
    private Double descuento;
    private Integer cantidadSeleccionada;

    public ProductoTo(Long codigo, String titulo, Integer cantidad, Long codigoCategoria) {
        super();
        this.codigo = codigo;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.codigoCategoria = codigoCategoria;
    }
    
    public ProductoTo(Producto producto) {
        super();
        codigo = producto.getCodigo();
        titulo = producto.getTitulo();
        resumen = producto.getResumen();
        descripcion = producto.getDescripcion();
        urlImagen = producto.getUrlImagen();
        cantidad = producto.getCantidad();
        sku = producto.getSku();
        costoVenta = producto.getCostoVenta();
        codigoCategoria = producto.getCategoria().getCodigo();
        descuento = producto.getDescuento();
    }
    
    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public Long getCodigo() {
        return codigo;
    }
    
    public Long getCodigoCategoria() {
        return codigoCategoria;
    }
    
    public Double getCostoVenta() {
        return costoVenta;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public Double getDescuento() {
        return descuento;
    }

    public String getResumen() {
        return resumen;
    }

    public String getSku() {
        return sku;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidadSeleccionada(Integer cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public void setCostoVenta(Double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}

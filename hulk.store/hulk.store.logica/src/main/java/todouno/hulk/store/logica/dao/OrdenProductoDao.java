package todouno.hulk.store.logica.dao;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.CarritoCompraProducto;
import todouno.hulk.store.modelo.Orden;
import todouno.hulk.store.modelo.OrdenProducto;
import todouno.hulk.store.modelo.Producto;

@Stateless
public class OrdenProductoDao extends GenericoDaoUtil<OrdenProducto> {
    private static final long serialVersionUID = -5069536255981236664L;

    @Inject
    private ProductoDao productoDao;
    
    public OrdenProductoDao() {
        super(OrdenProducto.class);
    }

    public OrdenProductoDao(Class<OrdenProducto> tablaEntidad) {
        super(tablaEntidad);
    }

    public void crearOrdenProducto(CarritoCompraProducto productoCarritoCompra, Orden orden) {
        final Producto producto = productoCarritoCompra.getProducto();
        producto.setCantidad(producto.getCantidad() - productoCarritoCompra.getCantidad());
        productoDao.modificar(producto);
        
        final OrdenProducto ordenProducto = new OrdenProducto();
        
        ordenProducto.setCantidad(productoCarritoCompra.getCantidad());
        ordenProducto.setDescuento(productoCarritoCompra.getDescuento());
        ordenProducto.setEstado(EstadoEnum.ACT);
        ordenProducto.setFechaCreacion(new Date());
        ordenProducto.setOrden(orden);
        ordenProducto.setPrecio(productoCarritoCompra.getPrecio());
        ordenProducto.setProducto(producto);
        ordenProducto.setSku(productoCarritoCompra.getSku());

        crear(ordenProducto);
    }
}

package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.CarritoCompraProductoDao;
import todouno.hulk.store.modelo.CarritoCompra;
import todouno.hulk.store.modelo.CarritoCompraProducto;
import todouno.hulk.store.modelo.Producto;
import todouno.hulk.store.to.ProductoTo;

@Stateless
public class CarritoCompraProductoBean implements Serializable {
    private static final long serialVersionUID = 4319725908059743382L;

    @Inject
    private CarritoCompraProductoDao carritoCompraProductoDao;
    
    public void agregarProductoAlCarritoCompras(Long codigoCarrito, ProductoTo productoTo) {
        final CarritoCompraProducto carritoCompraProducto = new CarritoCompraProducto();
        carritoCompraProducto.setCantidad(productoTo.getCantidadSeleccionada());
        carritoCompraProducto.setCarritoCompra(new CarritoCompra(codigoCarrito));
        carritoCompraProducto.setDescuento(productoTo.getDescuento());
        carritoCompraProducto.setEstado(EstadoEnum.ACT);
        carritoCompraProducto.setFechaCreacion(new Date());
        carritoCompraProducto.setPrecio(productoTo.getCostoVenta());
        carritoCompraProducto.setProducto(new Producto(productoTo.getCodigo()));
        carritoCompraProducto.setSku(productoTo.getSku());
        carritoCompraProductoDao.crear(carritoCompraProducto);
    }
    
    public void eliminarProductoDelCarritoCompra(Long codigoProducto) {
        final List<CarritoCompraProducto> listadoCarritoCompraProducto = obtenerPorCodigoProducto(codigoProducto);
        
        listadoCarritoCompraProducto.stream().forEach(carritoCompraProducto -> {
            carritoCompraProducto.setEstado(EstadoEnum.INA);
            carritoCompraProductoDao.modificar(carritoCompraProducto);
        });
    }

    public List<CarritoCompraProducto> obtenerPorCodigoProducto(Long codigoProducto) {
        return carritoCompraProductoDao.obtenerPorCodigoProducto(codigoProducto);
    }

    public List<CarritoCompraProducto> obtenerTodas() {
        return carritoCompraProductoDao.obtenerTodos();
    }
}

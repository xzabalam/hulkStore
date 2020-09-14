package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.CarritoCompraDao;
import todouno.hulk.store.modelo.CarritoCompra;
import todouno.hulk.store.modelo.Usuario;
import todouno.hulk.store.to.ProductoTo;

@Stateless
public class CarritoCompraBean implements Serializable {
    private static final long serialVersionUID = -3237914087068278437L;
    
    @Inject
    private CarritoCompraDao carritoCompraDao;
    
    public Long crear(ProductoTo productoTo) {
        final CarritoCompra carritoCompra = new CarritoCompra();
        carritoCompra.setUsuarioDeseaComprar(new Usuario(4L));
        carritoCompra.setEstado(EstadoEnum.ACT);
        carritoCompra.setFechaCreacion(new Date());

        carritoCompraDao.crear(carritoCompra);
        
        return carritoCompra.getCodigo();
    }

    public void modificar(CarritoCompra carritoCompra) {
        carritoCompra.setFechaActualizacion(new Date());
        carritoCompraDao.modificar(carritoCompra);
    }

    public CarritoCompra obtenerCarritoPorUsuarioInvitado() {
        return carritoCompraDao.obtenerPorUsuarioInvitado();
    }

    public List<ProductoTo> obtenerPorUsuarioInvitado() {
        final CarritoCompra carritoCompra = carritoCompraDao.obtenerPorUsuarioInvitado();

        if (null == carritoCompra) {
            return new ArrayList<>();
        } else {
            return carritoCompra.getListaProductosCarritoCompra().stream().map(productoCarrito -> {
                final ProductoTo productoTo = new ProductoTo(productoCarrito.getProducto());
                productoTo.setCantidadSeleccionada(productoCarrito.getCantidad());
                return productoTo;
            }).collect(Collectors.toList());
        }
    }

    public List<ProductoTo> obtenerProductosPorCodigoCarritoCompra(Long codigoCarritoCompra) {
        final CarritoCompra carritoCompra = carritoCompraDao.obtenerPorCodigo(codigoCarritoCompra);

        if (null == carritoCompra) {
            return new ArrayList<>();
        } else {
            return carritoCompra.getListaProductosCarritoCompra().stream().map(productoCarrito -> {
                final ProductoTo productoTo = new ProductoTo(productoCarrito.getProducto());
                productoTo.setCantidadSeleccionada(productoCarrito.getCantidad());
                return productoTo;
            }).collect(Collectors.toList());
        }
    }

    public List<CarritoCompra> obtenerTodas() {
        return carritoCompraDao.obtenerTodos();
    }
}

package todouno.hulk.store.web.rest.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import todouno.hulk.store.logica.bean.CarritoCompraBean;
import todouno.hulk.store.logica.bean.CarritoCompraProductoBean;
import todouno.hulk.store.modelo.CarritoCompra;
import todouno.hulk.store.to.ProductoTo;
import todouno.hulk.store.web.rest.ICarritoCompraRest;
import todouno.hulk.store.web.rest.util.UtilRest;

@Stateless
public class CarritoCompraRestImpl implements ICarritoCompraRest {
    
    @Inject
    private CarritoCompraBean carritoCompraBean;

    @Inject
    private CarritoCompraProductoBean carritoCompraProductoBean;

    public Response alamcenarProductoCarritoCompra(String jsonProducto) {
        final ProductoTo productoAgregadoAlCarritoCompra = UtilRest.jsonToDto(jsonProducto, ProductoTo.class);
        
        final CarritoCompra carritoCompra = carritoCompraBean.obtenerCarritoPorUsuarioInvitado();
        
        Long codigoCarritoCompra;
        if (null == carritoCompra) {
            codigoCarritoCompra = carritoCompraBean.crear(productoAgregadoAlCarritoCompra);
        } else {
            codigoCarritoCompra = carritoCompra.getCodigo();
        }
        
        carritoCompraProductoBean.agregarProductoAlCarritoCompras(codigoCarritoCompra, productoAgregadoAlCarritoCompra);
        return Response.ok().entity(codigoCarritoCompra).build();
    }
    
    public Response eliminarProductoCarritoCompras(Long codigoProducto) {
        carritoCompraProductoBean.eliminarProductoDelCarritoCompra(codigoProducto);
        return Response.ok().build();
    }

    public Response obtenerProductos(Long codigoCarritoCompra) {
        final List<ProductoTo> listaProductoTo = carritoCompraBean
                .obtenerProductosPorCodigoCarritoCompra(codigoCarritoCompra);
        if (listaProductoTo.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaProductoTo).build();
        }
    }
    
    public Response obtenerProductosPorUsuarioInvitado() {
        final List<ProductoTo> listaProductoTo = carritoCompraBean.obtenerPorUsuarioInvitado();
        if (listaProductoTo.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaProductoTo).build();
        }
    }
    
}

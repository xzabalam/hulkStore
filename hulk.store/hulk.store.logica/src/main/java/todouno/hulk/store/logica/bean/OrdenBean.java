package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.OrdenDao;
import todouno.hulk.store.logica.dao.OrdenProductoDao;
import todouno.hulk.store.modelo.CarritoCompra;
import todouno.hulk.store.modelo.Orden;
import todouno.hulk.store.to.OrdenTo;

@Stateless
public class OrdenBean implements Serializable {
    private static final long serialVersionUID = -4144226025119532010L;
    
    @Inject
    private OrdenDao ordenDao;
    
    @Inject
    private OrdenProductoDao ordenProductoDao;

    @Inject
    private CarritoCompraBean carritoCompraBean;

    public void almacenarOrden(OrdenTo ordenTo) {
        final CarritoCompra carritoCompra = carritoCompraBean.obtenerCarritoPorUsuarioInvitado();
        final Orden orden = new Orden(ordenTo);
        orden.setFechaCreacion(new Date());
        orden.setEstado(EstadoEnum.ACT);
        orden.setUsuarioSolicita(carritoCompra.getUsuarioDeseaComprar());
        ordenDao.crear(orden);
        carritoCompra.getListaProductosCarritoCompra().stream().forEach(productoCarritoCompra -> {
            ordenProductoDao.crearOrdenProducto(productoCarritoCompra, orden);
        });

        carritoCompra.setEstado(EstadoEnum.INA);
        carritoCompraBean.modificar(carritoCompra);
    }
    
    public List<OrdenTo> obtenerActivas() {
        final List<Orden> ordenesActivas = ordenDao.obtenerActivas();
        
        return ordenesActivas.stream().map(orden -> {
            return new OrdenTo(orden);
        }).collect(Collectors.toList());
    }
    
    public List<Orden> obtenerTodas() {
        return ordenDao.obtenerTodos();
    }
}

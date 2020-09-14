package todouno.hulk.store.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.CarritoCompraProducto;

@Stateless
public class CarritoCompraProductoDao extends GenericoDaoUtil<CarritoCompraProducto> {
    private static final long serialVersionUID = 4426591914984721704L;

    public CarritoCompraProductoDao() {
        super(CarritoCompraProducto.class);
    }

    public CarritoCompraProductoDao(Class<CarritoCompraProducto> tablaEntidad) {
        super(tablaEntidad);
    }

    public List<CarritoCompraProducto> obtenerPorCodigoProducto(Long codigoProducto) {
        final TypedQuery<CarritoCompraProducto> tQuery = em
                .createNamedQuery("CarritoCompraProducto.productosPorCodigoProducto", CarritoCompraProducto.class);
        tQuery.setParameter("codigoProducto", codigoProducto);

        return tQuery.getResultList();
    }
}

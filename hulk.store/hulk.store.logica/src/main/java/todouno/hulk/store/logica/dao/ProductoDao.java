package todouno.hulk.store.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.Producto;
import todouno.hulk.store.to.ProductoTo;

@Stateless
public class ProductoDao extends GenericoDaoUtil<Producto> {
    private static final long serialVersionUID = -4317014641260158506L;

    public ProductoDao() {
        super(Producto.class);
    }

    public ProductoDao(Class<Producto> tablaEntidad) {
        super(tablaEntidad);
    }

    public List<ProductoTo> obtenerListadoActivas() {
        final TypedQuery<ProductoTo> tQuery = em.createNamedQuery("Producto.obtenerActivas", ProductoTo.class);
        tQuery.setParameter("estado", EstadoEnum.ACT);

        return tQuery.getResultList();
    }

    public List<Producto> obtenerListadoPorCategoria(Long idCategoria) {
        final TypedQuery<Producto> tQuery = em.createNamedQuery("Producto.obtenerPorCategoria", Producto.class);
        tQuery.setParameter("idCategoria", idCategoria);
        tQuery.setParameter("estado", EstadoEnum.ACT);

        return tQuery.getResultList();
    }
}

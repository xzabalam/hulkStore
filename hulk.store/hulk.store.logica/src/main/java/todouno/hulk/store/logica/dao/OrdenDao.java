package todouno.hulk.store.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.Orden;

@Stateless
public class OrdenDao extends GenericoDaoUtil<Orden> {
    private static final long serialVersionUID = 6037993494266555689L;
    
    public OrdenDao() {
        super(Orden.class);
    }
    
    public OrdenDao(Class<Orden> tablaEntidad) {
        super(tablaEntidad);
    }

    public List<Orden> obtenerActivas() {
        final TypedQuery<Orden> tQuery = em.createNamedQuery("Orden.obtenerActivas", Orden.class);
        tQuery.setParameter("estado", EstadoEnum.ACT);
        return tQuery.getResultList();
    }
}

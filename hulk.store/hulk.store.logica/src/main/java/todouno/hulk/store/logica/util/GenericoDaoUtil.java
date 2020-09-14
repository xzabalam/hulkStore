package todouno.hulk.store.logica.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class GenericoDaoUtil<T> implements Serializable {
    
    private static final long serialVersionUID = 6606042634369029157L;
    
    @PersistenceContext(unitName = "TodoUnoHulkStorePU")
    protected EntityManager em;
    
    private final Class<T> tablaEntidad;

    public GenericoDaoUtil(final Class<T> tablaEntidad) {
        this.tablaEntidad = tablaEntidad;
    }

    public void crear(final T tablaEntidad) {
        em.persist(tablaEntidad);
    }
    
    public void eliminar(final Long identificador) {
        final T tablaEntidadEliminar = obtenerPorCodigo(identificador);
        em.remove(tablaEntidadEliminar);
    }
    
    public T modificar(final T tablaEntidad) {
        return em.merge(tablaEntidad);
    }
    
    public T obtenerPorCodigo(final Long identificador) {
        return em.find(tablaEntidad, identificador);
    }
    
    public List<T> obtenerTodos() {
        final TypedQuery<
                T> consulta = em.createQuery("Select t from " + tablaEntidad.getSimpleName() + " t", tablaEntidad);
        return consulta.getResultList();
    }
    
    public List<T> obtenerTodos(int numeroDePagina, int elementosPorPagina) {
        final TypedQuery<
                T> consulta = em.createQuery("Select t from " + tablaEntidad.getSimpleName() + " t", tablaEntidad);
        consulta.setFirstResult((numeroDePagina - 1) * elementosPorPagina);
        consulta.setMaxResults(elementosPorPagina);
        return consulta.getResultList();
    }
}

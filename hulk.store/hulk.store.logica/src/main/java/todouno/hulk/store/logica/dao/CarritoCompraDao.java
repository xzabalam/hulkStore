package todouno.hulk.store.logica.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.enumeracion.TipoUsuarioEnum;
import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.CarritoCompra;

@Stateless
public class CarritoCompraDao extends GenericoDaoUtil<CarritoCompra> {
    private static final long serialVersionUID = -226892868417704845L;

    public CarritoCompraDao() {
        super(CarritoCompra.class);
    }

    public CarritoCompraDao(Class<CarritoCompra> tablaEntidad) {
        super(tablaEntidad);
    }
    
    public CarritoCompra obtenerPorUsuarioInvitado() {
        final TypedQuery<CarritoCompra> tQuery = em.createNamedQuery("CarritoCompra.productosPorUsuarioInvitado",
                CarritoCompra.class);
        
        tQuery.setParameter("estado", EstadoEnum.ACT);
        tQuery.setParameter("tipoUsuario", TipoUsuarioEnum.INVITADO.toString());

        try {
            return tQuery.getSingleResult();
        } catch (final NoResultException e) {
            return null;
        } catch (final NonUniqueResultException e) {
            return tQuery.getResultList().get(0);
        }
    }
}

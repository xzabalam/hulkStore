package todouno.hulk.store.logica.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.Categoria;
import todouno.hulk.store.to.CategoriaTo;

@Stateless
public class CategoriaDao extends GenericoDaoUtil<Categoria> {

    private static final long serialVersionUID = -1586839122054439575L;
    
    public CategoriaDao() {
        super(Categoria.class);
    }
    
    public CategoriaDao(Class<Categoria> tablaEntidad) {
        super(tablaEntidad);
    }

    public List<CategoriaTo> obtenerActivas() {
        final TypedQuery<
                CategoriaTo> tQuery = em.createNamedQuery("Categorias.obtenerActivasParaRest", CategoriaTo.class);
        tQuery.setParameter("estado", EstadoEnum.ACT);
        
        return tQuery.getResultList();
    }
}

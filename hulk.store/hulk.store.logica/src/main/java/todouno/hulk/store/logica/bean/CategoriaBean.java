package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.logica.dao.CategoriaDao;
import todouno.hulk.store.modelo.Categoria;
import todouno.hulk.store.to.CategoriaTo;

@Stateless
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = -3654663470808506686L;

    @Inject
    private CategoriaDao categoriaDao;

    public List<CategoriaTo> obtenerActivas() {
        return categoriaDao.obtenerActivas();
    }
    
    public List<Categoria> obtenerTodas() {
        return categoriaDao.obtenerTodos();
    }
}

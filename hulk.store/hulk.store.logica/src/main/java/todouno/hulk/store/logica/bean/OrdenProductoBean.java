package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.logica.dao.OrdenProductoDao;
import todouno.hulk.store.modelo.OrdenProducto;

@Stateless
public class OrdenProductoBean implements Serializable {
    private static final long serialVersionUID = -808295928427609188L;
    
    @Inject
    private OrdenProductoDao ordenProductoDao;

    public List<OrdenProducto> obtenerTodas() {
        return ordenProductoDao.obtenerTodos();
    }
}

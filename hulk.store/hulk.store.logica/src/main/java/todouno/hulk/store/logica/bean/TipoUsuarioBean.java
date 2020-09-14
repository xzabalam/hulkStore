package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.logica.dao.TipoUsuarioDao;
import todouno.hulk.store.modelo.TipoUsuario;

@Stateless
public class TipoUsuarioBean implements Serializable {
    private static final long serialVersionUID = -2530787426906544229L;

    @Inject
    private TipoUsuarioDao tipoUsuarioDao;
    
    public List<TipoUsuario> obtenerTodas() {
        return tipoUsuarioDao.obtenerTodos();
    }
}

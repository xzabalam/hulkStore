package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.logica.dao.UsuarioDao;
import todouno.hulk.store.modelo.Usuario;

@Stateless
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 3468055464519622695L;

    @Inject
    private UsuarioDao usuarioDao;
    
    public List<Usuario> obtenerTodas() {
        return usuarioDao.obtenerTodos();
    }
}

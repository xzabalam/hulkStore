package todouno.hulk.store.logica.dao;

import javax.ejb.Stateless;

import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.Usuario;

@Stateless
public class UsuarioDao extends GenericoDaoUtil<Usuario> {
    private static final long serialVersionUID = -5552904238408529585L;

    public UsuarioDao() {
        super(Usuario.class);
    }

    public UsuarioDao(Class<Usuario> tablaEntidad) {
        super(tablaEntidad);
    }

}

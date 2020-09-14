package todouno.hulk.store.logica.dao;

import javax.ejb.Stateless;

import todouno.hulk.store.logica.util.GenericoDaoUtil;
import todouno.hulk.store.modelo.TipoUsuario;

@Stateless
public class TipoUsuarioDao extends GenericoDaoUtil<TipoUsuario> {

    private static final long serialVersionUID = -1586839122054439575L;
    
    public TipoUsuarioDao() {
        super(TipoUsuario.class);
    }
    
    public TipoUsuarioDao(Class<TipoUsuario> tablaEntidad) {
        super(tablaEntidad);
    }
}
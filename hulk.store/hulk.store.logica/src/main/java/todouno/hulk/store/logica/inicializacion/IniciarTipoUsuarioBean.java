package todouno.hulk.store.logica.inicializacion;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.enumeracion.TipoUsuarioEnum;
import todouno.hulk.store.logica.dao.TipoUsuarioDao;
import todouno.hulk.store.modelo.TipoUsuario;

@Stateless
public class IniciarTipoUsuarioBean {
    
    @Inject
    private TipoUsuarioDao tipoUsuarioDao;
    
    public void crearTipoUsuario(String tipo, String descripcion) {
        final TipoUsuario tipoUsuarioAdministrador = new TipoUsuario();
        
        tipoUsuarioAdministrador.setTipo(tipo);
        tipoUsuarioAdministrador.setDescripcion(descripcion);
        tipoUsuarioAdministrador.setEstado(EstadoEnum.ACT);
        
        tipoUsuarioDao.crear(tipoUsuarioAdministrador);
    }
    
    public void llenarTipoUsuarioPrueba() {
        crearTipoUsuario(TipoUsuarioEnum.ADMINISTRADOR.toString(), TipoUsuarioEnum.ADMINISTRADOR.toString());
        crearTipoUsuario(TipoUsuarioEnum.VENDEDOR.toString(), TipoUsuarioEnum.VENDEDOR.toString());
        crearTipoUsuario(TipoUsuarioEnum.COMPRADOR.toString(), TipoUsuarioEnum.COMPRADOR.toString());
        crearTipoUsuario(TipoUsuarioEnum.INVITADO.toString(), TipoUsuarioEnum.INVITADO.toString());
    }
}

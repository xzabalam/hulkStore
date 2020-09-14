package todouno.hulk.store.logica.inicializacion;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.UsuarioDao;
import todouno.hulk.store.modelo.TipoUsuario;
import todouno.hulk.store.modelo.Usuario;

@Stateless
public class IniciarUsuarioBean {

    @Inject
    private UsuarioDao usuarioDao;

    public void crearUsuario(TipoUsuario tipoUsuario, String nombres, String apellidos, String celular,
            String correoElectronico) {
        final Date fecha = new Date();

        final Usuario usuario = new Usuario();
        
        usuario.setNombre(nombres);
        usuario.setApellido(apellidos);
        usuario.setCelular(celular);
        usuario.setCorreoElectronico(correoElectronico);
        
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setEstado(EstadoEnum.ACT);
        usuario.setFechaActualizacion(fecha);
        usuario.setFechaCreacion(fecha);
        usuario.setHashClave("cualquier cosa por el momento");
        
        usuarioDao.crear(usuario);

    }
    
    public void crearUsuariosPrueba() {
        crearUsuario(new TipoUsuario(1L), "Francisco Xavier", "Zabala Miranda", "0991426944", "usuario0@gmail.com");
        crearUsuario(new TipoUsuario(2L), "Blanca Alexandra", "Zabala Miranda", "0991426945", "usuario1@gmail.com");
        crearUsuario(new TipoUsuario(3L), "Ana Gabriela", "Zabala Miranda", "0991426946", "usuario2@gmail.com");
        crearUsuario(new TipoUsuario(4L), "Vanessa Raquel", "Zabala Miranda", "0991426947", "usuario3@gmail.com");
    }
}

package todouno.hulk.store.logica.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import todouno.hulk.store.logica.inicializacion.IniciarCategoriaBean;
import todouno.hulk.store.logica.inicializacion.IniciarProductoBean;
import todouno.hulk.store.logica.inicializacion.IniciarTipoUsuarioBean;
import todouno.hulk.store.logica.inicializacion.IniciarUsuarioBean;

@Startup
@Singleton
public class InicializarBaseDeDatosBean {
    
    @Inject
    private IniciarTipoUsuarioBean iniciarTipoUsuarioBean;

    @Inject
    private IniciarUsuarioBean iniciarUsuarioBean;

    @Inject
    private IniciarCategoriaBean iniciarCategoriaBean;

    @Inject
    private IniciarProductoBean iniciarProductoBean;
    
    @PostConstruct
    public void init() {
        iniciarTipoUsuarioBean.llenarTipoUsuarioPrueba();
        iniciarUsuarioBean.crearUsuariosPrueba();
        iniciarCategoriaBean.llenarCategoriasPrueba();
        iniciarProductoBean.llenarProductosPrueba();
    }

}

package todouno.hulk.store.web.rest.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import todouno.hulk.store.logica.bean.CategoriaBean;
import todouno.hulk.store.to.CategoriaTo;
import todouno.hulk.store.web.rest.ICategoriaRest;

@Stateless
public class CategoriaRestImpl implements ICategoriaRest {

    @Inject
    private CategoriaBean categoriaBean;
    
    public Response obtenerActivos() {
        final List<CategoriaTo> listaCategorias = categoriaBean.obtenerActivas();
        
        if (listaCategorias.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaCategorias).build();
        }
    }
}

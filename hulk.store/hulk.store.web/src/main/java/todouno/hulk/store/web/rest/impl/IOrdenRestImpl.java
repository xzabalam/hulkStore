package todouno.hulk.store.web.rest.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import todouno.hulk.store.logica.bean.OrdenBean;
import todouno.hulk.store.to.OrdenTo;
import todouno.hulk.store.web.rest.IOrdenRest;
import todouno.hulk.store.web.rest.util.UtilRest;

@Stateless
public class IOrdenRestImpl implements IOrdenRest {
    
    @Inject
    private OrdenBean ordenBean;

    public Response alamcenarOrden(String jsonOrden) {
        final OrdenTo ordenTo = UtilRest.jsonToDto(jsonOrden, OrdenTo.class);
        ordenBean.almacenarOrden(ordenTo);
        return Response.ok().build();
    }
    
    public Response obtenerActivas() {
        final List<OrdenTo> listaOrdenesTo = ordenBean.obtenerActivas();

        if (listaOrdenesTo.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaOrdenesTo).build();
        }
    }
    
}

package todouno.hulk.store.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/orden")
public interface IOrdenRest {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response alamcenarOrden(String jsonOrden);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerActivas();
}

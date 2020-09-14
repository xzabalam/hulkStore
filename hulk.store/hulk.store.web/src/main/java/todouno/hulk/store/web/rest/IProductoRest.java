package todouno.hulk.store.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/productos")
public interface IProductoRest {
    
    @GET
    @Path("/detalle/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerDetalle(@PathParam("idProducto") Long idProducto);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerListadoActivas();
    
    @GET
    @Path("/{idCategoria}")
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerListadoPorCategoria(@PathParam("idCategoria") Long idCategoria);
}

package todouno.hulk.store.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/carrito-compra")
public interface ICarritoCompraRest {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response alamcenarProductoCarritoCompra(String jsonProducto);

    @DELETE
    @Path("/{codigoProducto}")
    Response eliminarProductoCarritoCompras(@PathParam("codigoProducto") Long codigoProducto);
    
    @GET
    @Path("/{codigoCarritoCompra}")
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerProductos(@PathParam("codigoCarritoCompra") Long codigoCarritoCompra);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response obtenerProductosPorUsuarioInvitado();

}

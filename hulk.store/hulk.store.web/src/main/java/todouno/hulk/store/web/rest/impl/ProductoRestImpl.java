package todouno.hulk.store.web.rest.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import todouno.hulk.store.logica.bean.ProductoBean;
import todouno.hulk.store.to.ProductoTo;
import todouno.hulk.store.web.rest.IProductoRest;

@Stateless
public class ProductoRestImpl implements IProductoRest {
    
    @Inject
    private ProductoBean productoBean;

    public Response obtenerDetalle(Long idProducto) {
        final ProductoTo producto = productoBean.obtenerPorCodigo(idProducto);
        if (null == producto) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(producto).build();
        }
    }

    public Response obtenerListadoActivas() {
        final List<ProductoTo> listaProductos = productoBean.obtenerTodas();

        if (listaProductos.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaProductos).build();
        }
    }

    public Response obtenerListadoPorCategoria(Long idCategoria) {
        final List<ProductoTo> listaProductos = productoBean.obtenerListaPorCategoria(idCategoria);

        if (listaProductos.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(listaProductos).build();
        }
    }
}

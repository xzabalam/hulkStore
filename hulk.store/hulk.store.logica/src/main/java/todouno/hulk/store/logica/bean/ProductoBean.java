package todouno.hulk.store.logica.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.logica.dao.ProductoDao;
import todouno.hulk.store.modelo.Producto;
import todouno.hulk.store.to.ProductoTo;

@Stateless
public class ProductoBean implements Serializable {
    private static final long serialVersionUID = -811153973945622320L;

    @Inject
    private ProductoDao productoDao;
    
    public List<ProductoTo> obtenerListaPorCategoria(Long idCategoria) {
        final List<Producto> listaProductoPorCategoria = productoDao.obtenerListadoPorCategoria(idCategoria);
        
        return listaProductoPorCategoria.stream().map(producto -> {
            return new ProductoTo(producto);
        }).collect(Collectors.toList());
    }
    
    public ProductoTo obtenerPorCodigo(Long idProducto) {
        final Producto producto = productoDao.obtenerPorCodigo(idProducto);
        return new ProductoTo(producto);
    }

    public List<ProductoTo> obtenerTodas() {
        return productoDao.obtenerListadoActivas();
    }
}

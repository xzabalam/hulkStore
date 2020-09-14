package todouno.hulk.store.logica.inicializacion;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.CategoriaDao;
import todouno.hulk.store.modelo.Categoria;

@Stateless
public class IniciarCategoriaBean {

    @Inject
    private CategoriaDao categoriaDao;
    
    public void crearCategoria(String nombre, String descripcion, String urlImagen) {
        final Categoria categoriaAccesorios = new Categoria();
        categoriaAccesorios.setNombre(nombre);
        categoriaAccesorios.setDescripcion(descripcion);
        categoriaAccesorios.setEstado(EstadoEnum.ACT);
        categoriaAccesorios.setUrlImagen(urlImagen);

        categoriaDao.crear(categoriaAccesorios);
    }

    public void llenarCategoriasPrueba() {
        crearCategoria("Camisetas", "Descripción de categorias",
                "https://http2.mlstatic.com/remeras-graciosas-frases-personalizadas-estampadas-D_NQ_NP_688383-MLU27212605886_042018-F.jpg");
        crearCategoria("Vasos", "Descripción de Vasos",
                "https://img.freepik.com/vector-gratis/conjunto-vasos-realistas-transparentes-leche-vaso-aislado_190024-161.jpg?size=626&ext=jpg");
        crearCategoria("Comics", "Descripción de Comics",
                "https://www.superprof.es/blog/wp-content/uploads/2017/08/comics-marvel-980x613.jpg");
        crearCategoria("Juguetes", "Descripción de Juguetes",
                "https://microjurisve.files.wordpress.com/2013/10/juguetes.jpg");
        crearCategoria("Accesorios", "Descripción de Accesorios",
                "https://i.ebayimg.com/images/g/rDwAAOSwNSxVFFEU/s-l400.jpg");
    }
}

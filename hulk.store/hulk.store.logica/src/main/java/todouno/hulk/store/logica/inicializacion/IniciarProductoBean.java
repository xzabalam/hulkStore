package todouno.hulk.store.logica.inicializacion;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import todouno.hulk.store.enumeracion.EstadoEnum;
import todouno.hulk.store.logica.dao.ProductoDao;
import todouno.hulk.store.modelo.Categoria;
import todouno.hulk.store.modelo.Producto;
import todouno.hulk.store.modelo.Usuario;

@Stateless
public class IniciarProductoBean {
    @Inject
    private ProductoDao productoDao;
    
    public void crearProductosPrueba(Categoria categoria, String titulo, String descripcion, String resumen,
            String urlImagen, String sku) {
        final Date fecha = new Date();

        final Producto producto = new Producto();
        producto.setCantidad(100);
        producto.setCategoria(categoria);
        producto.setCostoCompra(200D);
        producto.setCostoVenta(250D);
        producto.setDescripcion(descripcion);
        producto.setDescuento(10D);
        producto.setEstado(EstadoEnum.ACT);
        producto.setFechaActualizacion(fecha);
        producto.setFechaCreacion(fecha);
        producto.setFechaPublicacion(fecha);
        producto.setTitulo(titulo);
        producto.setSlug(titulo);
        producto.setResumen(resumen);
        producto.setUrlImagen(urlImagen);
        producto.setSku(sku);
        producto.setUsuarioCrea(new Usuario(1L));
        
        productoDao.crear(producto);
    }

    public void llenarProductosPrueba() {
        // camisetas
        crearProductosPrueba(new Categoria(1L), "Camiseta 1", "Descripcion camiseta 1", "Resumen camiseta 1",
                "https://regalame.ec/wp-content/uploads/2019/03/camiseta-come-galletas.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(1L), "Camiseta 2", "Descripcion camiseta 2", "Resumen camiseta 2",
                "https://http2.mlstatic.com/confeccion-camisetas-manga-ranglan-algodon-para-sublimar-D_NQ_NP_997262-MEC31007462223_062019-Q.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(1L), "Camiseta 3", "Descripcion camiseta 3", "Resumen camiseta 3",
                "https://i.pinimg.com/236x/b7/e3/8b/b7e38b7111481c2c72c98990ec3d3889.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(1L), "Camiseta 4", "Descripcion camiseta 4", "Resumen camiseta 4",
                "https://srv.latostadora.com/designall.dll/covid_pac--i:135623270098401356232017092627;h:320;s:H_A27;k:bd29157ce45d776788c70a53624d798f;p:1.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(1L), "Camiseta 5", "Descripcion camiseta 5", "Resumen camiseta 5",
                "https://as.com/showroom/imagenes/2019/07/31/portada/1564587901_534573_1564653620_sumario_normal.jpg",
                "ABC-DEF_0001");

        // Vasos
        crearProductosPrueba(new Categoria(2L), "Vaso 1", "Descripcion Vaso 1", "Resumen Vaso 1",
                "https://www.irvix.com.ec/wp-content/uploads/2014/08/23251.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(2L), "Vaso 2", "Descripcion Vaso 2", "Resumen Vaso 2",
                "https://www.irvix.com.ec/wp-content/uploads/2014/08/151411.png", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(2L), "Vaso 3", "Descripcion Vaso 3", "Resumen Vaso 3",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQJ6dMQ7Yjp1urBRsW9EOT-aVVol50zSKPyjQ&usqp=CAU",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(2L), "Vaso 4", "Descripcion Vaso 4", "Resumen Vaso 4",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRt8TlXQBMEotAKEMMIKKY15GFPvtNGAI5XpQ&usqp=CAU",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(2L), "Vaso 5", "Descripcion Vaso 5", "Resumen Vaso 5",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRW_3EpixEmS1GNeJfsxttVjWr5JrwF4vVaCw&usqp=CAU",
                "ABC-DEF_0001");

        // Comics
        crearProductosPrueba(new Categoria(3L), "Comic 1", "Descripcion Comic 1", "Resumen Comic 1",
                "https://www.allcitycanvas.com/wp-content/uploads/2019/07/las-portadas-marvel-avengers-1.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(3L), "Comic 2", "Descripcion Comic 2", "Resumen Comic 2",
                "https://i.pinimg.com/originals/7e/f8/fe/7ef8fe6c97d5ba807958f1fb4f4beac8.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(3L), "Comic 3", "Descripcion Comic 3", "Resumen Comic 3",
                "https://i.pinimg.com/originals/70/17/a1/7017a1599607337468080a3280af95f7.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(3L), "Comic 4", "Descripcion Comic 4", "Resumen Comic 4",
                "https://i.pinimg.com/736x/e2/5b/47/e25b47f42c2851df3e544c95ec1a7a8e.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(3L), "Comic 5", "Descripcion Comic 5", "Resumen Comic 5",
                "https://manuelsalazarlima.files.wordpress.com/2017/12/harleyquinn.jpg?w=1280", "ABC-DEF_0001");

        // juguetes
        crearProductosPrueba(new Categoria(4L), "Juguete 1", "Descripcion Juguete 1", "Resumen Juguete 1",
                "https://www.todoparati.online/wp-content/uploads/2018/11/rojo-grnade-pag-min.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(4L), "Juguete 2", "Descripcion Juguete 2", "Resumen Juguete 2",
                "https://www.toysrus.es/medias/?context=bWFzdGVyfHByb2R1Y3RfaW1hZ2VzfDE3NDAwfGltYWdlL2pwZWd8aGQxL2hlYi84OTE3NDg3ODQ1NDA2fDg4MzQ1MjNmMmQ0MTQ1YWUzZGEzMjllNDU3N2JlNTdlMTA1OWJhOTNjYjg0ZmQ4M2E5NjExM2I5NjNmNzJlNjg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(4L), "Juguete 3", "Descripcion Juguete 3", "Resumen Juguete 3",
                "https://dnzjdxhm454vl.cloudfront.net/media/catalog/product/l/e/lego-ideas-nasa-apollo-saturn-v-_21309_--10f190b5.zoom.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(4L), "Juguete 4", "Descripcion Juguete 4", "Resumen Juguete 4",
                "https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202004/17/00197630157184____1__640x640.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(4L), "Juguete 5", "Descripcion Juguete 5", "Resumen Juguete 5",
                "https://theawesomer.com/photos/2019/07/lego_21318_treehouse_1.jpg", "ABC-DEF_0001");

        // accesorios
        crearProductosPrueba(new Categoria(5L), "Accesorio 1", "Descripcion Accesorio 1", "Resumen Accesorio 1",
                "https://images-na.ssl-images-amazon.com/images/I/91JIx247U4L._AC_SX425_.jpg", "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(5L), "Accesorio 2", "Descripcion Accesorio 2", "Resumen Accesorio 2",
                "https://res.cloudinary.com/teepublic/image/private/s--wKbJ0FX1--/t_Resized%20Artwork/c_fit,g_north_west,h_1054,w_1054/co_ffffff,e_outline:53/co_ffffff,e_outline:inner_fill:53/co_bbbbbb,e_outline:3:1000/c_mpad,g_center,h_1260,w_1260/b_rgb:eeeeee/t_watermark_lock/c_limit,f_jpg,h_630,q_90,w_630/v1571624971/production/designs/6404281_0.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(5L), "Accesorio 3", "Descripcion Accesorio 3", "Resumen Accesorio 3",
                "https://ae01.alicdn.com/kf/HTB1h9OvfA.HL1JjSZFlq6yiRFXaR.jpg?size=171879&height=640&width=640&hash=14e33a09b4de7ace06fbb8a79fcc188f",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(5L), "Accesorio 4", "Descripcion Accesorio 4", "Resumen Accesorio 4",
                "https://i2.wp.com/ae01.alicdn.com/kf/HTB10GaVVMHqK1RjSZFEq6AGMXXac/Pegatina-para-pared-de-vengadores-superh%C3%A9roes-vengadores-P%C3%B3ster-Art%C3%ADstico-de-Spiderman-Capit%C3%A1n-Am%C3%A9rica-Hulk-pegatinas-para.jpg",
                "ABC-DEF_0001");
        crearProductosPrueba(new Categoria(5L), "Accesorio 5", "Descripcion Accesorio 5", "Resumen Accesorio 5",
                "https://lh3.googleusercontent.com/proxy/qBo7sn8esd_-dXwd1_lWu_oRIGDcVh6gzQ4Mi_Lb9qIWZumuttHe8HtNydtWnQqpThvWhvUkN4Sj9YwiYJ_ITV25KjHjsg9sVgFOBaZ2WRxi6lX7T5z63uVThTQSQ9ZvkjkqQU7UJfPEkie3CjjR",
                "ABC-DEF_0001");
        
    }
}

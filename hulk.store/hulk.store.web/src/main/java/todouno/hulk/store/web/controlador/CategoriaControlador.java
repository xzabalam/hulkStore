package todouno.hulk.store.web.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import todouno.hulk.store.logica.bean.CategoriaBean;
import todouno.hulk.store.modelo.Categoria;

@ViewScoped
@ManagedBean(name = "categoriaControlador")
public class CategoriaControlador {
    @Inject
    private CategoriaBean categoriaBean;

    private List<Categoria> listaCategorias;

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }
    
    @PostConstruct
    public void inicializar() {
        listaCategorias = categoriaBean.obtenerTodas();
    }
    
    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
}

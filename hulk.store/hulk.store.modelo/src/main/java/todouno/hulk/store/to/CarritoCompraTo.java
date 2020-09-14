package todouno.hulk.store.to;

import java.io.Serializable;
import java.util.List;

public class CarritoCompraTo implements Serializable {

    private static final long serialVersionUID = -4890972331050177091L;

    private Long codigo;
    private List<CarritoCompraProductoTo> listaProductosCarritoCompra;
    private UsuarioTo usuarioDeseaComprar;

    public Long getCodigo() {
        return codigo;
    }
    
    public List<CarritoCompraProductoTo> getListaProductosCarritoCompra() {
        return listaProductosCarritoCompra;
    }

    public UsuarioTo getUsuarioDeseaComprar() {
        return usuarioDeseaComprar;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public void setListaProductosCarritoCompra(List<CarritoCompraProductoTo> listaProductosCarritoCompra) {
        this.listaProductosCarritoCompra = listaProductosCarritoCompra;
    }

    public void setUsuarioDeseaComprar(UsuarioTo usuarioDeseaComprar) {
        this.usuarioDeseaComprar = usuarioDeseaComprar;
    }

}

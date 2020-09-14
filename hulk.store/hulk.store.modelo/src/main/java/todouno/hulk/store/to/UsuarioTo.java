package todouno.hulk.store.to;

import java.io.Serializable;
import java.util.List;

public class UsuarioTo implements Serializable {

    private static final long serialVersionUID = 4769124011412599413L;

    private Long codigo;
    private String nombre;
    private String apellido;
    private String celular;
    private String correoElectronico;
    private String hashClave;
    private List<ProductoTo> listaProductos;
    private List<CarritoCompraTo> listaProductosCarritoCompras;
    private List<OrdenTo> listaProductosOrdenCompra;
    private TipoUsuarioTo tipoUsuario;

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getHashClave() {
        return hashClave;
    }

    public List<ProductoTo> getListaProductos() {
        return listaProductos;
    }

    public List<CarritoCompraTo> getListaProductosCarritoCompras() {
        return listaProductosCarritoCompras;
    }

    public List<OrdenTo> getListaProductosOrdenCompra() {
        return listaProductosOrdenCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoUsuarioTo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setHashClave(String hashClave) {
        this.hashClave = hashClave;
    }

    public void setListaProductos(List<ProductoTo> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setListaProductosCarritoCompras(List<CarritoCompraTo> listaProductosCarritoCompras) {
        this.listaProductosCarritoCompras = listaProductosCarritoCompras;
    }

    public void setListaProductosOrdenCompra(List<OrdenTo> listaProductosOrdenCompra) {
        this.listaProductosOrdenCompra = listaProductosOrdenCompra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoUsuario(TipoUsuarioTo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}

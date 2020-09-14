package todouno.hulk.store.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.Auditoria;

@Entity
@Table(name = "USUARIO")
public class Usuario extends Auditoria {

    private static final long serialVersionUID = 4769124011412599413L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "APELLIDO")
    private String apellido;
    
    @Column(name = "CELULAR")
    private String celular;
    
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Column(name = "HASH_CLAVE")
    private String hashClave;
    
    @OneToMany(mappedBy = "usuarioCrea")
    private List<Producto> listaProductos;
    
    @OneToMany(mappedBy = "usuarioDeseaComprar")
    private List<CarritoCompra> listaProductosCarritoCompras;

    @OneToMany(mappedBy = "usuarioSolicita")
    private List<Orden> listaProductosOrdenCompra;

    @ManyToOne(targetEntity = TipoUsuario.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_TIPO_USUARIO")
    private TipoUsuario tipoUsuario;
    
    public Usuario() {
        super();
    }
    
    public Usuario(Long codigo) {
        super();
        this.codigo = codigo;
    }
    
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

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<CarritoCompra> getListaProductosCarritoCompras() {
        return listaProductosCarritoCompras;
    }

    public List<Orden> getListaProductosOrdenCompra() {
        return listaProductosOrdenCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoUsuario getTipoUsuario() {
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

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setListaProductosCarritoCompras(List<CarritoCompra> listaProductosCarritoCompras) {
        this.listaProductosCarritoCompras = listaProductosCarritoCompras;
    }

    public void setListaProductosOrdenCompra(List<Orden> listaProductosOrdenCompra) {
        this.listaProductosOrdenCompra = listaProductosOrdenCompra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}

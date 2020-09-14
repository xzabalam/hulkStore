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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.Auditoria;

@Entity
@Table(name = "CATEGORIA")
@NamedQueries({ @NamedQuery(name = "Categorias.obtenerActivasParaRest",
        query = "select new todouno.hulk.store.to.CategoriaTo(c.codigo, c.nombre, c.descripcion, c.urlImagen) from Categoria c where c.estado = :estado"), })
public class Categoria extends Auditoria {
    private static final long serialVersionUID = -8935710703629383000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;
    
    @Column(name = "CODIGO_CATEGORIA_PADRE")
    private Long codigoCategoriaPadre;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "SLUG")
    private String slug;

    @Column(name = "URL_IMAGEN")
    private String urlImagen;

    @OneToMany(mappedBy = "categoriaPadre")
    private List<Categoria> subCategorias;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> listaProductos;
    
    @ManyToOne(targetEntity = Categoria.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGO_CATEGORIA_PADRE", insertable = false, updatable = false)
    private Categoria categoriaPadre;
    
    public Categoria() {
        super();
    }
    
    public Categoria(Long codigo) {
        super();
        this.codigo = codigo;
    }

    public Categoria getCategoriaPadre() {
        return categoriaPadre;
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public Long getCodigoCategoriaPadre() {
        return codigoCategoriaPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getSlug() {
        return slug;
    }

    public List<Categoria> getSubCategorias() {
        return subCategorias;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setCategoriaPadre(Categoria categoriaPadre) {
        this.categoriaPadre = categoriaPadre;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCodigoCategoriaPadre(Long codigoCategoriaPadre) {
        this.codigoCategoriaPadre = codigoCategoriaPadre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setSubCategorias(List<Categoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}

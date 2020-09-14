package todouno.hulk.store.to;

import java.io.Serializable;

public class CategoriaTo implements Serializable {
    private static final long serialVersionUID = -8935710703629383000L;
    
    private Long codigo;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    
    public CategoriaTo(Long codigo, String nombre, String descripcion, String urlImagen) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
    
    public Long getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getUrlImagen() {
        return urlImagen;
    }
    
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}

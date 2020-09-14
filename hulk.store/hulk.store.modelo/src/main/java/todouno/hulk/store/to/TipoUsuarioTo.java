package todouno.hulk.store.to;

import java.io.Serializable;
import java.util.List;

public class TipoUsuarioTo implements Serializable {
    private static final long serialVersionUID = -7544173953878632123L;

    private Long codigo;
    private String tipo;
    private String descripcion;
    private List<UsuarioTo> listaUsuario;

    public Long getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<UsuarioTo> getListaUsuario() {
        return listaUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListaUsuario(List<UsuarioTo> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

package todouno.hulk.store.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import todouno.hulk.store.modelo.comun.Auditoria;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario extends Auditoria {
    private static final long serialVersionUID = -7544173953878632123L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;
    
    @Column(name = "TIPO")
    private String tipo;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> listaUsuario;

    public TipoUsuario() {
        super();
    }

    public TipoUsuario(Long codigo) {
        super();
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public List<Usuario> getListaUsuario() {
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

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

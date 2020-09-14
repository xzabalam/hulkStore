package todouno.hulk.store.modelo.comun;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import todouno.hulk.store.enumeracion.EstadoEnum;

@MappedSuperclass
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 3833368285525721828L;
    
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;
    
    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;
    
    public EstadoEnum getEstado() {
        return estado;
    }
    
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

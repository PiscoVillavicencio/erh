package pe.gob.minsa.erh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "ipress")
public class IpressEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idipress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "stripress")
    private String nombre;
    @NotEmpty
    @Column(name = "strcodipress")
    private String codigo;
    @NotEmpty
    @Column(name = "strdireccion")
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private DistritoEntity distrito;
    @NotEmpty
    @Column(name = "strtelefono")
    private String telefono;
    @NotEmpty
    @Column(name = "strruc")
    private String ruc;
    @JsonIgnore
    @OneToMany(mappedBy = "ipress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DirectorEntity> directores;
    @JsonIgnore
    @OneToMany(mappedBy = "ipress", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PacienteEntity> pacientes;

    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "cuidador")
public class CuidadorEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @ManyToMany
    @JoinTable(
            name = "cuidadorxpaciente",
            joinColumns = @JoinColumn(name = "idpaciente"),
            inverseJoinColumns = @JoinColumn(name = "idcuidador")
    )
    Set<PacienteEntity> pacientes;
    @Id
    @Column(name = "idcuidador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaEntity persona;
    @ManyToOne
    @JoinColumn(name = "idparentesco")
    private ParentescoEntity parentesco;
    @Column(name = "strparentesconinguno")
    private String detalleParentescoNinguno;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrlaboraactualmente")
    private EstadoEnum laboraActualmente;
    @Column(name = "strlugardetrabajo")
    private String detalleLugarDeTrabajo;
    @ManyToOne
    @JoinColumn(name = "idipress")
    private IpressEntity ipress;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "idperfil")
    private PerfilEnum perfil;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

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
@Table(name = "antecedentefamiliar")
public class AntecedenteFamiliarEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @ManyToMany
    @JoinTable(
            name = "antecedentefamiliarxpaciente",
            joinColumns = @JoinColumn(name = "idpaciente"),
            inverseJoinColumns = @JoinColumn(name = "idantecedentefamiliar")
    )
    Set<PacienteEntity> pacientes;
    @Id
    @Column(name = "idantecedentefamiliar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaEntity persona;
    @ManyToOne
    @JoinColumn(name = "idparentesco")
    private ParentescoEntity parentesco;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrfamiliarcondicion")
    private EstadoEnum familiarCondicion;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrmismaenfermedad")
    private EstadoEnum mismaenfermedad;

    @Column(name = "datfdiagnostico")
    private Date fecDiagnostico;

    @Column(name = "strdetalle")
    private String detalleEnfermedad;

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

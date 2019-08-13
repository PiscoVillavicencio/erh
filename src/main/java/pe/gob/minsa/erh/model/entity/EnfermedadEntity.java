package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "enfermedad")
public class EnfermedadEntity {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idenfermedad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "strdetatallediagnostico")
    private String detalleDiagnostico;

    @NotEmpty
    @Column(name = "strexamenesauxiliares")
    private String detalleExamenesAuxiliares;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "idmedicotratante")
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "idcarpetacie10")
    private Cie10CarpetaEntity cie10Carpeta;

    @ManyToOne
    @JoinColumn(name = "idorphanet")
    private OrphanetEntity orphanet;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrconsentimientoinformado")
    private EstadoEnum consentimientoInformado;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrdiagnosticoclinico")
    private EstadoEnum diagnosticoClinico;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrdiagnosticoporgenetico")
    private EstadoEnum diagnosticoPorGenetico;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrdiagnosticobioquimico")
    private EstadoEnum diagnosticoBioquimico;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrdiagnosticoporimagenes")
    private EstadoEnum diagnosticoPorImagenes;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrdiagnosticoinmunologico")
    private EstadoEnum diagnosticoInmunologico;



    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

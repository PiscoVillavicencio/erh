package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "discapacidad")
public class DiscapacidadEntity {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "iddiscapacidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrlimitacionfuncional")
    private EstadoEnum limitacionFuncional;
    @Column(name = "strlimitacionfuncional")
    private String detallelimitacionfuncional;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrinscritoconadis")
    private EstadoEnum inscritoConadis;
    @Column(name = "strobservaciones")
    private String detalleObservaciones;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private PacienteEntity paciente;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

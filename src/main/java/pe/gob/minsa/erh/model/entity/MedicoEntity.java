package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "medicotratante")
public class MedicoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idmedicotratante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private PersonaEntity persona;
    @NotEmpty
    @Column(name = "strcmp")
    private String cmp;
    @NotEmpty
    @Column(name = "strrne")
    private String rne;
    @NotEmpty
    @Column(name = "strespecialidad")
    private String especialidad;
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
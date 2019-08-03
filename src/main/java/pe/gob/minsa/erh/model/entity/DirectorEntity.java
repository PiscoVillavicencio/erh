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
@Table(name = "director")
public class DirectorEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "iddirector")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "strdirector")
    private String nombre;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @ManyToOne
    @JoinColumn(name = "idipress")
    private IpressEntity ipress;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "idperfil")
    private PerfilEnum perfil;
}

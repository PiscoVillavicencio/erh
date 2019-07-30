package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "director")
public class Director {

    @Id
    @Column(name = "iddirector")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "strdirector")
    private String name;

    @NotEmpty
    @Column(name = "datfregistro")
    private Date fecRegistro;

    @NotEmpty
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

    @NotEmpty
    @Column(name = "chrestado")
    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idipress")
    private Ipress ipress;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "idperfil")
    private PerfilEnum perfil;

    private static final Long serialVersionUID = 1L;
}

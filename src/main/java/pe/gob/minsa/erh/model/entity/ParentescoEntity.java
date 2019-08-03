package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "parentesco")
public class ParentescoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idparentesco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "parentesco")
    private String nombre;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;

}

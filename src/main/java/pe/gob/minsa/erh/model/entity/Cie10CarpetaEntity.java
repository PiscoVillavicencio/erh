package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "carpetacie10")
public class Cie10CarpetaEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idcarpetacie10")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "strcarpetacie10")
    private String nombre;
    @NotEmpty
    @Column(name = "strcodbloquecie10")
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "idbloquecie10")
    private Cie10BloqueEntity cie10Bloque;

}

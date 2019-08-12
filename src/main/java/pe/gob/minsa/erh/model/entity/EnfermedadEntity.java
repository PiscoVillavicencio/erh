package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Data
@Table(name = "enfermedad")
public class EnfermedadEntity {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idcategoriacie10")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "strdetatallediagnostico")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idcarpetacie10")
    private Cie10CarpetaEntity cie10Carpeta;

}

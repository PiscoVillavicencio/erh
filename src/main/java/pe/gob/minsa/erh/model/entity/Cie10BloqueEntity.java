package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "bloquecie10")
public class Cie10BloqueEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idbloquecie10")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "strbloquecie10")
    private String nombre;
    @NotEmpty
    @Column(name = "strcodagrupado")
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "idcategoriacie10")
    private Cie10CategoriaEntity cie10Categoria;

}

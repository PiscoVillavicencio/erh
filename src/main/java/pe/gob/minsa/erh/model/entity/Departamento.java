package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "departamentos")
public class Departamento implements Serializable {

    @Id
    @Column(name = "iddepartamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "departamento")
    private String nombre;

    @NotEmpty
    @Column(name = "coddepartamento")
    private String codigo;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provincia> provincias;

    private static final Long serialVersionUID = 1L;

}

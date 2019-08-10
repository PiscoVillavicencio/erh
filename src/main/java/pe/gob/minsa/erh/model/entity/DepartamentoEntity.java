package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "departamentos")
public class DepartamentoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
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
}

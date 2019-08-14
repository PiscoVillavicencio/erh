package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "provincias")
public class UbiProvinciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idprovincia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "provincia")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "iddepartamento")
    private UbiDepartamentoEntity departamento;
    @NotEmpty
    @Column(name = "codprovincia")
    private String codigo;

}

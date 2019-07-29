package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "provincias")
public class Provincia implements Serializable {

    @Id
    @Column(name = "idprovincia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "provincia")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddepartamento")
    private Departamento departamento;

    @NotEmpty
    @Column(name = "codprovincia")
    private String codigo;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Distrito> distritos;

    private static final long serialVersionUID = 1L;
}

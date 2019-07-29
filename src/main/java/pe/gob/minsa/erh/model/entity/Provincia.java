package pe.gob.minsa.erh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "iddepartamento")
    private Departamento departamento;

    @NotEmpty
    @Column(name = "codprovincia")
    private String codigo;

    @JsonIgnore
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Distrito> distritos;

    private static final long serialVersionUID = 1L;
}

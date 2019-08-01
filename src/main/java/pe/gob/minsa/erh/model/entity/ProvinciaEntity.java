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
public class ProvinciaEntity implements Serializable {

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
    private DepartamentoEntity departamento;
    @NotEmpty
    @Column(name = "codprovincia")
    private String codigo;
    @JsonIgnore
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DistritoEntity> distritos;
}

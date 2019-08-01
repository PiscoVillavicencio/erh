package pe.gob.minsa.erh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "distritos")
public class DistritoEntity implements Serializable {

    @Id
    @Column(name = "iddistrito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "distrito")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idprovincia")
    private ProvinciaEntity provincia;

    @NotEmpty
    @Column(name = "coddistrito")
    private String codigo;

    @JsonIgnore
    @OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IpressEntity> ipresses;

    private static final long serialVersionUID = 1L;

}

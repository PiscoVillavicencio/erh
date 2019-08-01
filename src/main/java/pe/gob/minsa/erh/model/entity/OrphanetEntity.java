package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "orphanet")
public class OrphanetEntity implements Serializable {

    @Id
    @Column(name = "idorphanet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "strorphanet")
    private String nombre;

    @NotEmpty
    @Column(name = "strcodorphanet")
    private String codigo;

    private static final long serialVersionUID = 1L;
}

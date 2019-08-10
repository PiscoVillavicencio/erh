package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "distritos")
public class UbiDistritoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "iddistrito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "distrito")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "idprovincia")
    private UbiProvinciaEntity provincia;
    @NotEmpty
    @Column(name = "coddistrito")
    private String codigo;

}

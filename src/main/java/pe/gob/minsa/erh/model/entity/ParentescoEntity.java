package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "parentesco")
public class ParentescoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idparentesco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "parentesco")
    private String nombre;

}

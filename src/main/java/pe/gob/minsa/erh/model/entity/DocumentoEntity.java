package pe.gob.minsa.erh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "documento")
public class DocumentoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "iddocumento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "documento")
    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PersonaEntity> personas;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

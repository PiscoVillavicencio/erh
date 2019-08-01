package pe.gob.minsa.erh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ipress")
public class IpressEntity implements Serializable {

    @Id
    @Column(name = "idipress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "stripress")
    private String nombre;

    @NotEmpty
    @Column(name = "strcodipress")
    private String codigo;

    @NotEmpty
    @Column(name = "datfregistro")
    private Date fecRegistro;

    @NotEmpty
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

    @NotEmpty
    @Column(name = "chrestado")
    private Boolean estado;

    @NotEmpty
    @Column(name = "strdireccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private DistritoEntity distrito;

    @NotEmpty
    @Column(name = "strtelefono")
    private String telefono;

    @NotEmpty
    @Column(name = "strruc")
    private String ruc;

    @JsonIgnore
    @OneToOne(mappedBy = "ipress")
    private DirectorEntity director;

    private static final long serialVersionUID = 1L;
}

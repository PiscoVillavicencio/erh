package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ipress")
public class IpressEntity implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "strdireccion")
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private UbiDistritoEntity distrito;
    @NotEmpty
    @Column(name = "strtelefono")
    private String telefono;
    @NotEmpty
    @Column(name = "strruc")
    private String ruc;

    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "persona")
public class PersonaEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idpersona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name = "strnombres")
    private String nombre;
    @NotEmpty
    @Column(name = "strapepaterno")
    private String apePaterno;
    @Column(name = "strapematerno")
    private String apeMaterno;
    @Column(name = "datfnacimiento")
    private Date fecNacimiento;
    @ManyToOne
    @JoinColumn(name = "iddocumento")
    private DocumentoEntity documento;
    @NotEmpty
    @Column(name = "strnumdocumento")
    private String nroDocumento;
    @Column(name = "strrutaimagen")
    private String rutaImagen;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private DistritoEntity distrito;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

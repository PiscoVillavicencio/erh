package pe.gob.minsa.erh.model.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.NacionalidadEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrgenero")
    private GeneroEnum genero;
    @Column(name = "strrutaimagen")
    private String rutaImagen;
    @ManyToOne
    @JoinColumn(name = "iddistrito")
    private UbiDistritoEntity distritoNacimiento;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestavivo")
    private EstadoEnum condicion;
    @Column(name = "chrnacionalidad")
    private NacionalidadEnum origenNacionalidad;
    @Column(name = "strpais")
    private String origenPais;
    @Column(name = "strestado")
    private String origenEstado;
    @Column(name = "strciudad")
    private String origenCiudad;
    @Column(name = "strlugarnacimiento")
    private String lugarNacimiento;
    @Column(name = "stremail")
    private String email;
    @ManyToOne
    @JoinColumn(name = "iddistritoactual")
    private UbiDistritoEntity distritoResidencia;
    @Column(name = "strdireccionactual")
    private String direccionActual;
    @Column(name = "strlugarprocedencia")
    private String lugarProcedencia;
    @Column(name = "strtelefonofijo")
    private String telFijo;
    @Column(name = "strtelefonomovil")
    private String telMovil;

    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

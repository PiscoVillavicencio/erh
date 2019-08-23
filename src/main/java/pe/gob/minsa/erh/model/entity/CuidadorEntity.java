package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.NacionalidadEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "cuidador")
public class CuidadorEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idcuidador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "strnombres")
    private String nombre;
    @Column(name = "strapepaterno")
    private String apePaterno;
    @Column(name = "strapematerno")
    private String apeMaterno;
    @Column(name = "datfnacimiento")
    private Date fecNacimiento;
    @ManyToOne
    @JoinColumn(name = "iddocumento")
    private DocumentoEntity documento;
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

    @ManyToOne
    @JoinColumn(name = "idparentesco")
    private ParentescoEntity parentesco;
    @Column(name = "strparentesconinguno")
    private String detalleParentescoNinguno;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrlaboraactualmente")
    private EstadoEnum laboraActualmente;
    @Column(name = "strlugardetrabajo")
    private String detalleLugarDeTrabajo;
    @ManyToOne
    @JoinColumn(name = "idipress")
    private IpressEntity ipress;

    @ManyToMany
    @JoinTable(
            name = "cuidadorxpaciente",
            joinColumns = @JoinColumn(name = "idpaciente"),
            inverseJoinColumns = @JoinColumn(name = "idcuidador")
    )
    private List<PacienteEntity> pacientes;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "idperfil")
    private PerfilEnum perfil;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

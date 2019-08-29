package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.NacionalidadEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto implements Serializable {

    private Long id;

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String fecNacimiento;
    private Integer edad;
    private DocumentoDto documento;
    private String nroDocumento;
    private GeneroEnum genero;
    private String rutaImagen;
    private UbiDistritoDto distritoNacimiento;
    private EstadoEnum condicion;
    private NacionalidadEnum origenNacionalidad;
    private String origenPais;
    private String origenEstado;
    private String origenCiudad;
    private String lugarNacimiento;
    private String email;
    private UbiDistritoDto distritoResidencia;
    private String direccionActual;
    private String lugarProcedencia;
    private String telFijo;
    private String telMovil;

    private MedicoDto medico;

    private IpressDto ipress;

    private List<CuidadorDto> cuidadorDtos;

    private List<AntecedenteFamiliarDto> antecedenteFamiliarDtos;

    private PerfilEnum perfil;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

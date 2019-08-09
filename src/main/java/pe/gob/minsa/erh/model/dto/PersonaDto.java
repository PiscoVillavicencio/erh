package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.NacionalidadEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto implements Serializable {

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
    private DistritoDto distritoNacimiento;
    private EstadoEnum condicion;
    private NacionalidadEnum origenNacionalidad;
    private String origenPais;
    private String origenEstado;
    private String origenCiudad;
    private String lugarNacimiento;
    private String email;
    private DistritoDto distritoResidencia;
    private String direccionActual;
    private String lugarProcedencia;
    private String telFijo;
    private String telMovil;

    private String fecRegistro;
    private String fecModificacion;

}

package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private Long id;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String fecNacimiento;
    private DocumentoDto documento;
    private String nroDocumento;
    private String rutaImagen;
    private DistritoDto distrito;

    private EstadoEnum estado;
    private String origenNacionalidad;
    private String origenPais;
    private String origenEstado;
    private String origenCiudad;
    private String lugarNacimiento;
    private String email;
    private DistritoDto distritoActual;
    private String direccionActual;
    private String lugarProcedencia;
    private String telFijo;
    private String telMovil;

    private String fecRegistro;
    private String fecModificacion;

}

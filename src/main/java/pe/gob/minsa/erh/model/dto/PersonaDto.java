package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String fecRegistro;
    private String fecModificacion;

}

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
public class DocumentoDto {

    private Long id;
    private String nombre;
    private String fecRegistro;
    private String fecModificacion;
    private EstadoEnum estado;

}

package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoEnfermedadDto implements Serializable {

    private Long id;
    private String detalleDocumento;
    private EnfermedadDto enfermedad;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

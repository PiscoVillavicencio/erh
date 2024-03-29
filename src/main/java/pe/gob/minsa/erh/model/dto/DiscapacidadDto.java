package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import java.io.Serializable;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscapacidadDto implements Serializable {


    private Long id;
    private EstadoEnum limitacionFuncional;
    private String detallelimitacionfuncional;
    private EstadoEnum inscritoConadis;
    private String detalleObservaciones;
    private PacienteDto paciente;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

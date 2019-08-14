package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AntecedenteFamiliarDto implements Serializable {

    private Long id;
    private PersonaDto persona;
    private ParentescoDto parentesco;
    private EstadoEnum familiarCondicion;
    private EstadoEnum mismaEnfermedad;
    private String fecDiagnostico;
    private String detalleEnfermedad;
    private PerfilEnum perfil;
    List<PacienteDto> pacientes;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

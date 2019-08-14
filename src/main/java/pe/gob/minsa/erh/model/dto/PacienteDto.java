package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto implements Serializable {

    private Long id;
    private PersonaDto persona;
    private IpressDto ipress;
    private PerfilEnum perfil;
    private List<CuidadorDto> cuidadorDtos;
    private List<AntecedenteFamiliarDto> antecedenteFamiliarDtos;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

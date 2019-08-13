package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDto implements Serializable {

    private Long id;
    private PersonaDto persona;
    private String cmp;
    private String rne;
    private String especialidad;
    private IpressDto ipress;
    private PerfilEnum perfil;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

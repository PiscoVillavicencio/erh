package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cie10CarpetaDto implements Serializable {

    private Long id;
    private String nombre;
    private String codigo;
    private Cie10BloqueDto cie10Bloque;

}

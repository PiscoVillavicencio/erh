package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistritoDto {

    private Long id;
    private String nombre;
    private ProvinciaDto provincia;
    private String codigo;

}

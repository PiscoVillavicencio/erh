package pe.gob.minsa.erh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpressDto {

    private Long id;
    private String nombre;
    private String codigo;
    private String fecRegistro;
    private String fecModificacion;
    private String estado;
    private String direccion;
    private DistritoDto distrito;
    private String telefono;
    private String ruc;

}

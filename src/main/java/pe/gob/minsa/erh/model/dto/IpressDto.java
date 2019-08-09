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
public class IpressDto implements Serializable {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private DistritoDto distrito;
    private String telefono;
    private String ruc;

    private String estado;
    private String fecRegistro;
    private String fecModificacion;

}

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
public class DirectorDto implements Serializable {

    private Long id;
    private String nombre;
    private String fecRegistro;
    private String fecModificacion;
    private String estado;
    private String ipress;
    private String perfil;

}

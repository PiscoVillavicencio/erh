package pe.gob.minsa.erh.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DirectorDto implements Serializable {

    private final Integer id;
    private String nombre;
    private String fecRegistro;
    private String fecModificacion;
    private String estado;
    private String ipress;
    private String perfil;

}

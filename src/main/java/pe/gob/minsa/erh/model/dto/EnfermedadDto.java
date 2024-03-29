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
public class EnfermedadDto implements Serializable {

    private Long id;
    private String detalleDiagnostico;
    private String detalleExamenesAuxiliares;
    private PacienteDto paciente;
    private Cie10CarpetaDto cie10Carpeta;
    private OrphanetDto orphanet;
    private EstadoEnum consentimientoInformado;
    private EstadoEnum diagnosticoClinico;
    private EstadoEnum diagnosticoPorGenetico;
    private EstadoEnum diagnosticoBioquimico;
    private EstadoEnum diagnosticoPorImagenes;
    private EstadoEnum diagnosticoInmunologico;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}

package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.Cie10CarpetaDto;
import pe.gob.minsa.erh.model.entity.Cie10CarpetaEntity;
import pe.gob.minsa.erh.service.Cie10CarpetaService;

@Component
public class Cie10CarpetaConverter extends AbstractConverter<Cie10CarpetaEntity, Cie10CarpetaDto> {

    @Autowired
    private Cie10CarpetaService cie10CarpetaService;

    @Autowired
    private Cie10BloqueConverter cie10BloqueConverter;

    @Override
    protected Cie10CarpetaDto entityToDto(Cie10CarpetaEntity entity) throws Exception {
        return Cie10CarpetaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .cie10Bloque(cie10BloqueConverter.toDto(entity.getCie10Bloque()))
                .build();
    }

    @Override
    protected Cie10CarpetaEntity dtoToEntity(Cie10CarpetaDto dto) throws Exception {

        Cie10CarpetaEntity entity;

        if (dto.getId() == null) {
            entity = new Cie10CarpetaEntity();
        } else {
            entity = cie10CarpetaService.getById(dto.getId());
        }

        return entity;
    }

}

package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.UbiDistritoDto;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;
import pe.gob.minsa.erh.service.UbiDistritoService;

@Component
public class UbiDistritoConverter extends AbstractConverter<UbiDistritoEntity, UbiDistritoDto> {

    @Autowired
    private UbiDistritoService ubiDistritoService;

    @Autowired
    private UbiProvinciaConverter ubiProvinciaConverter;

    @Override
    protected UbiDistritoDto entityToDto(UbiDistritoEntity entity) throws Exception {
        return UbiDistritoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .provincia(ubiProvinciaConverter.toDto(entity.getProvincia()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiDistritoEntity dtoToEntity(UbiDistritoDto dto) throws Exception {

        UbiDistritoEntity entity;

        if (dto.getId() == null) {
            entity = new UbiDistritoEntity();
        } else {
            entity = ubiDistritoService.getById(dto.getId());
        }

        return entity;
    }

}

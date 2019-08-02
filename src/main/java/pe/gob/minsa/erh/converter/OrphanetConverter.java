package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.OrphanetDto;
import pe.gob.minsa.erh.model.entity.OrphanetEntity;
import pe.gob.minsa.erh.service.OrphanetService;

@Component
public class OrphanetConverter extends AbstractConverter<OrphanetEntity, OrphanetDto> {

    @Autowired
    private OrphanetService orphanetService;

    @Override
    protected OrphanetDto entityToDto(OrphanetEntity entity) {
        return OrphanetDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected OrphanetEntity dtoToEntity(OrphanetDto dto) {

        OrphanetEntity entity;

        if (dto.getId() == null) {
            entity = new OrphanetEntity();
        } else {
            entity = orphanetService.getById(dto.getId());
        }

        return entity;
    }

}

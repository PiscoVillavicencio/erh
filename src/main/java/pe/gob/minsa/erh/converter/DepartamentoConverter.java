package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DepartamentoDto;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;
import pe.gob.minsa.erh.service.DepartamentoService;

@Component
public class DepartamentoConverter extends AbstractConverter<DepartamentoEntity, DepartamentoDto> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    protected DepartamentoDto entityToDto(DepartamentoEntity entity) {
        return DepartamentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected DepartamentoEntity dtoToEntity(DepartamentoDto dto) {

        DepartamentoEntity entity;

        if (dto.getId() == null) {
            entity = new DepartamentoEntity();
        }else {
            entity = departamentoService.getById(dto.getId());
        }

        return entity;
    }

}

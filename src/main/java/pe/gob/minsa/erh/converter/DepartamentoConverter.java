package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.UbiDepartamentoDto;
import pe.gob.minsa.erh.model.entity.UbiDepartamentoEntity;
import pe.gob.minsa.erh.service.DepartamentoService;

@Component
public class DepartamentoConverter extends AbstractConverter<UbiDepartamentoEntity, UbiDepartamentoDto> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    protected UbiDepartamentoDto entityToDto(UbiDepartamentoEntity entity) throws Exception {
        return UbiDepartamentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiDepartamentoEntity dtoToEntity(UbiDepartamentoDto dto) throws Exception {

        UbiDepartamentoEntity entity;

        if (dto.getId() == null) {
            entity = new UbiDepartamentoEntity();
        }else {
            entity = departamentoService.getById(dto.getId());
        }

        return entity;
    }

}

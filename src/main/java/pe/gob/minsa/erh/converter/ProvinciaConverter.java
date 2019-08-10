package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.UbiProvinciaDto;
import pe.gob.minsa.erh.model.entity.UbiProvinciaEntity;
import pe.gob.minsa.erh.service.ProvinciaService;

@Component
public class ProvinciaConverter extends AbstractConverter<UbiProvinciaEntity, UbiProvinciaDto> {

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private DepartamentoConverter departamentoConverter;

    @Override
    protected UbiProvinciaDto entityToDto(UbiProvinciaEntity entity) throws Exception {
        return UbiProvinciaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .departamento(departamentoConverter.toDto(entity.getDepartamento()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiProvinciaEntity dtoToEntity(UbiProvinciaDto dto) throws Exception {

        UbiProvinciaEntity entity;

        if (dto.getId() == null) {
            entity = new UbiProvinciaEntity();
        } else {
            entity = provinciaService.getById(dto.getId());
        }

        return entity;
    }

}

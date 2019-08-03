package pe.gob.minsa.erh.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DocumentoDto;
import pe.gob.minsa.erh.model.dto.ParentescoDto;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.model.entity.ParentescoEntity;
import pe.gob.minsa.erh.service.DocumentoService;
import pe.gob.minsa.erh.service.ParentescoService;

@Component
public class ParentescoConverter extends AbstractConverter<ParentescoEntity, ParentescoDto> {

    private ParentescoService parentescoService;

    @Override
    protected ParentescoDto entityToDto(ParentescoEntity entity) {
        return ParentescoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    protected ParentescoEntity dtoToEntity(ParentescoDto dto) {

        ParentescoEntity entity;

        if (dto.getId() == null) {
            entity = new ParentescoEntity();
        } else {
            entity = parentescoService.getById(dto.getId());
        }

        entity.setNombre(getNombre(dto));

        return entity;
    }

    private String getNombre(ParentescoDto dto) {
        if (StringUtils.isNotBlank(dto.getNombre())) {
            return dto.getNombre().trim();
        }
        return "";
    }

}

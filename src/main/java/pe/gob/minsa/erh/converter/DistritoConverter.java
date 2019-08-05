package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DistritoDto;
import pe.gob.minsa.erh.model.entity.DistritoEntity;
import pe.gob.minsa.erh.service.DistritoService;

@Component
public class DistritoConverter extends AbstractConverter<DistritoEntity, DistritoDto> {

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private ProvinciaConverter provinciaConverter;

    @Override
    protected DistritoDto entityToDto(DistritoEntity entity) throws Exception {
        return DistritoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .provincia(provinciaConverter.toDto(entity.getProvincia()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected DistritoEntity dtoToEntity(DistritoDto dto) throws Exception {

        DistritoEntity entity;

        if (dto.getId() == null) {
            entity = new DistritoEntity();
        } else {
            entity = distritoService.getById(dto.getId());
        }

        return entity;
    }

}

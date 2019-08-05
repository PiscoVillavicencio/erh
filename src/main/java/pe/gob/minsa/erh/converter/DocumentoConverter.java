package pe.gob.minsa.erh.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DocumentoDto;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.service.DocumentoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DocumentoConverter extends AbstractConverter<DocumentoEntity, DocumentoDto> {

    @Autowired
    private DocumentoService documentoService;

    @Override
    protected DocumentoDto entityToDto(DocumentoEntity entity) throws Exception {
        return DocumentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado())
                .build();
    }

    @Override
    protected DocumentoEntity dtoToEntity(DocumentoDto dto) throws Exception {

        DocumentoEntity entity;

        if (dto.getId() == null) {
            entity = new DocumentoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = documentoService.getById(dto.getId());
        }

        entity.setNombre(dto.getNombre().trim());
        entity.setFecModificacion(new Date());
        entity.setEstado(dto.getEstado());

        return entity;
    }

}

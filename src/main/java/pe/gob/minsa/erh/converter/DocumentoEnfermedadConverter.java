package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DocumentoEnfermedadDto;
import pe.gob.minsa.erh.model.dto.DocumentoEnfermedadDto;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.service.DocumentoEnfermedadService;
import pe.gob.minsa.erh.service.DocumentoService;
import pe.gob.minsa.erh.service.EnfermedadService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DocumentoEnfermedadConverter extends AbstractConverter<DocumentoEnfermedadEntity, DocumentoEnfermedadDto> {

    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @Autowired
    private DocumentoEnfermedadService documentoEnfermedadService;

    @Autowired
    private EnfermedadService enfermedadService;

    @Override
    protected DocumentoEnfermedadDto entityToDto(DocumentoEnfermedadEntity entity) throws Exception {
        return DocumentoEnfermedadDto.builder()
                .id(entity.getId())
                .detalleDocumento(entity.getDetalleDocumento())
                .enfermedad(enfermedadConverter.toDto(entity.getEnfermedad()))
                
                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected DocumentoEnfermedadEntity dtoToEntity(DocumentoEnfermedadDto dto) throws Exception {

        DocumentoEnfermedadEntity entity;

        if (dto.getId() == null) {
            entity = new DocumentoEnfermedadEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = documentoEnfermedadService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setDetalleDocumento(dto.getDetalleDocumento().trim());
        entity.setEnfermedad(enfermedadService.getById(dto.getEnfermedad().getId()));
        
        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

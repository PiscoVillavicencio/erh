package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.service.DirectorService;

import java.text.SimpleDateFormat;

@Component
public class DirectorConverter extends AbstractConverter<DirectorEntity, DirectorDto> {

    @Autowired
    DirectorService directorService;

    @Override
    protected DirectorDto entityToDto(DirectorEntity entity) {

        return DirectorDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado().getLabel())
                .perfil(entity.getPerfil().getLabel())
                .build();
    }

    @Override
    protected DirectorEntity dtoToEntity(DirectorDto dto) {

        DirectorEntity entity;

        if ((dto.getId() == null)) {
            entity = new DirectorEntity();
        } else {
            entity = directorService.getById(dto.getId());
        }

        entity.setNombre(dto.getNombre());



        return entity;
    }


}

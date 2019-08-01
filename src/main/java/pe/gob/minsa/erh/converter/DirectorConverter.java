package pe.gob.minsa.erh.converter;

import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;

import java.text.SimpleDateFormat;

@Component
public class DirectorConverter extends AbstractConverter<DirectorEntity, DirectorDto> {
    @Override
    protected DirectorDto entityToDto(DirectorEntity entity) {

        return DirectorDto.builder()
                .id((entity.getId().intValue()))
                .nombre(entity.getNombre())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado().getLabel())
                .perfil(entity.getPerfil().getLabel())
                .build();
    }

    @Override
    protected DirectorEntity dtoToEntity(DirectorDto dto) {
        return null;
    }




}

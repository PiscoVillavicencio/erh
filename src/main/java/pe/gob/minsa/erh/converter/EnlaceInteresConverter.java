package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.EnlaceInteresDto;
import pe.gob.minsa.erh.model.dto.EnlaceInteresDto;
import pe.gob.minsa.erh.model.entity.EnlaceInteresEntity;
import pe.gob.minsa.erh.model.entity.EnlaceInteresEntity;
import pe.gob.minsa.erh.repository.EnlaceInteresRepository;
import pe.gob.minsa.erh.service.EnlaceInteresService;
import pe.gob.minsa.erh.service.IpressService;

import java.text.SimpleDateFormat;

@Component
public class EnlaceInteresConverter extends AbstractConverter<EnlaceInteresEntity, EnlaceInteresDto> {

    @Autowired
    private EnlaceInteresService enlaceInteresService;

    @Override
    protected EnlaceInteresDto entityToDto(EnlaceInteresEntity entity) throws Exception {
        return EnlaceInteresDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .url(entity.getUrl())
                .dirigido(entity.getDirigido())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected EnlaceInteresEntity dtoToEntity(EnlaceInteresDto dto) throws Exception {

        EnlaceInteresEntity entity;
        if (dto.getId() == null) {
            entity = new EnlaceInteresEntity();
        } else {
            entity = enlaceInteresService.getById(dto.getId());
        }
        return entity;

    }
}

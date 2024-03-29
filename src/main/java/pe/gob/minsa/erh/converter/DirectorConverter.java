package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.DirectorService;
import pe.gob.minsa.erh.service.IpressService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DirectorConverter extends AbstractConverter<DirectorEntity, DirectorDto> {

    @Autowired
    private DirectorService directorService;
    @Autowired
    private IpressService ipressService;

    @Autowired
    private IpressConverter ipressConverter;

    @Override
    protected DirectorDto entityToDto(DirectorEntity entity) throws Exception {

        return DirectorDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected DirectorEntity dtoToEntity(DirectorDto dto) throws Exception {

        DirectorEntity entity;

        if (dto.getId() == null) {
            entity = new DirectorEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = directorService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre().trim());
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.DIRECTOR);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

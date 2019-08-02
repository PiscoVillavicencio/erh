package pe.gob.minsa.erh.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.IpressEntity;
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
    protected DirectorDto entityToDto(DirectorEntity entity) {

        return DirectorDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado())
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil().getLabel())
                .build();
    }

    @Override
    protected DirectorEntity dtoToEntity(DirectorDto dto) {

        DirectorEntity entity;

        if (dto.getId() == null) {
            entity = new DirectorEntity();
        } else {
            entity = directorService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setNombre(getNombre(dto));
        entity.setFecRegistro(getFecRegistro(dto, entity));
        entity.setFecModificacion(new Date());
        entity.setEstado(dto.getEstado());
        entity.setIpress(getIpress(dto));
        entity.setPerfil(PerfilEnum.DIRECTOR);

        return entity;
    }

    private String getNombre(DirectorDto dto) {
        if (StringUtils.isNotBlank(dto.getNombre())) {
            return dto.getNombre().trim();
        }
        return "";
    }

    private Date getFecRegistro(DirectorDto dto, DirectorEntity entity) {
        if (dto.getId() != null) {
            return entity.getFecRegistro();
        }
        return new Date();
    }

    private IpressEntity getIpress(DirectorDto dto) {

        return ipressService.getById(dto.getIpress().getId());
    }

}

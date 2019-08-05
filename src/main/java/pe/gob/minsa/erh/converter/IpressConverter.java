package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.IpressDto;
import pe.gob.minsa.erh.model.entity.IpressEntity;
import pe.gob.minsa.erh.service.IpressService;

import java.text.SimpleDateFormat;

@Component
public class IpressConverter extends AbstractConverter<IpressEntity, IpressDto> {

    @Autowired
    private IpressService ipressService;

    @Autowired
    private DistritoConverter distritoConverter;

    @Override
    protected IpressDto entityToDto(IpressEntity entity) throws Exception {
        return IpressDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado().getLabel())
                .direccion(entity.getDireccion())
                .distrito(distritoConverter.toDto(entity.getDistrito()))
                .telefono(entity.getTelefono())
                .ruc(entity.getRuc())
                .build();
    }

    @Override
    protected IpressEntity dtoToEntity(IpressDto dto) throws Exception {

        IpressEntity entity;
        if (dto.getId() == null) {
            entity = new IpressEntity();
        } else {
            entity = ipressService.getById(dto.getId());
        }
        return entity;
    }
}

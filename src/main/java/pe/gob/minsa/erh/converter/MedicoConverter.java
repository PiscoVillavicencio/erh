package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.MedicoDto;
import pe.gob.minsa.erh.model.dto.MedicoDto;
import pe.gob.minsa.erh.model.entity.MedicoEntity;
import pe.gob.minsa.erh.model.entity.MedicoEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.DirectorService;
import pe.gob.minsa.erh.service.IpressService;
import pe.gob.minsa.erh.service.MedicoService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MedicoConverter extends AbstractConverter<MedicoEntity, MedicoDto> {

    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private IpressService ipressService;

    @Override
    protected MedicoDto entityToDto(MedicoEntity entity) throws Exception {

        return MedicoDto.builder()
                .id(entity.getId())
                .persona(personaConverter.toDto(entity.getPersona()))
                .cmp(entity.getCmp())
                .rne(entity.getRne())
                .especialidad(entity.getEspecialidad())
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected MedicoEntity dtoToEntity(MedicoDto dto) throws Exception {

        MedicoEntity entity;

        if (dto.getId() == null) {
            entity = new MedicoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = medicoService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setPersona(personaService.getById(dto.getPersona().getId()));
        entity.setCmp(dto.getCmp().trim());
        entity.setRne(dto.getRne().trim());
        entity.setEspecialidad(dto.getEspecialidad().trim());
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.DIRECTOR);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

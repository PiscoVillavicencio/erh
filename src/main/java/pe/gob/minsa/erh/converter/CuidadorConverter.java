package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.CuidadorDto;
import pe.gob.minsa.erh.model.entity.CuidadorEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.CuidadorService;
import pe.gob.minsa.erh.service.IpressService;
import pe.gob.minsa.erh.service.ParentescoService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CuidadorConverter extends AbstractConverter<CuidadorEntity, CuidadorDto> {

    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private ParentescoConverter parentescoConverter;

    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private CuidadorService cuidadorService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ParentescoService parentescoService;

    @Autowired
    private IpressService ipressService;

    @Override
    protected CuidadorDto entityToDto(CuidadorEntity entity) throws Exception {

        return CuidadorDto.builder()
                .id(entity.getId())
                .persona(personaConverter.toDto(entity.getPersona()))
                .parentesco(parentescoConverter.toDto(entity.getParentesco()))
                .detalleParentescoNinguno(entity.getDetalleParentescoNinguno())
                .laboraActualmente(entity.getLaboraActualmente())
                .detalleLugarDeTrabajo(entity.getDetalleLugarDeTrabajo())
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected CuidadorEntity dtoToEntity(CuidadorDto dto) throws Exception {

        CuidadorEntity entity;

        if (dto.getId() == null) {
            entity = new CuidadorEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = cuidadorService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setPersona(personaService.getById(dto.getPersona().getId()));
        entity.setParentesco(parentescoService.getById(dto.getParentesco().getId()));
        entity.setDetalleParentescoNinguno(dto.getDetalleParentescoNinguno().trim());
        entity.setLaboraActualmente(dto.getLaboraActualmente());
        entity.setDetalleLugarDeTrabajo(dto.getDetalleLugarDeTrabajo().trim());
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.CUIDADOR);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

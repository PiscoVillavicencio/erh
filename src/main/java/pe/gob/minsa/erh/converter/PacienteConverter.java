package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.dto.PacienteDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PacienteConverter extends AbstractConverter<PacienteEntity, PacienteDto> {

    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private CuidadorConverter cuidadorConverter;

    @Autowired
    private AntecedenteFamiliarConverter antecedenteFamiliarConverter;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private IpressService ipressService;

    @Autowired
    private CuidadorService cuidadorService;

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;


    @Override
    protected PacienteDto entityToDto(PacienteEntity entity) throws Exception {
        return PacienteDto.builder()
                .id(entity.getId())
                .persona(personaConverter.toDto(entity.getPersona()))
                .ipress(ipressConverter.toDto(entity.getIpress()))
                .perfil(entity.getPerfil())
                .cuidadorDtos(cuidadorConverter.toListDto(cuidadorService.findCuidadorEntitiesByPacientes(entity)))
                .antecedenteFamiliarDtos(antecedenteFamiliarConverter.toListDto(antecedenteFamiliarService.findAntecedenteFamiliarEntitiesByPacientes(entity)))

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected PacienteEntity dtoToEntity(PacienteDto dto) throws Exception {

        PacienteEntity entity;

        if (dto.getId() == null) {
            entity = new PacienteEntity();
            entity.setFecRegistro(new Date());
        }else {
            entity = pacienteService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setPersona(personaService.getById(dto.getPersona().getId()));
        entity.setIpress(ipressService.getById(dto.getIpress().getId()));
        entity.setPerfil(PerfilEnum.PACIENTE);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

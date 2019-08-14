package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.AntecedenteFamiliarDto;
import pe.gob.minsa.erh.model.entity.AntecedenteFamiliarEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.AntecedenteFamiliarService;
import pe.gob.minsa.erh.service.ParentescoService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AntecedenteFamiliarConverter extends AbstractConverter<AntecedenteFamiliarEntity, AntecedenteFamiliarDto> {

    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private ParentescoConverter parentescoConverter;

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ParentescoService parentescoService;


    @Override
    protected AntecedenteFamiliarDto entityToDto(AntecedenteFamiliarEntity entity) throws Exception {
        return AntecedenteFamiliarDto.builder()
                .id(entity.getId())
                .persona(personaConverter.toDto(entity.getPersona()))
                .parentesco(parentescoConverter.toDto(entity.getParentesco()))
                .familiarCondicion(entity.getFamiliarCondicion())
                .mismaEnfermedad(entity.getMismaEnfermedad())
                .fecDiagnostico(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecDiagnostico()))
                .detalleEnfermedad(entity.getDetalleEnfermedad())
                .perfil(entity.getPerfil())

                .estado(entity.getEstado())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected AntecedenteFamiliarEntity dtoToEntity(AntecedenteFamiliarDto dto) throws Exception {

        AntecedenteFamiliarEntity entity;

        if (dto.getId() == null) {
            entity = new AntecedenteFamiliarEntity();
            entity.setFecRegistro(new Date());
        }else {
            entity = antecedenteFamiliarService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setPersona(personaService.getById(dto.getPersona().getId()));
        entity.setParentesco(parentescoService.getById(dto.getParentesco().getId()));
        entity.setFamiliarCondicion(dto.getFamiliarCondicion());
        entity.setMismaEnfermedad(dto.getMismaEnfermedad());
        entity.setFecDiagnostico(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getFecDiagnostico()));
        entity.setDetalleEnfermedad(entity.getDetalleEnfermedad().trim());
        entity.setPerfil(PerfilEnum.ANTECEDENTE_FAMILIAR);

        entity.setEstado(dto.getEstado());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

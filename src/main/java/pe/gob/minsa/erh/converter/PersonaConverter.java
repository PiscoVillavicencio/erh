package pe.gob.minsa.erh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PersonaConverter extends AbstractConverter<PersonaEntity, PersonaDto> {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private DistritoConverter distritoConverter;

    @Override
    protected PersonaDto entityToDto(PersonaEntity entity) throws Exception {

        return PersonaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apePaterno(entity.getApePaterno())
                .apeMaterno(entity.getApeMaterno())
                .fecNacimiento(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecNacimiento()))
                .documento(documentoConverter.toDto(entity.getDocumento()))
                .nroDocumento(entity.getNroDocumento())
                .rutaImagen(entity.getRutaImagen())
                .distrito(distritoConverter.toDto(entity.getDistrito()))

                .estado(entity.getEstado())
                .origenNacionalidad(entity.getOrigenNacionalidad())
                .origenPais(entity.getOrigenPais())
                .origenEstado(entity.getOrigenEstado())
                .origenCiudad(entity.getOrigenCiudad())
                .lugarNacimiento(entity.getLugarNacimiento())
                .email(entity.getEmail())
                .distritoActual(distritoConverter.toDto(entity.getDistritoActual()))
                .direccionActual(entity.getDireccionActual())
                .lugarProcedencia(entity.getLugarProcedencia())
                .telFijo(entity.getTelFijo())
                .telMovil(entity.getTelMovil())

                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .build();
    }

    @Override
    protected PersonaEntity dtoToEntity(PersonaDto dto) throws Exception {

        PersonaEntity entity;

        if (dto.getId() == null) {
            entity = new PersonaEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = personaService.getById(dto.getId());
        }

        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre().trim());
        entity.setApePaterno(dto.getApePaterno().trim());
        entity.setApeMaterno(dto.getApeMaterno().trim());
        entity.setFecNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getFecNacimiento()));
        entity.setDocumento(documentoConverter.toEntity(dto.getDocumento()));
        entity.setNroDocumento(entity.getNroDocumento());
        entity.setRutaImagen(entity.getRutaImagen());

        entity.setEstado(dto.getEstado());
        entity.setOrigenNacionalidad(dto.getOrigenNacionalidad());
        entity.setOrigenPais(dto.getOrigenPais());
        entity.setOrigenEstado(dto.getOrigenEstado());
        entity.setOrigenCiudad(dto.getOrigenCiudad());
        entity.setLugarNacimiento(dto.getLugarNacimiento());
        entity.setEmail(dto.getEmail());
        entity.setDistritoActual(distritoConverter.toEntity(dto.getDistritoActual()));
        entity.setDireccionActual(dto.getDireccionActual());
        entity.setLugarProcedencia(dto.getLugarProcedencia());
        entity.setTelFijo(dto.getTelFijo());
        entity.setTelMovil(dto.getTelMovil());

        entity.setDistrito(distritoConverter.toEntity(dto.getDistrito()));
        entity.setFecModificacion(new Date());

        return entity;
    }

}

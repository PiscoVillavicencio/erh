package pe.gob.minsa.erh.converter;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.minsa.erh.common.AbstractConverter;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.service.UbiDistritoService;
import pe.gob.minsa.erh.service.DocumentoService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PersonaConverter extends AbstractConverter<PersonaEntity, PersonaDto> {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private UbiDistritoService ubiDistritoService;

    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;

    @Override
    protected PersonaDto entityToDto(PersonaEntity entity) throws Exception {

        return PersonaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apePaterno(entity.getApePaterno())
                .apeMaterno(entity.getApeMaterno())
                .fecNacimiento(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecNacimiento()))
                .edad(Years.yearsBetween(new DateTime(entity.getFecNacimiento()), new DateTime()).getYears())
                .documento(documentoConverter.toDto(entity.getDocumento()))
                .nroDocumento(entity.getNroDocumento())
                .genero(entity.getGenero())
                .rutaImagen(entity.getRutaImagen())
                .distritoNacimiento(ubiDistritoConverter.toDto(entity.getDistritoNacimiento()))
                .condicion(entity.getCondicion())
                .origenNacionalidad(entity.getOrigenNacionalidad())
                .origenPais(entity.getOrigenPais())
                .origenEstado(entity.getOrigenEstado())
                .origenCiudad(entity.getOrigenCiudad())
                .lugarNacimiento(entity.getLugarNacimiento())
                .email(entity.getEmail())
                .distritoResidencia(ubiDistritoConverter.toDto(entity.getDistritoResidencia()))
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
        entity.setDocumento(documentoService.getById(dto.getDocumento().getId()));
        entity.setNroDocumento(dto.getNroDocumento());
        entity.setGenero(dto.getGenero());
        entity.setRutaImagen(entity.getRutaImagen());
        entity.setDistritoNacimiento(ubiDistritoService.getById(dto.getDistritoNacimiento().getId()));
        entity.setCondicion(dto.getCondicion());
        entity.setOrigenNacionalidad(dto.getOrigenNacionalidad());
        entity.setOrigenPais(dto.getOrigenPais());
        entity.setOrigenEstado(dto.getOrigenEstado());
        entity.setOrigenCiudad(dto.getOrigenCiudad());
        entity.setLugarNacimiento(dto.getLugarNacimiento());
        entity.setEmail(dto.getEmail());
        entity.setDistritoResidencia(ubiDistritoService.getById(dto.getDistritoResidencia().getId()));
        entity.setDireccionActual(dto.getDireccionActual());
        entity.setLugarProcedencia(dto.getLugarProcedencia());
        entity.setTelFijo(dto.getTelFijo());
        entity.setTelMovil(dto.getTelMovil());
        entity.setFecModificacion(new Date());

        return entity;
    }

}

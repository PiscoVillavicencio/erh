package pe.gob.minsa.erh.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import pe.gob.minsa.erh.model.enums.EstadoEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tratamiento")
public class TratamientoEntity {

    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "idtratamiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrtratamientofarmacologicoespecifico")
    private EstadoEnum tratamientoFarmacologicoEspecifico;
    @Column(name = "strtratamientofarmacologicoespecifico")
    private String detalleTratamientoFarmacologicoEspecifico;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrtratamientofarmacologiconoespecifico")
    private EstadoEnum tratamientoFarmacologicoNoEspecifico;
    @Column(name = "strtratamientofarmacologiconoespecifico")
    private String detalleTratamientoFarmacologicoNoEspecifico;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrtratamientonofarmacologico")
    private EstadoEnum tratamientoNoFarmacologico;
    @Column(name = "strtratamientonofarmacologico")
    private String detalleTratamientoNoFarmacologico;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrterapiafisica")
    private EstadoEnum terapiaFisica;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrergoterapia")
    private EstadoEnum ergoterapia;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrterapianutricionalespecifica")
    private EstadoEnum terapiaNutricionalEspecifica;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrmedicinatradicional")
    private EstadoEnum medicinaTradicional;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrmedicinaalternativacomplementaria")
    private EstadoEnum medicinaAlternativa;
    @ManyToOne
    @JoinColumn(name = "idenfermedad")
    private EnfermedadEntity enfermedad;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "chrestado")
    private EstadoEnum estado;
    @Column(name = "datfregistro")
    private Date fecRegistro;
    @Column(name = "datfmodificacion")
    private Date fecModificacion;

}

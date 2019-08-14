$(document).ready(function() {
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    $('.table').DataTable({
        responsive: true
    });

    <!-- Initialize Toggle Estado-->
    $(function() {
        $('.toggle-estado').bootstrapToggle();

        if ($('#estado').val() === 'ACTIVO') {
            $('.toggle-estado').bootstrapToggle('on')
        } else {
            $('.toggle-estado').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-estado').change(function() {
            $('#estado').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle Condicion-->
    $(function() {
        $('.toggle-condicion').bootstrapToggle();

        if ($('#condicion').val() === 'ACTIVO') {
            $('.toggle-condicion').bootstrapToggle('on')
        } else {
            $('.toggle-condicion').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-condicion').change(function() {
            $('#condicion').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoFarmacologicoEspecifico-->
    $(function() {
        $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle();

        if ($('#tratamientoFarmacologicoEspecifico').val() === 'ACTIVO') {
            $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoFarmacologicoEspecifico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoFarmacologicoEspecifico').change(function() {
            $('#tratamientoFarmacologicoEspecifico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoFarmacologicoNoEspecifico-->
    $(function() {
        $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle();

        if ($('#tratamientoFarmacologicoNoEspecifico').val() === 'ACTIVO') {
            $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoFarmacologicoNoEspecifico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoFarmacologicoNoEspecifico').change(function() {
            $('#tratamientoFarmacologicoNoEspecifico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle tratamientoNoFarmacologico-->
    $(function() {
        $('.toggle-tratamientoNoFarmacologico').bootstrapToggle();

        if ($('#tratamientoNoFarmacologico').val() === 'ACTIVO') {
            $('.toggle-tratamientoNoFarmacologico').bootstrapToggle('on')
        } else {
            $('.toggle-tratamientoNoFarmacologico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-tratamientoNoFarmacologico').change(function() {
            $('#tratamientoNoFarmacologico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle terapiaFisica-->
    $(function() {
        $('.toggle-terapiaFisica').bootstrapToggle();

        if ($('#terapiaFisica').val() === 'ACTIVO') {
            $('.toggle-terapiaFisica').bootstrapToggle('on')
        } else {
            $('.toggle-terapiaFisica').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-terapiaFisica').change(function() {
            $('#terapiaFisica').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle ergoterapia-->
    $(function() {
        $('.toggle-ergoterapia').bootstrapToggle();

        if ($('#ergoterapia').val() === 'ACTIVO') {
            $('.toggle-ergoterapia').bootstrapToggle('on')
        } else {
            $('.toggle-ergoterapia').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-ergoterapia').change(function() {
            $('#ergoterapia').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle terapiaNutricionalEspecifica-->
    $(function() {
        $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle();

        if ($('#terapiaNutricionalEspecifica').val() === 'ACTIVO') {
            $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle('on')
        } else {
            $('.toggle-terapiaNutricionalEspecifica').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-terapiaNutricionalEspecifica').change(function() {
            $('#terapiaNutricionalEspecifica').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle medicinaTradicional-->
    $(function() {
        $('.toggle-medicinaTradicional').bootstrapToggle();

        if ($('#medicinaTradicional').val() === 'ACTIVO') {
            $('.toggle-medicinaTradicional').bootstrapToggle('on')
        } else {
            $('.toggle-medicinaTradicional').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-medicinaTradicional').change(function() {
            $('#medicinaTradicional').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle medicinaAlternativa-->
    $(function() {
        $('.toggle-medicinaAlternativa').bootstrapToggle();

        if ($('#medicinaAlternativa').val() === 'ACTIVO') {
            $('.toggle-medicinaAlternativa').bootstrapToggle('on')
        } else {
            $('.toggle-medicinaAlternativa').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-medicinaAlternativa').change(function() {
            $('#medicinaAlternativa').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle consentimientoInformado-->
    $(function() {
        $('.toggle-consentimientoInformado').bootstrapToggle();

        if ($('#consentimientoInformado').val() === 'ACTIVO') {
            $('.toggle-consentimientoInformado').bootstrapToggle('on')
        } else {
            $('.toggle-medicinaAlternativa').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-consentimientoInformado').change(function() {
            $('#consentimientoInformado').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoClinico-->
    $(function() {
        $('.toggle-diagnosticoClinico').bootstrapToggle();

        if ($('#diagnosticoClinico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoClinico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoClinico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoClinico').change(function() {
            $('#diagnosticoClinico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoPorGenetico-->
    $(function() {
        $('.toggle-diagnosticoPorGenetico').bootstrapToggle();

        if ($('#diagnosticoPorGenetico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoPorGenetico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoPorGenetico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoPorGenetico').change(function() {
            $('#diagnosticoPorGenetico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoBioquimico-->
    $(function() {
        $('.toggle-diagnosticoBioquimico').bootstrapToggle();

        if ($('#diagnosticoBioquimico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoBioquimico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoBioquimico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoBioquimico').change(function() {
            $('#diagnosticoBioquimico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoPorImagenes-->
    $(function() {
        $('.toggle-diagnosticoPorImagenes').bootstrapToggle();

        if ($('#diagnosticoPorImagenes').val() === 'ACTIVO') {
            $('.toggle-diagnosticoPorImagenes').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoPorImagenes').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoPorImagenes').change(function() {
            $('#diagnosticoPorImagenes').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Initialize Toggle diagnosticoInmunologico-->
    $(function() {
        $('.toggle-diagnosticoInmunologico').bootstrapToggle();

        if ($('#diagnosticoInmunologico').val() === 'ACTIVO') {
            $('.toggle-diagnosticoInmunologico').bootstrapToggle('on')
        } else {
            $('.toggle-diagnosticoInmunologico').bootstrapToggle('off')
        }
        <!-- Toogle Event Propagation -->
        $('.toggle-diagnosticoInmunologico').change(function() {
            $('#diagnosticoInmunologico').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
    });

    <!-- Radio Options Reset-->
    $(function() {
        $(".rdoption").click(function(){
            $(".rdoption").prop("checked", false);
        });
    });

});

<!-- Select Ipress Event -->
function checkIpress(id, nombre) {
    $('input[id="ipress.id"]').val(id);
    $('input[id="ipress.nombre"]').val(nombre);
    $('#ipressModal').modal('hide');
}

<!-- Select Disitrito Nacimiento Event -->
function checkDistritoNacimiento(id, nombre) {
    $('input[id="distritoNacimiento.id"]').val(id);
    $('input[id="distritoNacimiento.nombre"]').val(nombre);
    $('#distritoNacimientoModal').modal('hide');
}

<!-- Select Disitrito Residencia Event -->
function checkDistritoResidencia(id, nombre) {
    $('input[id="distritoResidencia.id"]').val(id);
    $('input[id="distritoResidencia.nombre"]').val(nombre);
    $('#distritoResidenciaModal').modal('hide');
}

<!-- Select Persona Event -->
function checkPersona(id, nombre, apePaterno, apeMaterno, tipoDoc, nroDoc, genero) {

    let info =  tipoDoc + ': ' + nroDoc + ', ' + nombre + ' ' + apePaterno + ' ' + apeMaterno;
    $('input[id="txtPersonaInfo"]').val(info);

    $('input[id="persona.id"]').val(id);
    $('input[id="persona.nombre"]').val(nombre);
    $('input[id="persona.apePaterno"]').val(apePaterno);
    $('input[id="persona.apeMaterno"]').val(apeMaterno);
    $('input[id="persona.documento.nombre"]').val(tipoDoc);
    $('input[id="persona.nroDocumento"]').val(nroDoc);
    $('input[id="persona.genero.label"]').val(genero);

    $('#personaModal').modal('hide');
}










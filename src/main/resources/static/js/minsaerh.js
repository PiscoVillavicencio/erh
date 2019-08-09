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
            $('#estado').val($(this).prop('checked') ? 'ACTIVO' : 'INACTIVO')
        })
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










$(document).ready(function() {
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    $('.table').DataTable({
        responsive: true
    });

    <!-- Initialize Toggle -->
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


});

<!-- Select Ipress Event -->
function checkIpress(id, nombre) {
    $('input[id="ipress.id"]').val(id);
    $('input[id="ipress.nombre"]').val(nombre);
    $('#myModal').modal('hide');
}










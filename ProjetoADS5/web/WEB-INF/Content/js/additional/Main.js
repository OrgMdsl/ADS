var pageLoaded = false;
var numero_aux = 0;
$(document).ready(function () {
    if (!pageLoaded) {
        $("#page-wrapper").hide(0);
        $("#page-wrapper").fadeIn(600);
        pageLoaded = true;



        $("span.ativo").click(function () {

            $(this).replaceWith(Componente.Icones.Ativar("", ""));

        });

        $("span.inativo").click(function () {

            $(this).replaceWith(Componente.Icones.Desativar("", ""));

        });
        
        $("table").on('click', '.excluir', function () {
            $("table").DataTable()
                    .row($(this).parents('tr'))
                    .remove()
                    .draw();
        });
    }
});

function modal(data)
{
    var html = "<div class=\"modal fade\" id=\"modalMsg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">" +
            "    <div class=\"modal-dialog\" role=\"document\">" +
            "        <div class=\"modal-content\">" +
            "            <div class=\"modal-header\">" +
            "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
            "                <h4 class=\"modal-title\" id=\"myModalLabel\">" + data.titulo + "</h4>" +
            "            </div>" +
            "            <div class=\"modal-body\">" +
            data.corpo +
            "            </div>" +
            "            <div class=\"modal-footer\">" +
            "                <button type=\"button\" class=\"btn btn-primary\" onclick=\"\">Ok</button>" +
            "                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>" +
            "            </div>" +
            "        </div>" +
            "    </div>" +
            "</div>";

    $('body').append(html);
    $("#modalMsg").modal("show");
}

function getNumero() {
    numero_aux++;
    return numero_aux;
}


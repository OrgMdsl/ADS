/* global Componente */

var pageLoaded = false;
var numero_aux = 0;
$(document).ready(function () {
    if (!pageLoaded) {
        $("#page-wrapper").hide(0);
        $("#page-wrapper").fadeIn(0);
        pageLoaded = true;

        
    }
});

function modal(titulo, corpo)
{
    var html = "<div class=\"modal fade\" id=\"modalMsg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">" +
            "    <div class=\"modal-dialog\" role=\"document\">" +
            "        <div class=\"modal-content\">" +
            "            <div class=\"modal-header\">" +
            "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
            "                <h4 class=\"modal-title\" id=\"myModalLabel\">" + titulo + "</h4>" +
            "            </div>" +
            "            <div class=\"modal-body\">" +
            corpo +
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

function abrirPaginaSemRefresh(url) {
    Componente.Loading.Show();
    $.ajax({
        url: url,
        type: 'POST',
        async: false,
        cache: false,
        contentType: "text/html; charset=utf-8",
        processData: false,
        success: function (data, textStatus, jqXHR) {
            document.open();
            document.write(data);
            document.close();
            //Componente.Loading.Remove();
        },
        erro: function () {
            Componente.Loading.Remove();
            modal("Atenção", "Não foi possível carregar essa página...");
        }
    });
}

function abrirPagina(url) {
    Componente.Loading.Show();
    $.ajax({
        url: url,
        type: 'POST',
        async: false,
        cache: false,
        contentType: "text/html; charset=utf-8",
        processData: false,
        success: function (data, textStatus, jqXHR) {
            $("#page-wrapper").fadeOut(200, function () {
                document.location.href = url;
            });
            
            //Componente.Loading.Remove();
        },
        erro: function () {
            Componente.Loading.Remove();
            modal("Atenção", "Não foi possível carregar essa página...");
        }
    });
}

function getNumero() {
    numero_aux++;
    return numero_aux;
}

function eventoExcluirItem(tabela, tabelaDT) {
    tabela.on('click', '.excluir', function () {
            tabelaDT
                    .row($(this).parents('tr'))
                    .remove()
                    .draw();
        });
}
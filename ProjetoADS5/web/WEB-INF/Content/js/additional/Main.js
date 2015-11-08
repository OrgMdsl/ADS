/* global Componente, Modais, Util */

var pageLoaded = false;
var numero_aux_global = 0;
$(document).ready(function () {
    if (!pageLoaded) {
        $("#page-wrapper").fadeIn(500);
        pageLoaded = true;


    }
});

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
            Modais.Get.Erro("Não foi possível carregar essa página...", function (obj) {
                $(obj.idModal).modal("hide");
            }).modal("show");
        }
    });
}

function abrirPagina(url) {
    $.ajax({
        url: url,
        contentType: "text/html; charset=utf-8",
        success: function (data, textStatus, jqXHR) {
            $("#page-wrapper").fadeOut(200, function () {
                document.location.href = url;
            });
        },
        erro: function () {
            Componente.Loading.Remove();
            Modais.Get.Erro("Não foi possível carregar essa página...", function (obj) {
                fecharModal(obj.idModal);
            }).modal("show");
        }
    });
}

function getNumero() {
    numero_aux_global++;
    return numero_aux_global;
}

function eventoExcluirItem(tabela, tabelaDT) {
    tabela.on(
            'click',
            '.excluir',
            function () {
                var row = $(this).parents('tr');
                tabelaDT
                        .row(row)
                        .remove()
                        .draw();
            });
}
function _eventoExcluirItemAcao(tabelaDT, row) {

}
function eventoExcluirItemSemModal(tabela, tabelaDT) {
    var row = $(tabela).parents('tr');
    tabelaDT
            .row(row)
            .remove()
            .draw();
}
function fecharModal(_modal, finishCallback) {
    $(_modal).on('hidden.bs.modal', function (e) {
        $(_modal).remove();

        if (!Util.IsNull(finishCallback))
            finishCallback();
    });
    $(_modal).modal("hide");
}

/* global Componente, Modais, Util */

var pageLoaded = false;
var numero_aux_global = 0;
$(document).ready(function () {
    if (!pageLoaded) {
        $("#page-wrapper").hide(0);
        $("#page-wrapper").fadeIn(0);
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
            Modais.Get.Erro("Não foi possível carregar essa página...", function (obj) {
                $(obj.idModal).modal("hide");
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
                Modais.Get.Confirmacao("Deseja realmente excluir este item?", function (obj) {
                    fecharModal(obj.idModal, function () {
                        tabelaDT
                                .row(row)
                                .remove()
                                .draw();
                    });
                  
                }, function (obj) {
                    fecharModal(obj.idModal);
                }).modal("show");
            });
}
function fecharModal(_modal, finishCallback) {
    $(_modal).on('hidden.bs.modal', function (e) {
        $(_modal).remove();

        if (!Util.IsNull(finishCallback))
            finishCallback();
    });
    $(_modal).modal("hide");
}

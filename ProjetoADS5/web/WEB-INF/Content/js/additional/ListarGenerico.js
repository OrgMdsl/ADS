/* global Util, Componente, Const, Modais */

$(document).ready(function () {

    ListarGenerico.montaTabela();

});

var ListarGenerico = (function () {

    function ListarGenerico() {
    }

    ListarGenerico.montaTabela = function () {
        $('#listagem').DataTable({
            "ajax": {
                "url": "ListarGenerico",
                "pages": 5,
                "dataSrc": ""
            },
            "deferRender": true,
            "columns": [
                {
                    "title": "Id",
                    "data": "id",
                    "width": "10%"
                },
                {
                    "title": "Nome",
                    "data": "nome",
                    "width": "30%"
                },
                {
                    "title": "Descrição",
                    "data": "descricao",
                    "width": "40%"
                },
                {
                    "title": "Ações",
                    "width": "20%",
                    "render": function (data, type, row) {
                        return montaAcoes(row);
                    }
                }
            ]
        });
    };

    function montaAcoes(row) {
        if (!Util.IsNull(row)) {
            var c = //Componente.Icones.Visualizar("PaginaVisualizarGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id) +
                    Componente.Icones.Editar("PaginaEditarGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id);
                c += Componente.Icones.Excluir("javascript:ListarGenerico.excluiGenerico(" + row.id + ")", "");
            return c;
        }
        return Const.Messages.ERRO_1;
    }
    
    
     ListarGenerico.excluiGenerico = function (id) {
        Modais.Get.Confirmacao("Deseja realmente excluir este tópico e todo o seu conteúdo?", "ListarGenerico.confirmaExcluir(" + id + ")", null).modal("show");
    };

    ListarGenerico.confirmaExcluir = function (id) {
        
        $.ajax({
            url: "ExcluirGenerico?id=" + id,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                abrirPaginaSemRefresh(window.location);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                abrirPaginaSemRefresh(window.location);
                Componente.Loading.Remove();
            }
        });
    };
    
    return ListarGenerico;
}());
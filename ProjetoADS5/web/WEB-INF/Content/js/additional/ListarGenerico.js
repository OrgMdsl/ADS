/* global Util, Componente, Const */

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
            var c = Componente.Icones.Visualizar("PaginaVisualizarGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id) +
                    Componente.Icones.Editar("PaginaEditarGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id);
            if (!row.ativo)
                c += Componente.Icones.Ativar("", "AlterarStatusGenerico?id=" + row.id);
            else
                c += Componente.Icones.Desativar("", "AlterarStatusGenerico?id=" + row.id);
            return c;
        }
        return Const.Messages.ERRO_1;
    }

    return ListarGenerico;
}());
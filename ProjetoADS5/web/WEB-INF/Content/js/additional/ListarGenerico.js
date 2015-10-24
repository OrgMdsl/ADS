var isEdicao = false;
var itens = new Array();
$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenOperacao").val()) ? false : true;

    $("#listagem-Generico").DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'ListarGenerico',
            pages: 5,
            dataSrc: ""
        },
        columns: [
            {
                width: '10%',
                title: 'Id',
                data: 'idGenerico'
            },
            {
                width: '40%',
                title: 'Nome',
                data: 'nome'
            },
            {
                width: '40%',
                title: 'Descrição',
                data: 'descricao'
            },
            {
                width: '10%',
                title: 'Ações',
                render: function (data, type, full) {
                    var c = Componente.Icones.Visualizar("")
                            + Componente.Icones.Editar("")
                            + Componente.Icones.Excluir("");
                    if (!Util.IsNull(data.ativo) && !data.ativo)
                        c += Componente.Icones.Ativar("");
                    else
                        c += Componente.Icones.Desativar("");
                    return c;
                }
            }
        ]
    });


});
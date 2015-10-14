$(document).ready(function () {
    $("#listagem-CoreGenerico").DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'ListaCoreGenerico',
            pages: 5,
            dataSrc: ""
        },
        columns: [
            {
                title: 'Id',
                data: 'idGenerico'
            },
            {
                title: 'Nome',
                data: 'nome'
            },
            {
                title: 'Descrição',
                data: 'descricao'
            },
            {
                title: 'Ações',
                render: function (data, type, full) {
                    var botoes = Componente.Botoes.Visualizar("");
                    botoes += Componente.Botoes.Editar("");
                    botoes += Componente.Botoes.Excluir("");
                    botoes += Componente.Botoes.Recuperar("");
                    botoes += Componente.Botoes.Ativar("");
                    botoes += Componente.Botoes.Desativar("");
                    return botoes;
                }
            }
        ]
    });
});

$(document).ready(function () {
    $("#listagem-CoreGenerico").DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'ListaCoreGenerico',
            pages: 5,
            dataSrc: ''

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
                    return '<b>Teste</b>';
                }
            }
        ]
    });
});

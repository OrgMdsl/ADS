$(document).ready(function () {
    $("#listagem").DataTable({
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
                data: 'id'
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
                render: function (data) {
                    if (!Util.IsNull(data)) {
                        var c = Componente.Icones.Visualizar("")
                                + Componente.Icones.Editar("");
                        if (!Util.IsNull(data.ativo) && !data.ativo)
                            c += Componente.Icones.Ativar("");
                        else
                            c += Componente.Icones.Desativar("");
                        return c;
                    }
                }
            }
        ]
    });
});
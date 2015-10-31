$(document).ready(function () {
    $("#listagem-Fabricante").DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'ListarFabricante',
            pages: 5,
            dataSrc: ""
        },
        columns: [
            {
                width: '90%',
                title: 'Descrição',
                data: 'descricao'
            },
            {
                width: '10%',
                title: 'Ações',
                render: function (data, type, full) {
                    var c = Componente.Icones.Visualizar("")
                            + Componente.Icones.Editar("");
                    //+ Componente.Icones.Excluir("");
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
$(document).ready(function () {

    //Tela ListagemCoreGenerico
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
                    return Componente.Icones.Visualizar("")
                            + Componente.Icones.Editar("")
                            + Componente.Icones.Excluir("")
                            + Componente.Icones.Ativar("")
                            + Componente.Icones.Desativar("");

                }
            }
        ]
    });

    //Tela CadastroCoreGenerico
    var tabela_itens = $('#listagem-CoreGenericoItem').DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'BuscaCoreGenerico?id=' + $("id").val(),
            pages: 5,
            dataSrc: "coreGenericoItems"
        },
        columns: [
            {
                width: '40%',
                title: 'Descrição',
                data: 'descricao'
            },
            {
                width: '40%',
                title: 'Sigla',
                data: 'sigla'
            },
            {
                width: '20%',
                title: 'Ações',
                render: function (data, type, full) {
                    return Componente.Icones.Editar("PaginaCadastroCoreGenerico?id=" + data.id + "&op=E")
                            + Componente.Icones.Excluir("");
                }
            }
        ]
    });

    //Tela CadastroCoreGenerico
    $('#btn-add-item').on('click', function () {
        tabela_itens.row.add([
            $("#itemDescricao").val(),
            $("#itemSigla").val(),
            Componente.Icones.Editar("") + Componente.Icones.Ativar("")
        ]).draw(false);
    });
});
